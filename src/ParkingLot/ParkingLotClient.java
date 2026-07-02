package ParkingLot;

import ParkingLot.controllers.TicketController;
import ParkingLot.dtos.IssueTicketRequest;
import ParkingLot.dtos.IssueTicketResponse;
import ParkingLot.dtos.ResponseStatus;
import ParkingLot.models.VehicleType;
import ParkingLot.repositories.GateRepository;
import ParkingLot.repositories.ParkingLotRepository;
import ParkingLot.repositories.TicketRepository;
import ParkingLot.repositories.VehicleRepository;
import ParkingLot.services.TicketService;

public class ParkingLotClient {
    public static void main(String[] args) {
        // first we create repositories, since they don't have any dependency. Controllers need services
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        // now, we create service objects
        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, parkingLotRepository, ticketRepository);

        //now, controller
        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequest request = new IssueTicketRequest("AP39FD5812", "Nikhil", 1L, VehicleType.LIGHT_FOUR_WHEELER, 2L);
        IssueTicketResponse response = ticketController.issueTicket(request);

        if(response.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println("Ticket generated successfully : "+ response.getTicketId());
            System.out.println("Please part at : "+ response.getSlotNumber());
        }else if(response.getResponseStatus().equals(ResponseStatus.FAILURE)){
            System.out.println("Failed to generate ticket :"+ response.getFailureMessage());
        }
    }
}
