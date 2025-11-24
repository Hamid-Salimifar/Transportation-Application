package ir.maktabsharif.transportationapplication.repository;

import ir.maktabsharif.transportationapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
