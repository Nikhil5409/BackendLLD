package ParkingLot.models;

import ParkingLot.Strategies.FeeCalculationStrategyType;
import ParkingLot.Strategies.SlotAssignmentStrategy;

import java.util.HashMap;
import java.util.List;

public class ParkingLot extends BaseModel {
    private List<Gate> entryGates;
    private List<Gate> exitGates;
    private List<ParkingFloor> parkingFloors;
    private ParkingLotStatus parkingLotStatus;
    private HashMap<VehicleType, Integer> allowedVehicleTypes ;
    private FeeCalculationStrategyType feeCalculationStrategy;
    private SlotAssignmentStrategy slotAssignmentStrategy;

    private String location;
    private String name;

    public SlotAssignmentStrategy getSlotAssignmentStrategy() {
        return slotAssignmentStrategy;
    }

    public void setSlotAssignmentStrategy(SlotAssignmentStrategy slotAssignmentStrategy) {
        this.slotAssignmentStrategy = slotAssignmentStrategy;
    }

    public FeeCalculationStrategyType getFeeCalculationStrategy() {
        return feeCalculationStrategy;
    }

    public void setFeeCalculationStrategy(FeeCalculationStrategyType feeCalculationStrategy) {
        this.feeCalculationStrategy = feeCalculationStrategy;
    }

    public List<Gate> getEntryGates() {
        return entryGates;
    }

    public void setEntryGates(List<Gate> entryGates) {
        this.entryGates = entryGates;
    }

    public List<Gate> getExitGates() {
        return exitGates;
    }

    public void setExitGates(List<Gate> exitGates) {
        this.exitGates = exitGates;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public HashMap<VehicleType, Integer> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(HashMap<VehicleType, Integer> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
