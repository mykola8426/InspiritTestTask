package com.example.tripapp.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tour_operators")
@Data
public class TourOperator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
