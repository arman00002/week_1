package com.cognizant.spring_learn.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cognizant.spring_learn.dao.DepartmentDao;
import com.cognizant.spring_learn.model.Department;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    private DepartmentDao departmentDao = new DepartmentDao();

    @Transactional
    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}
