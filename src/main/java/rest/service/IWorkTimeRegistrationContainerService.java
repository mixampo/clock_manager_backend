package rest.service;

import models.WorkTimeRegistration;

import java.time.LocalDate;
import java.util.List;

public interface IWorkTimeRegistrationContainerService {
    List<WorkTimeRegistration> getWorkTimeRegistrations(int userId);
    List<WorkTimeRegistration> getWorkTimeRegistrationByDate(int userId, String beginDate, String endDate);
}
