package fr.selerys.selerystest.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
    @Column
    private String email;

    @Column
    @JsonIgnore
    private String password;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "client")
    private List<User> users;

    @ManyToMany
    @JoinTable(
            name="client_station",
            joinColumns = @JoinColumn(name="client_id"),
            inverseJoinColumns = @JoinColumn(name = "station_id")
    )
    Set<WheatherStation> wheatherStations;

}
