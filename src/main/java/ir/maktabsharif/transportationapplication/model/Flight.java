package ir.maktabsharif.transportationapplication.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String departure;
    private String destination;

    private Integer availableEconomySeat;
    private Integer availableBusinessSeat;
    private Integer availableFirstClassSeat;





}
