package com.cognizant.spring_learn.dao;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cognizant.spring_learn.model.Department;

public class DepartmentDao {

    private static List<Department> DEPARTMENT_LIST;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        DEPARTMENT_LIST = context.getBean("depList", List.class);
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
