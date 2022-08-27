package com.example.tripapp.model;

import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tours")
@Data
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "tours_locations",
    joinColumns = @JoinColumn(name = "tours_id"),
    inverseJoinColumns = @JoinColumn(name = "locations_id"))
    private List<Location> locations;
    private String tourType;
    @OneToOne
    @JoinColumn(name = "tour_operator_id")
    private TourOperator tourOperator;
}
