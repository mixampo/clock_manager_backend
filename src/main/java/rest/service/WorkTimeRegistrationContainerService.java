package rest.service;

import models.WorkTimeRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IWorkTimeRegistrationContainerRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkTimeRegistrationContainerService implements IWorkTimeRegistrationContainerService {

    @Autowired
    private IWorkTimeRegistrationContainerRepo repo;

    public List<WorkTimeRegistration> getWorkTimeRegistrations(int userId)
    {
        List<WorkTimeRegistration> workTimeRegistrations = repo.fetchWorkTimeRegistrations();
        List<WorkTimeRegistration> filteredWorkTimeRegistrations = new ArrayList<>();

        for (WorkTimeRegistration workTimeRegistration: workTimeRegistrations) {
            if (workTimeRegistration.getUser().getId() == userId) {
                filteredWorkTimeRegistrations.add(workTimeRegistration);
            }
        }
        return filteredWorkTimeRegistrations;
    }
}
