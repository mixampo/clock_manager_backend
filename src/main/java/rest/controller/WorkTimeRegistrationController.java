package rest.controller;

import models.WorkTimeRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
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

    @CrossOrigin(origins = "http://localhost:4200/clocking")
    @PostMapping(value = "/worktime-registrations",
            headers = "Accept=application/json")
    public ResponseEntity<?> addWorkTimeRegistration(@RequestBody WorkTimeRegistration workTimeRegistration, UriComponentsBuilder ucBuilder) {
        workTimeRegistrationContainerService.addWorkTimeRegistration(workTimeRegistration);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/worktime-registration/{id}").buildAndExpand(workTimeRegistration.getId()).toUri());
        return new ResponseEntity<>(workTimeRegistration, headers, HttpStatus.CREATED);
    }
}
