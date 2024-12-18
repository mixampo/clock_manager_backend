package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "work_time_registration")
public class WorkTimeRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "activityId")
    private Activity activity;

    @Column(name = "date", nullable = false)
    private LocalDate workingDayDate;

    @Column(name = "starttime", nullable = false)
    private LocalTime workingDayStartTime;

    @Column(name = "endtime", nullable = false)
    private LocalTime workingDayEndTime;

    @Column(name = "totalworkinghours", nullable = false)
    private double totalWorkingHours;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonIgnore
    @JsonProperty(value = "user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public LocalDate getWorkingDayDate() {
        return workingDayDate;
    }

    public void setWorkingDayDate(LocalDate workingDayDate) {
        this.workingDayDate = workingDayDate;
    }

    public LocalTime getWorkingDayStartTime() {
        return workingDayStartTime;
    }

    public void setWorkingDayStartTime(LocalTime workingDayStartTime) {
        this.workingDayStartTime = workingDayStartTime;
    }

    public LocalTime getWorkingDayEndTime() {
        return workingDayEndTime;
    }

    public void setWorkingDayEndTime(LocalTime workingDayEndTime) {
        this.workingDayEndTime = workingDayEndTime;
    }

    public double getTotalWorkingHours() {
        return totalWorkingHours;
    }

    public void setTotalWorkingHours(double totalWorkingHours) {
        this.totalWorkingHours = totalWorkingHours;
    }

    public WorkTimeRegistration(){}

    public WorkTimeRegistration(User user, Activity activity, LocalDate workingDayDate, LocalTime workingDayStartTime, LocalTime workingDayEndTime) {
        this.user = user;
        this.activity = activity;
        this.workingDayDate = workingDayDate;
        this.workingDayStartTime = workingDayStartTime;
        this.workingDayEndTime = workingDayEndTime;
    }
}
