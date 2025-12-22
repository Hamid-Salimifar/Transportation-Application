package ir.maktabsharif.transportationapplication.service;

import ir.maktabsharif.transportationapplication.dto.Flight.FlightDtoRequest;
import ir.maktabsharif.transportationapplication.dto.Flight.FlightDtoResponse;
import ir.maktabsharif.transportationapplication.dto.User.UserDtoRequest;
import ir.maktabsharif.transportationapplication.dto.User.UserDtoResponse;
import ir.maktabsharif.transportationapplication.model.Flight;
import ir.maktabsharif.transportationapplication.model.User;

import java.time.LocalDate;
import java.util.List;

public interface FlightService extends BaseService<Flight>{
    void generateTicketsForFlight(Flight savedFlight);
    List<FlightDtoResponse> findByDateAndDestination(LocalDate date, String destination);
    List<Flight> findByEconomyPriceLessThanEqualAndAvailableEconomySeatGreaterThanEqual(double maxPrice,Integer minSeat);
    List<Flight> findByBusinessPriceLessThanEqualAndAvailableBusinessSeatGreaterThanEqual(double maxPrice,Integer minSeat);
    List<Flight> findByFirstClassPriceLessThanEqualAndAvailableFirstClassSeatGreaterThanEqual(double maxPrice,Integer minSeat);
    FlightDtoResponse entityToDto(Flight flight);
    Flight dtoToEntity(FlightDtoRequest flightDtoRequest);

}
