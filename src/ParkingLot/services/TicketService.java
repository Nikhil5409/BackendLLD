package ParkingLot.services;

import ParkingLot.models.*;
import ParkingLot.repositories.GateRepository;
import ParkingLot.repositories.ParkingLotRepository;
import ParkingLot.repositories.TicketRepository;
import ParkingLot.repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(Long gateId, String licensePlateNumber, String ownerName, VehicleType vehicleType, Long parkingLotId){
        // 1) get the gate details using gateId
        Optional<Gate> gateOptional =gateRepository.findGateByGateId(gateId);
        if(gateOptional.isEmpty()){
            throw new RuntimeException("Invalid Gate Id");
        }
        Gate gate = gateOptional.get();

        // 2) get the vehicle details, if details not present, create a new object of that vehicle
        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByLicensePlateNumber(licensePlateNumber);
        Vehicle vehicleInfo = null;
        if(vehicleOptional.isEmpty()){
            vehicleInfo = new Vehicle();
            vehicleInfo.setVehicleType(vehicleType);
            vehicleInfo.setLicensePlate(licensePlateNumber);
            vehicleInfo.setOwnerName(ownerName);
            // we need to save new vehicle details to db
            vehicleRepository.save(vehicleInfo);
        }else{
            vehicleInfo = vehicleOptional.get();
        }
        // 3) assign a slot
        // here synchronization issue might occur, race conditions when 2 operators may assign same slot at diff gates
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findParkingLotById(parkingLotId);
        if(parkingLotOptional.isEmpty()){
            throw new RuntimeException("invalid parking lot id");
        }
        ParkingLot parkingLot = parkingLotOptional.get();
        ParkingSlot parkingSlot = parkingLot.getSlotAssignmentStrategy().assignSlot(parkingLot, vehicleType);
        if(parkingSlot == null){
            throw new RuntimeException("Parking Lot Full");
        }
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.FILLED);
        // 4) create a new ticket object, set attributes
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setOperator(gate.getCurrentOperator());
        ticket.setParkingSlot(parkingSlot);
        ticket.setVehicle(vehicleInfo);
        ticket.setEntryGate(gate);
        ticket.setFeeCalculationStrategy(parkingLot.getFeeCalculationStrategy());
        ticket.setParkingFloor(parkingSlot.getParkingFloor());

        // 5) return the ticket object
        return ticketRepository.save(ticket);
    }
}
