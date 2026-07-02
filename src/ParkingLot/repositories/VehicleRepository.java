package ParkingLot.repositories;

import ParkingLot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    // since database is not connected currently in this application, we are mocking the db behaviour using Hashmap
    private Map<String, Vehicle> vehicles;
    private static Long counter = 0L;
    public VehicleRepository(){
        vehicles = new HashMap<>();
    }
    public Optional<Vehicle> findVehicleByLicensePlateNumber(String licensePlateNumber){
        if(vehicles.containsKey(licensePlateNumber)){
            return Optional.of(vehicles.get(licensePlateNumber));
        }
        return Optional.empty();
    }
    public Vehicle save(Vehicle vehicle){
        vehicle.setId(++counter);
        vehicles.put(vehicle.getLicensePlate(), vehicle);
         return vehicle;
    }
}
