package rest.repository;

import models.WorkTimeRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkTimeRegistrationRepository implements IWorkTimeRegistrationContainerRepo {

    @Autowired
    private IWorkTimeRegistrationJpaRepository repo;

    public List<WorkTimeRegistration> fetchWorkTimeRegistrations() {
        return repo.findAll();
    }
}
