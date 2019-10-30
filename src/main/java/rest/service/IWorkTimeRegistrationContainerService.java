package rest.service;

import models.WorkTimeRegistration;

import java.util.List;

public interface IWorkTimeRegistrationContainerService {
    List<WorkTimeRegistration> getWorkTimeRegistrations();
}
