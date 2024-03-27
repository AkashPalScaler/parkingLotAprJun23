package exceptions;

public class ParkingSpotUnavailableException extends Exception {
    public ParkingSpotUnavailableException(String message){
        super(message);
    }
}
