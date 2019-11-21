package rest.controller;

import models.WorkTimeRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest.service.IWorkTimeRegistrationContainerService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class WorkTimeRegistrationController {

    @Autowired
    IWorkTimeRegistrationContainerService workTimeRegistrationContainerService;

    @CrossOrigin(origins = "http://localhost:4200/overview")
    @GetMapping(value = "/worktime-registrations")
    public List<WorkTimeRegistration> getWorkTimeRegistrations(@RequestParam(value = "userId") int userId) {
        return workTimeRegistrationContainerService.getWorkTimeRegistrations(userId);
    }

    @CrossOrigin(origins = "http://localhost:4200/overview")
    @GetMapping(value = "/worktime-registrations/dated")
    public List<WorkTimeRegistration> getWorkTimeRegistrationsByDate
            (
                    @RequestParam(value = "userId") int userId,
                    @RequestParam(value = "beginDate") String beginDate,
                    @RequestParam(value = "endDate") String endDate
            ) {
        return workTimeRegistrationContainerService.getWorkTimeRegistrationByDate(userId, beginDate, endDate);
    }
}
