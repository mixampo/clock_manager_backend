package rest.repository;

import models.WorkTimeRegistration;
import org.hibernate.jdbc.Work;

import java.util.List;

public interface IWorkTimeRegistrationContainerRepo {
    List<WorkTimeRegistration> fetchWorkTimeRegistrations();
    void addWorkTimeRegistration(WorkTimeRegistration workTimeRegistration);
    void updateWorkTimeRegistration(WorkTimeRegistration workTimeRegistration);
}
