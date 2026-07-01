package ParkingLot.models;

import java.util.HashSet;
import java.util.List;

public class ParkingSlot extends BaseModel{
    private String parkingSlotNumber;
    private ParkingSlotStatus parkingSlotStatus;
    private HashSet<VehicleType> allowedVehicleTypes;
    private ParkingFloor parkingFloor;

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public String getParkingSlotNumber() {
        return parkingSlotNumber;
    }

    public void setParkingSlotNumber(String parkingSlotNumber) {
        this.parkingSlotNumber = parkingSlotNumber;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public HashSet<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(HashSet<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }
}
