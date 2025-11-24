package ir.maktabsharif.transportationapplication.repository;

import ir.maktabsharif.transportationapplication.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Integer> {
}
