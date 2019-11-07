package rest.repository;

import models.WorkTimeRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IWorkTimeRegistrationJpaRepository extends JpaRepository<WorkTimeRegistration, Integer> {
}
