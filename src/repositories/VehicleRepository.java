package repositories;

import models.Vehicle;
import models.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    //Placeholder DB
    Map<String, Vehicle> vehicleTable = new HashMap<String, Vehicle>();

    public Vehicle createVehicle(String vehicleNumber, VehicleType type, String owner){
        Vehicle vehicle = new Vehicle(vehicleNumber, type, owner);
        vehicleTable.put(vehicleNumber, vehicle); //db save
        return vehicle;
    }

    public Vehicle getVehicleByNumber(String vehicleNumber){
        return vehicleTable.get(vehicleNumber);
    }

}
