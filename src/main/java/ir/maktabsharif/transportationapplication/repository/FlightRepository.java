package ir.maktabsharif.transportationapplication.repository;

import ir.maktabsharif.transportationapplication.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Integer> {
    List<Flight> findByDateAndDestination(LocalDate date,String destination);
    List<Flight> findByEconomyPriceLessThanEqualAndAvailableEconomySeatGreaterThanEqual(double maxPrice,Integer minSeat);
    List<Flight> findByBusinessPriceLessThanEqualAndAvailableBusinessSeatGreaterThanEqual(double maxPrice,Integer minSeat);
    List<Flight> findByFirstClassPriceLessThanEqualAndAvailableFirstClassSeatGreaterThanEqual(double maxPrice,Integer minSeat);

}
