package rest.repository;

import models.Activity;

import java.util.List;

public interface IActivityContainerRepo {
    List<Activity> fetchActivitiesByDepartmentId(int departmentId);
}
