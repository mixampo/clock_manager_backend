package rest.repository;

import models.WorkTimeRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWorkTimeRegistrationJpaRepository extends JpaRepository<WorkTimeRegistration, Integer> {
}
