package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    private Map<String, Ticket> ticketMap = new HashMap<String, Ticket>();

    public Map<String, Ticket> getTicketMap() {
        return ticketMap;
    }

    public void setTicketMap(Map<String, Ticket> ticketMap) {
        this.ticketMap = ticketMap;
    }

    public Ticket createTicket(Ticket ticket) {
        ticketMap.put(ticket.getNumber(), ticket);
        return ticket;
    }
}
