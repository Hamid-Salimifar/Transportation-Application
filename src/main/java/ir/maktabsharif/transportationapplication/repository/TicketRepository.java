package ir.maktabsharif.transportationapplication.repository;

import ir.maktabsharif.transportationapplication.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    List<Ticket> findByType(String type);
    List<Ticket> findByFlight_DateAndFlight_Destination(LocalDate date,String destination);
}
