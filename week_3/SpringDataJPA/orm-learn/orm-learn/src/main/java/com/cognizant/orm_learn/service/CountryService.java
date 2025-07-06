package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Optional;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;


@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }



    @Transactional
    public void updateCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }
    public List<Country> findByNameContaining(String text) {
    return countryRepository.findByNameContainingIgnoreCase(text);
}

public List<Country> findByNameStartingWith(String prefix) {
    return countryRepository.findByNameStartingWith(prefix);
}

public List<Country> getAllCountriesSorted() {
    return countryRepository.findAllByOrderByNameAsc();
}

public List<Country> getTop3Countries() {
    return countryRepository.findTop3ByOrderByNameAsc();
}


@Transactional
public void addCountry(Country country) {
    countryRepository.save(country);
}


    public List<Country> findCountriesByPartialName(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }


@Transactional
public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
    Optional<Country> result = countryRepository.findById(countryCode);
    if (!result.isPresent()) {
        throw new CountryNotFoundException("Country code not found: " + countryCode);
    }
    return result.get();
}

}
