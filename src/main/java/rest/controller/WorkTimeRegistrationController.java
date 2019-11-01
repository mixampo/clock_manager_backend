package rest.controller;

import models.WorkTimeRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest.service.IWorkTimeRegistrationContainerService;

import java.util.List;

@RestController
public class WorkTimeRegistrationController {

    @Autowired
    IWorkTimeRegistrationContainerService workTimeRegistrationContainerService;
    
    @GetMapping(value = "/worktime-registrations")
    public List<WorkTimeRegistration> getWorkTimeRegistrations(@RequestParam(value = "userId") int userId){return workTimeRegistrationContainerService.getWorkTimeRegistrations(userId);}
}
