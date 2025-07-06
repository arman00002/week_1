package com.cognizant.orm_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.orm_learn.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
