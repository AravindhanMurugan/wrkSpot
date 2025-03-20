package com.wrkspot.wrkspot.timeCardManagement.timeCard;

import com.wrkspot.wrkspot.timeCardManagement.timeCardStatus.TimeCardStatus;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TimeCard {
    private String userID;
    private String geoLocation;
    private Date clockedOnTime;
    private Date clockedOffTime;
    private long totalWorkingHours;
    private TimeCardStatus timeCardStatus;

    public TimeCard(String userID, String geoLocation, Date clockedOnTime, Date clockedOffTime) {
        this.userID = userID;
        this.geoLocation = geoLocation;
        this.clockedOnTime = clockedOnTime;
        this.clockedOffTime = clockedOffTime;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Date getClockedOnTime() {
        return clockedOnTime;
    }

    public void setClockedOnTime(Date clockedOnTime) {
        this.clockedOnTime = clockedOnTime;
    }

    public Date getClockedOffTime() {
        return clockedOffTime;
    }

    public void setClockedOffTime(Date clockedOffTime) {
        this.clockedOffTime = clockedOffTime;
    }

    public long getTotalWorkingHours() {
        return totalWorkingHours;
    }

    public void setTotalWorkingHours(long totalWorkingHours) {
        this.totalWorkingHours = totalWorkingHours;
    }

    public TimeCardStatus getTimeCardStatus() {
        return timeCardStatus;
    }

    public void setTimeCardStatus(TimeCardStatus timeCardStatus) {
        this.timeCardStatus = timeCardStatus;
    }
}
