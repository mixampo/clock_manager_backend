package rest.repository;

import models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActivityJpaRepository extends JpaRepository<Activity, Integer> {
}
