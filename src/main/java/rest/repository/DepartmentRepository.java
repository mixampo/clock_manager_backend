package rest.repository;

import models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentRepository implements IDepartmentContainerRepo {

    @Autowired
    private IDepartmentJpaRepository repo;

    @Override
    public List<Department> findAllDepartments() {
        return repo.findAll();
    }
}
