package ir.maktabsharif.transportationapplication.controller;

import ir.maktabsharif.transportationapplication.dto.Ticket.TicketDto;
import ir.maktabsharif.transportationapplication.model.Ticket;
import ir.maktabsharif.transportationapplication.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;


    @GetMapping("/{id}")
    public TicketDto selectTicket(@PathVariable Integer id){
        return ticketService.selectTicketById(id);
    }

    @GetMapping("/purchased")
    public List<TicketDto> getAllPurchasedTicket(){
        return ticketService.findAllPurchasedTicket();
    }



}
