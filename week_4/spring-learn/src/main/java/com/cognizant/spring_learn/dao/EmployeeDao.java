package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.service.exception.EmployeeNotFoundException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.service.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Repository;
import java.util.*;
public class EmployeeDao {

    private static ArrayList<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = context.getBean("employeeList", ArrayList.class);
    }

    public void updateEmployee(Employee updatedEmp) throws EmployeeNotFoundException {
    boolean found = false;
    for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
        if (EMPLOYEE_LIST.get(i).getId() == updatedEmp.getId()) {
            EMPLOYEE_LIST.set(i, updatedEmp);
            found = true;
            break;
        }
    }
    if (!found) {
        throw new EmployeeNotFoundException("Employee Not Found with ID: " + updatedEmp.getId());
    }
}
public void deleteEmployee(int id) throws EmployeeNotFoundException {
        boolean removed = EMPLOYEE_LIST.removeIf(emp -> emp.getId() == id);
        if (!removed) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}
 
    

