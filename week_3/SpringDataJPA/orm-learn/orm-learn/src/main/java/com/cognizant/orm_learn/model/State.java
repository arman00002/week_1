package com.cognizant.orm_learn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "state")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    // Many states belong to one country
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_code") // foreign key in state table
    private Country country;

    // getters, setters, toString
}
