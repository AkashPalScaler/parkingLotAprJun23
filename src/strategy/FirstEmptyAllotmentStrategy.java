package strategy;

import exceptions.ParkingSpotUnavailableException;
import models.*;

public class FirstEmptyAllotmentStrategy implements ParkingSpotAllotmentStrategy{
    @Override
    public ParkingSpot getParkingSpot(VehicleType type, ParkingLot parkingLot) throws ParkingSpotUnavailableException {
        //Computer vision - connect to surveillance survice and get empty parking spot
        for(Floor floor: parkingLot.getFloors()){
            for(ParkingSpot parkingSpot: floor.getParkingSpots()){
                if(parkingSpot.getStatus().equals(ParkingSpotStatus.AVAILABLE)){
                    return parkingSpot;
                }
            }
        }
        System.out.println("parking lot unavailable");
        throw new ParkingSpotUnavailableException("Parking lot is full");
    }
}
