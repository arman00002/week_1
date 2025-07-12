package com.cognizant.spring_learn.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.spring_learn.dao.EmployeeDao;
import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {

    private EmployeeDao employeeDao;
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
    @Transactional
    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        employeeDao.updateEmployee(employee);
    }


    @Transactional
    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        employeeDao.deleteEmployee(id);
    }
}
