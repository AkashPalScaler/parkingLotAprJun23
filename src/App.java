import controllers.TicketController;
import models.Floor;

import dtos.IssueTicketRequest;
import dtos.IssueTicketResponse;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;
import strategy.FirstEmptyAllotmentStrategy;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        System.out.println("Parking Lot!");

        Gate gate = new Gate(1l, GateType.ENTRY, GateStatus.WORKING);

        Floor floor1 = new Floor(1);

        for(int i=1; i<=10; i++) {
            floor1.getParkingSpots().add(
                    new ParkingSpot(i, VehicleType.FOUR_WHEELER, ParkingSpotStatus.AVAILABLE, floor1));
        }

        ArrayList<Floor> floors = new ArrayList<Floor>();
        floors.add(floor1);
        ArrayList<Gate> gates = new ArrayList<Gate>();
        gates.add(gate);

        ParkingLot parkingLot = new ParkingLot(1l, floors, gates, ParkingLotStatus.ACTIVE, new FirstEmptyAllotmentStrategy());


        GateRepository gateRepository = new GateRepository();
        gateRepository.getGates().put(1l, gate); //saving the gate in db

        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        parkingLotRepository.getParkingLotMap().put(1l, parkingLot);//saving the parkinglot in db

        TicketRepository ticketRepository = new TicketRepository();


        TicketService ticketService =
                new TicketService(vehicleRepository,gateRepository,
                        parkingLotRepository, ticketRepository);

        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequest issueTicketRequest = new IssueTicketRequest(
                "KA-02", VehicleType.FOUR_WHEELER, "Akash",
                1l);
        IssueTicketResponse ticketResponse = ticketController.issueTicket(issueTicketRequest);
        System.out.println(ticketResponse);
    }
}
