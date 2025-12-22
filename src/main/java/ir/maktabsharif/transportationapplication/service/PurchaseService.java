package ir.maktabsharif.transportationapplication.service;

import ir.maktabsharif.transportationapplication.dto.Purchase.PurchaseDtoRequest;
import ir.maktabsharif.transportationapplication.dto.Purchase.PurchaseDtoResponse;
import ir.maktabsharif.transportationapplication.model.Purchase;

import java.util.List;

public interface PurchaseService extends BaseService<Purchase>{
    PurchaseDtoResponse submitPurchase(PurchaseDtoRequest purchaseDtoRequest);
    List<PurchaseDtoResponse> getPurchasesByUserId(Integer userId);
}
