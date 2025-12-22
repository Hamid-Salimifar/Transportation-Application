package ir.maktabsharif.transportationapplication.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import ir.maktabsharif.transportationapplication.dto.Flight.FlightDtoRequest;
import ir.maktabsharif.transportationapplication.dto.Flight.FlightDtoResponse;
import ir.maktabsharif.transportationapplication.dto.User.UserDtoResponse;
import ir.maktabsharif.transportationapplication.model.Flight;
import ir.maktabsharif.transportationapplication.model.User;
import ir.maktabsharif.transportationapplication.service.FlightService;
import ir.maktabsharif.transportationapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flight")
@RequiredArgsConstructor
@Tag(name = "Flight APIs", description = "APIs for managing flights")
public class FlightController {

    private final FlightService flightService;
    private final UserService userService;

    @GetMapping("/search-by-destination")
    @Operation(summary = "search for a flight by date and destination")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "successfully find the flight ",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = FlightDtoRequest.class)))),
            @ApiResponse(responseCode = "404", description = "flight-not-found")
    })
    public List<FlightDtoResponse> searchByDateAndDestination(@Parameter(description = "flight departure date")
                                                              @RequestParam
                                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate date,
                                                              @Parameter(description = "flight destination city")
                                                              @RequestParam String destination) {
        return flightService.findByDateAndDestination(date, destination);
    }


    @PostMapping
    public FlightDtoResponse addFlightByAirlines(@RequestBody FlightDtoRequest flightDto) {
        User user = userService.findById(flightDto.userId());
        if (user == null) {
            throw new IllegalStateException("the user not found");

        }
        Flight flight = flightService.dtoToEntity(flightDto);
        flight.setUser(user);
        Flight savedFlight = flightService.saveOrUpdate(flight);

        flightService.generateTicketsForFlight(savedFlight);

        return flightService.entityToDto(savedFlight);
    }

    @GetMapping
    public List<FlightDtoResponse> getAllFlights(){
        List<Flight> all = flightService.findAll();
        return all.stream().map(flight -> flightService.entityToDto(flight)).toList();
    }

    @DeleteMapping("/{id}")
    public void deleteFlightById(@PathVariable Integer id){
        flightService.deleteById(id);
    }




}
