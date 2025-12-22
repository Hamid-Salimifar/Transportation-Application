package ir.maktabsharif.transportationapplication.service.impl;

import ir.maktabsharif.transportationapplication.dto.Ticket.TicketDto;
import ir.maktabsharif.transportationapplication.model.Flight;
import ir.maktabsharif.transportationapplication.model.SeatClass;
import ir.maktabsharif.transportationapplication.model.Ticket;
import ir.maktabsharif.transportationapplication.model.TicketStatus;
import ir.maktabsharif.transportationapplication.repository.TicketRepository;
import ir.maktabsharif.transportationapplication.service.TicketService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket> implements TicketService {

    private final TicketRepository ticketRepository;
    public TicketServiceImpl(TicketRepository jpaRepository) {
        super(jpaRepository);
        this.ticketRepository=jpaRepository;
    }
    public TicketDto selectTicketById(Integer id){
        Ticket ticket = ticketRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Ticket Not Found with Id: "+id));
        return new TicketDto(
                ticket.getType(),
                ticket.getSeatClass(),
                ticket.getTicketStatus(),
                ticket.getFlight().getDeparture(),
                ticket.getFlight().getDestination()
        );
    }


    @Override
    public List<TicketDto> findAllPurchasedTicket() {
        List<Ticket> byTicketStatus = ticketRepository.findByTicketStatus(TicketStatus.Purchased);
        return byTicketStatus.stream().map(ticket->new TicketDto(
             ticket.getType(),
             ticket.getSeatClass(),
             ticket.getTicketStatus(),
             ticket.getFlight().getDeparture(),
             ticket.getFlight().getDestination()
        )).toList();
    }

    @Override
    public Ticket createTicketForFlight(Flight flight, SeatClass seatClass) {
        return Ticket.builder()
                .type("Airplane")
                .seatClass(seatClass)
                .ticketStatus(TicketStatus.Available)
                .flight(flight)
                .build();
    }

    @Override
    public List<Ticket> saveAll(List<Ticket> tickets) {
        return ticketRepository.saveAll(tickets);
    }

    @Override
    public List<Ticket> findByType(String type) {
        return List.of();
    }
}
