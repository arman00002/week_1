package com.cognizant.spring_learn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.service.EmployeeService;
import com.cognizant.spring_learn.service.exception.EmployeeNotFoundException;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        LOGGER.info("START");
        List<Employee> employeeList = employeeService.getAllEmployees();
        LOGGER.debug("Employee List: {}", employeeList);

        LOGGER.info("END");
        return employeeList;
    }
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        LOGGER.info("START deleteEmployee with id={}", id);
        employeeService.deleteEmployee(id);
        LOGGER.info("END deleteEmployee");
    }
}
