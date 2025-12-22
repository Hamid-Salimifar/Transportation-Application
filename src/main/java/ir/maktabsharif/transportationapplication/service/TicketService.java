package ir.maktabsharif.transportationapplication.service;

import ir.maktabsharif.transportationapplication.dto.Ticket.TicketDto;
import ir.maktabsharif.transportationapplication.model.Flight;
import ir.maktabsharif.transportationapplication.model.SeatClass;
import ir.maktabsharif.transportationapplication.model.Ticket;

import java.util.List;

public interface TicketService extends BaseService<Ticket>{
    List<Ticket> findByType(String type);
    TicketDto selectTicketById(Integer id);
    List<TicketDto> findAllPurchasedTicket();
    List<Ticket> saveAll(List<Ticket> tickets);
    Ticket createTicketForFlight(Flight flight, SeatClass seatClass);

}
