package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findByNameContainingIgnoreCase(String name);

    List<Country> findByNameStartingWith(String prefix);

    List<Country> findAllByOrderByNameAsc();

    List<Country> findTop3ByOrderByNameAsc();

    @org.springframework.data.jpa.repository.Query("SELECT c FROM Country c WHERE c.name LIKE ?1%")
    List<Country> findCountriesStartingWith(String prefix);

    @org.springframework.data.jpa.repository.Query("SELECT c FROM Country c LEFT JOIN FETCH c.languages WHERE c.code = :code")
    Country fetchCountryWithLanguages(@org.springframework.data.repository.query.Param("code") String code);

    @org.springframework.data.jpa.repository.Query("SELECT COUNT(c) FROM Country c")
    long countCountries();

    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM country WHERE co_name LIKE %:name%", nativeQuery = true)
    List<Country> searchCountriesByNameNative(@org.springframework.data.repository.query.Param("name") String name);
}


