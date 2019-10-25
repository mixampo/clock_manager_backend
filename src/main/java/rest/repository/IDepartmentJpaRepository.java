package rest.repository;

import models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentJpaRepository extends JpaRepository<Department, Integer> {
}
