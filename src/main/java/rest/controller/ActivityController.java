package rest.controller;

import models.Activity;
import models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest.service.IActivityContainerService;

import java.util.List;

@RestController
public class ActivityController {

    @Autowired
    private IActivityContainerService activityContainerService;

    @CrossOrigin(origins = "http://localhost:4200/clocking")
    @GetMapping(value = "/activities")
    public List<Activity> getActivitiesByDepartmentId
            (
                    @RequestParam(value = "departmentId") int departmentID
            ) {
        return activityContainerService.getActivitiesByDepartmentId(departmentID);
    }

    @CrossOrigin(origins = "http://localhost:4200/clocking")
    @GetMapping(value = "/activities/all")
    public List<Activity> getAllActivities() {
        return activityContainerService.getAllActivities();
    }
}
