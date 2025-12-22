package ir.maktabsharif.transportationapplication.service.impl;

import ir.maktabsharif.transportationapplication.dto.Flight.FlightDtoRequest;
import ir.maktabsharif.transportationapplication.dto.Flight.FlightDtoResponse;
import ir.maktabsharif.transportationapplication.model.Flight;
import ir.maktabsharif.transportationapplication.model.SeatClass;
import ir.maktabsharif.transportationapplication.model.Ticket;
import ir.maktabsharif.transportationapplication.repository.FlightRepository;
import ir.maktabsharif.transportationapplication.service.FlightService;
import ir.maktabsharif.transportationapplication.service.TicketService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class FlightServiceImpl extends BaseServiceImpl<Flight> implements FlightService {

    private final FlightRepository flightRepository;
    private final TicketService ticketService;

    public FlightServiceImpl(FlightRepository jpaRepository,TicketService ticketService) {
        super(jpaRepository);
        this.flightRepository = jpaRepository;
        this.ticketService=ticketService;

    }

    @Override
    public List<FlightDtoResponse> findByDateAndDestination(LocalDate date, String destination) {
        List<Flight> listOfFlights = flightRepository.findByDateAndDestination(date, destination);
        return listOfFlights.stream().map(flight -> entityToDto(flight)).toList();

    }

    @Override
    public FlightDtoResponse entityToDto(Flight flight) {
        return new FlightDtoResponse(
                flight.getDeparture(),
                flight.getDestination(),
                flight.getDate(),
                flight.getAvailableEconomySeat(),
                flight.getAvailableBusinessSeat(),
                flight.getAvailableFirstClassSeat(),
                flight.getEconomyPrice(),
                flight.getBusinessPrice(),
                flight.getFirstClassPrice()
        );
    }

    @Override
    public Flight dtoToEntity(FlightDtoRequest flightDtoRequest) {
        return Flight.builder()
                .departure(flightDtoRequest.departure())
                .destination(flightDtoRequest.destination())
                .date(flightDtoRequest.date())
                .availableEconomySeat(flightDtoRequest.availableEconomySeat())
                .availableBusinessSeat(flightDtoRequest.availableBusinessSeat())
                .availableFirstClassSeat(flightDtoRequest.availableFirstClassSeat())
                .economyPrice(flightDtoRequest.economyPrice())
                .businessPrice(flightDtoRequest.businessPrice())
                .firstClassPrice(flightDtoRequest.firstClassPrice())
                .build();
    }

    @Override
    public void generateTicketsForFlight(Flight flight) {
        List<Ticket> tickets = new ArrayList<>();
        for(int i=0;i<flight.getAvailableEconomySeat();i++){
            tickets.add(ticketService.createTicketForFlight(flight, SeatClass.Economy));
        }
        for(int i=0;i<flight.getAvailableBusinessSeat();i++){
            tickets.add(ticketService.createTicketForFlight(flight, SeatClass.Business));
        }
        for (int i=0;i<flight.getAvailableFirstClassSeat();i++){
            tickets.add(ticketService.createTicketForFlight(flight, SeatClass.FirstClass));
        }
        ticketService.saveAll(tickets);

    }

    @Override
    public List<Flight> findByEconomyPriceLessThanEqualAndAvailableEconomySeatGreaterThanEqual(double maxPrice, Integer minSeat) {
        return List.of();
    }

    @Override
    public List<Flight> findByBusinessPriceLessThanEqualAndAvailableBusinessSeatGreaterThanEqual(double maxPrice, Integer minSeat) {
        return List.of();
    }

    @Override
    public List<Flight> findByFirstClassPriceLessThanEqualAndAvailableFirstClassSeatGreaterThanEqual(double maxPrice, Integer minSeat) {
        return List.of();
    }


}
