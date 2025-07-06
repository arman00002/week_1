package com.cognizant.orm_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.orm_learn.model.State;

public interface StateRepository extends JpaRepository<State, Integer> {
}
