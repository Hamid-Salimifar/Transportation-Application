package ir.maktabsharif.transportationapplication.service.impl;

import ir.maktabsharif.transportationapplication.dto.Purchase.PurchaseDtoRequest;
import ir.maktabsharif.transportationapplication.dto.Purchase.PurchaseDtoResponse;
import ir.maktabsharif.transportationapplication.model.*;
import ir.maktabsharif.transportationapplication.repository.PurchaseRepository;
import ir.maktabsharif.transportationapplication.repository.TicketRepository;
import ir.maktabsharif.transportationapplication.repository.UserRepository;
import ir.maktabsharif.transportationapplication.service.PurchaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl extends BaseServiceImpl<Purchase> implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    public PurchaseServiceImpl(PurchaseRepository jpaRepository, UserRepository userRepository, TicketRepository ticketRepository) {
        super(jpaRepository);
        this.purchaseRepository = jpaRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;

    }

    @Override
    public List<PurchaseDtoResponse> getPurchasesByUserId(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User not found"));

        return purchaseRepository.findByUser_Id(userId).stream()
                .map(purchase -> entityToDto(purchase)).toList();

    }

    @Override
    public PurchaseDtoResponse submitPurchase(PurchaseDtoRequest purchaseDtoRequest) {
        Ticket ticket = ticketRepository.findById(purchaseDtoRequest.ticketId()).orElseThrow();
        User user = userRepository.findById(purchaseDtoRequest.userId()).orElseThrow();
        if (ticket.getTicketStatus() != TicketStatus.Available) {
            throw new IllegalStateException("This ticket is not available for purchase");
        }

        Purchase purchase = Purchase.builder()
                .ticket(ticket)
                .user(user)
                .build();
        Purchase savedPurchase = purchaseRepository.save(purchase);

        ticket.setTicketStatus(TicketStatus.Purchased);
        ticket.setPurchase(savedPurchase);
        ticketRepository.save(ticket);

        return new PurchaseDtoResponse(
                savedPurchase.getUser().getName(),
                savedPurchase.getTicket().getFlight().getDeparture(),
                savedPurchase.getTicket().getFlight().getDestination()
        );
    }

    public PurchaseDtoResponse entityToDto(Purchase purchase) {
        return new PurchaseDtoResponse(
                purchase.getUser().getName(),
                purchase.getTicket().getFlight().getDeparture(),
                purchase.getTicket().getFlight().getDestination()
        );
    }


}
