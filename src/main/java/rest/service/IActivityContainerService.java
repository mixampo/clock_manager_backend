package rest.service;

import models.Activity;

import java.util.List;

public interface IActivityContainerService {
    List<Activity> getActivitiesByDepartmentId(int departmentId);
    List<Activity> getAllActivities();
}
