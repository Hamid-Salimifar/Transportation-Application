package ir.maktabsharif.transportationapplication.model;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String type;

    @Enumerated
    private SeatClass seatClass;

    @Enumerated
    private TicketStatus ticketStatus;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @OneToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;


}
