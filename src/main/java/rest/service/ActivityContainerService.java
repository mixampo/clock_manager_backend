package rest.service;

import models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IActivityContainerRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActivityContainerService implements IActivityContainerService {

    @Autowired
    private IActivityContainerRepo repo;

    @Override
    public List<Activity> getActivitiesByDepartmentId(int departmentId) {
       List<Activity> activities = repo.fetchActivitiesByDepartmentId(departmentId);
       List<Activity> filteredActivities = new ArrayList<>();

       for (Activity activity : activities) {
           if (activity.getDepartment().getId() == departmentId) {
               filteredActivities.add(activity);
           }
       }
        return filteredActivities;
    }
}
