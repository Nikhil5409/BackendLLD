package ParkingLot.repositories;

import ParkingLot.Strategies.RandomAssignmentStrategy;
import ParkingLot.Strategies.FeeCalculationStrategyType;
import ParkingLot.models.*;

import java.util.*;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLots = new HashMap<>();

    public ParkingLotRepository() {

        ParkingSlot slot1 = new ParkingSlot();
        slot1.setId(1L);
        slot1.setParkingSlotNumber("A1");
        slot1.setParkingSlotStatus(ParkingSlotStatus.EMPTY);

        HashSet<VehicleType> types = new HashSet<>();
        types.add(VehicleType.LIGHT_FOUR_WHEELER);

        slot1.setAllowedVehicleTypes(types);

        ParkingFloor floor = new ParkingFloor();
        floor.setId(1L);
        floor.setFloorNumber("Ground");
        floor.setParkingSlots(List.of(slot1));

        slot1.setParkingFloor(floor);

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(2L);
        parkingLot.setName("My Parking Lot");
        parkingLot.setParkingFloors(List.of(floor));
        parkingLot.setSlotAssignmentStrategy(new RandomAssignmentStrategy());
        parkingLot.setFeeCalculationStrategy(FeeCalculationStrategyType.WEEKDAY);

        parkingLots.put(2L, parkingLot);
    }

    public Optional<ParkingLot> findParkingLotById(Long id) {
        return Optional.ofNullable(parkingLots.get(id));
    }
}