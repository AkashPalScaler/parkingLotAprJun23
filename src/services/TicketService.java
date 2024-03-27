package services;

import exceptions.GateNotFoundException;
import exceptions.ParkingLotNotFoundException;
import exceptions.ParkingSpotUnavailableException;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;

import java.util.Date;
import java.util.UUID;

public class TicketService {

    private VehicleRepository vehicleRepository;
    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(VehicleRepository vehicleRepository, GateRepository gateRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.vehicleRepository = vehicleRepository;
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(String vehicleNumber,
                              VehicleType vehicleType, String ownerName, Long gateID) throws GateNotFoundException, ParkingLotNotFoundException, ParkingSpotUnavailableException {
        //Create an empty ticket
        //Set entry time
        //Check if vehicle availble else create and set vehicle
        //Get parking lot - get floor- get parking spot
        //Generate ticket number
        //Save and return the ticket

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());


        Vehicle vehicle = vehicleRepository.getVehicleByNumber(vehicleNumber);

        if(vehicle == null){
            vehicle = vehicleRepository.createVehicle(vehicleNumber, vehicleType, ownerName);
        }

        Gate gate = gateRepository.getGateByID(gateID);
        ticket.setGate(gate);
        //HW to add either parking lot id in gate
        //or add parkingLotId in the request
        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(1l);
        ParkingSpot parkingSpot = parkingLot.getParkingSpot(vehicleType);
        ticket.setParkingSpot(parkingSpot);

        ticket.setNumber(vehicleNumber + UUID.randomUUID());

        ticketRepository.createTicket(ticket);

        return ticket;
    }
}
