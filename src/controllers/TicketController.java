package controllers;

import dtos.IssueTicketRequest;
import dtos.IssueTicketResponse;
import dtos.ResponseStatus;
import exceptions.GateNotFoundException;
import exceptions.ParkingSpotUnavailableException;
import models.Ticket;
import services.TicketService;

public class TicketController {
        //Dependency - DI
        TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponse issueTicket(IssueTicketRequest request) {
            Ticket ticket = null;
            IssueTicketResponse response = new IssueTicketResponse();
            try{
                ticket = ticketService.issueTicket(request.getVehicleNumber(), request.getVehicleType(), request.getOwner(), request.getGateID());
                response.setTicket(ticket);
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Ticket generation successful");

            }
            catch(GateNotFoundException e){
                //Retry Logic
                //Manual entry
                //Assign a default
                System.out.println("Gate is not found :" + e.getMessage());
                response.setTicket(null);
                response.setMessage(e.getMessage());
                response.setStatus(ResponseStatus.FAILURE);
            }
            catch(Exception e){
                System.out.println("Exception :" + e.getMessage());
                response.setTicket(null);
                response.setMessage(e.getMessage());
                response.setStatus(ResponseStatus.FAILURE);

            }


            return  response;
        }
}
