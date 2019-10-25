package rest.controller;

import models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.service.IDepartmentContainerService;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private IDepartmentContainerService departmentContainerService;

    @GetMapping(value = "/departments")
    public List<Department> getDepartments(){return departmentContainerService.getDepartments();}
}
