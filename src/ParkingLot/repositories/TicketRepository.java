package ParkingLot.repositories;

import ParkingLot.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {

    private List<Ticket> tickets = new ArrayList<>();
    private static Long counter = 0L;

    public Ticket save(Ticket ticket) {

        ticket.setId(++counter);

        tickets.add(ticket);

        return ticket;
    }
}