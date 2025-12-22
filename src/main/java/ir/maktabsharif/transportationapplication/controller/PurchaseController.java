package ir.maktabsharif.transportationapplication.controller;

import ir.maktabsharif.transportationapplication.dto.Purchase.PurchaseDtoRequest;
import ir.maktabsharif.transportationapplication.dto.Purchase.PurchaseDtoResponse;
import ir.maktabsharif.transportationapplication.service.PurchaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;




    @PostMapping
    public PurchaseDtoResponse submitPurchase(@Valid @RequestBody PurchaseDtoRequest purchaseDtoRequest){
        return purchaseService.submitPurchase(purchaseDtoRequest);

    }

}
