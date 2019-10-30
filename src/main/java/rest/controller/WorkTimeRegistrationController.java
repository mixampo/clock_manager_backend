package rest.controller;

import models.WorkTimeRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.service.IWorkTimeRegistrationContainerService;

import java.util.List;

@RestController
public class WorkTimeRegistrationController {

    @Autowired
    IWorkTimeRegistrationContainerService workTimeRegistrationContainerService;
    
    @GetMapping(value = "/worktimeregistration")
    public List<WorkTimeRegistration> getWorkTimeRegistrations(){return workTimeRegistrationContainerService.getWorkTimeRegistrations();}
}
