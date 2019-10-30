package rest.service;

import models.WorkTimeRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IWorkTimeRegistrationContainerRepo;

import java.util.List;

@Component
public class WorkTimeRegistrationContainerService implements IWorkTimeRegistrationContainerService {

    @Autowired
    private IWorkTimeRegistrationContainerRepo repo;

    public List<WorkTimeRegistration> getWorkTimeRegistrations() {
        return repo.fetchWorkTimeRegistrations();
    }
}
