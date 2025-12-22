package ir.maktabsharif.transportationapplication.dto.Ticket;

import ir.maktabsharif.transportationapplication.model.SeatClass;
import ir.maktabsharif.transportationapplication.model.TicketStatus;

public record TicketDto(
        String type,
        SeatClass seatClass,
        TicketStatus ticketStatus,
        String departure,
        String destination
){}
