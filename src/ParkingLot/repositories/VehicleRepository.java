package ParkingLot.repositories;

import ParkingLot.models.Vehicle;

import java.util.Optional;

public class VehicleRepository {
    public Optional<Vehicle> findVehicleByLicensePlateNumber(String licensePlateNumber){
        return Optional.empty();
    }
    public Vehicle save(Vehicle vehicle){
         return vehicle;
    }
}
