package ir.maktabsharif.transportationapplication.model;


import jakarta.persistence.*;
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

    @OneToOne(mappedBy = "purchase")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
