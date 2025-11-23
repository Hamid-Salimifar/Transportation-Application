package ir.maktabsharif.transportationapplication.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Purchase {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private double amount;



}
