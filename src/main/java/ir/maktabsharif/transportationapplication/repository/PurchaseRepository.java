package ir.maktabsharif.transportationapplication.repository;

import ir.maktabsharif.transportationapplication.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {
    List<Purchase> findByUser_Id(Integer userID);
}
