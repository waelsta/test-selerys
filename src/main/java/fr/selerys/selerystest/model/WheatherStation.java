package fr.selerys.selerystest.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class WheatherStation {

    @Id
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private double longitude;

    @Column
    private double latitude;
    @Column
    private String purpose;

    @Column
    private boolean isActive;

    @ManyToMany(mappedBy = "clientStations")
    private Set<Client> clients;

}
