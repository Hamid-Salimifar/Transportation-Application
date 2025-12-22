package ir.maktabsharif.transportationapplication.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.pulsar.PulsarConnectionDetails;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String name;

    private String password;

    @Enumerated
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Flight> flight=new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Purchase> purchases=new HashSet<>();


}
