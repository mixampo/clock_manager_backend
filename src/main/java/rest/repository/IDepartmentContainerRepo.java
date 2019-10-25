package rest.repository;

import models.Department;

import java.util.List;

public interface IDepartmentContainerRepo {
    List<Department> findAllDepartments();
}
