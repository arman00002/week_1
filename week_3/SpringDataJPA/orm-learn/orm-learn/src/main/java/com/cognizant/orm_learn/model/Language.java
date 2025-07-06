package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "languages", fetch = FetchType.LAZY)
    private List<Country> countries;

    // Getters, setters, toString
}
