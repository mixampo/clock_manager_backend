package rest.service;

import models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IDepartmentContainerRepo;

import java.util.List;

@Component
public class DepartmentContainerService implements IDepartmentContainerService {

    @Autowired
    private IDepartmentContainerRepo repo;

    @Override
    public List<Department> getDepartments() {
        return repo.findAllDepartments();
    }
}
