package ir.maktabsharif.transportationapplication.repository;

import ir.maktabsharif.transportationapplication.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
