package rest.repository;

import models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActivityRepository implements IActivityContainerRepo {

    @Autowired
    IActivityJpaRepository repo;

    @Override
    public List<Activity> fetchActivitiesByDepartmentId(int departmentId) { return repo.findAll(); }

    @Override
    public List<Activity> fetchAllActivities() { return repo.findAll(); }
}
