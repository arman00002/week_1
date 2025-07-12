package com.cognizant.spring_learn.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.spring_learn.model.Department;
import com.cognizant.spring_learn.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        LOGGER.info("START - getAllDepartments()");
        List<Department> departments = departmentService.getAllDepartments();
        LOGGER.debug("Departments: {}", departments);
        LOGGER.info("END - getAllDepartments()");
        return departments;
    }
}
