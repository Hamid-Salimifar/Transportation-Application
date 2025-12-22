package ir.maktabsharif.transportationapplication.dto.Flight;

import java.time.LocalDate;

public record FlightDtoResponse(
        String departure,
        String destination,
        LocalDate date,
        Integer availableEconomySeat,
        Integer availableBusinessSeat,
        Integer availableFirstClassSeat,
        double economyPrice,
        double businessPrice,
        double firstClassPrice
) {}