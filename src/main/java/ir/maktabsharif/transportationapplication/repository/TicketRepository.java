package ir.maktabsharif.transportationapplication.repository;

import ir.maktabsharif.transportationapplication.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    List<Ticket> findByType(String type);
}
