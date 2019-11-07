package rest.service;

import models.WorkTimeRegistration;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IWorkTimeRegistrationContainerRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class WorkTimeRegistrationContainerService implements IWorkTimeRegistrationContainerService {

    @Autowired
    private IWorkTimeRegistrationContainerRepo repo;

    public List<WorkTimeRegistration> getWorkTimeRegistrations(int userId) {
        List<WorkTimeRegistration> workTimeRegistrations = repo.fetchWorkTimeRegistrations();
        List<WorkTimeRegistration> filteredWorkTimeRegistrations = new ArrayList<>();

        for (WorkTimeRegistration workTimeRegistration : workTimeRegistrations) {
            if (workTimeRegistration.getUser().getId() == userId) {
                filteredWorkTimeRegistrations.add(workTimeRegistration);
            }
        }
        return filteredWorkTimeRegistrations;
    }

    public List<WorkTimeRegistration> getWorkTimeRegistrationByDate(int userId, String beginDateString, String endDateString) {
        List<WorkTimeRegistration> workTimeRegistrations = repo.fetchWorkTimeRegistrations();
        List<WorkTimeRegistration> filteredWorkTimeRegistrations = new ArrayList<>();

        //Parse Dates From String To LocalDate
        LocalDate beginDate = LocalDate.parse(beginDateString);
        LocalDate endDate = LocalDate.parse(endDateString);

        for (WorkTimeRegistration workTimeRegistration : workTimeRegistrations) {
            if (workTimeRegistration.getUser().getId() == userId && !beginDate.isAfter(workTimeRegistration.getWorkingDayDate())  && endDate.isAfter(workTimeRegistration.getWorkingDayDate())) {
                filteredWorkTimeRegistrations.add(workTimeRegistration);
            }
        }
        return filteredWorkTimeRegistrations;
    }
}
