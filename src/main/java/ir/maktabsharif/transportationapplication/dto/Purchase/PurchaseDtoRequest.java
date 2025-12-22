package ir.maktabsharif.transportationapplication.dto.Purchase;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseDtoRequest(
        @NotNull @Positive Integer ticketId,
        @NotNull @Positive Integer userId


) {}
