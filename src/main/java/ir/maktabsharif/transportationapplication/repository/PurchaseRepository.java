package ir.maktabsharif.transportationapplication.repository;

import ir.maktabsharif.transportationapplication.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {
}
