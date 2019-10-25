package models;

import javax.persistence.*;
import java.lang.invoke.WrongMethodTypeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

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
    private LocalTime workingDayStarttime;

    @Column(name = "endtime", nullable = false)
    private LocalTime workingDayEndtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public LocalTime getWorkingDayStarttime() {
        return workingDayStarttime;
    }

    public void setWorkingDayStarttime(LocalTime workingDayStarttime) {
        this.workingDayStarttime = workingDayStarttime;
    }

    public LocalTime getWorkingDayEndtime() {
        return workingDayEndtime;
    }

    public void setWorkingDayEndtime(LocalTime workingDayEndtime) {
        this.workingDayEndtime = workingDayEndtime;
    }

    public WorkTimeRegistration(){}

    public WorkTimeRegistration(User user, Activity activity, LocalDate workingDayDate, LocalTime workingDayStarttime, LocalTime workingDayEndtime) {
        this.user = user;
        this.activity = activity;
        this.workingDayDate = workingDayDate;
        this.workingDayStarttime = workingDayStarttime;
        this.workingDayEndtime = workingDayEndtime;
    }
}
