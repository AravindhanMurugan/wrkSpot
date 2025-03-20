package com.wrkspot.wrkspot.timeCardManagement.serviceImpl;

import com.wrkspot.wrkspot.exception.InvalidTimeCardException;
import com.wrkspot.wrkspot.timeCardManagement.service.TimeCardService;
import com.wrkspot.wrkspot.timeCardManagement.timeCard.TimeCard;
import com.wrkspot.wrkspot.timeCardManagement.timeCardStatus.TimeCardStatus;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;

@Service
public class TimeCardServiceImpl implements TimeCardService {

    @Override
    public TimeCard createTimeCard(TimeCard timeCard) {
        // If the geo location matched with the location of the hotel.
        // Mark the status as clocked on and clocked off place.
        /*if (timeCard.getGeoLocation()) {

        }*/
        timeCard.setTimeCardStatus(TimeCardStatus.CLOCKED_ON);
        return timeCard;
    }

    @Override
    public TimeCard updateTimeCard(TimeCard timeCard) throws InvalidTimeCardException {
        // If the geo location matched with the location of the hotel.
        // Mark the status as clocked on and clocked off place.
        /*if (timeCard.getGeoLocation()) {

        }*/
        if (!timeCard.getTimeCardStatus().equals(TimeCardStatus.CLOCKED_ON)) {
            throw new InvalidTimeCardException("No clock on record found...");
        }
        timeCard.setTimeCardStatus(TimeCardStatus.CLOCKED_OFF);
        timeCard.setTotalWorkingHours(getTotalWorkingHours(timeCard.getClockedOnTime(), timeCard.getClockedOffTime()));
        return timeCard;
    }

    @Override
    public TimeCard approveTimeCard(TimeCard timeCard) throws InvalidTimeCardException {
        timeCard.setTimeCardStatus(TimeCardStatus.APPROVED);
        return timeCard;
    }

    private long getTotalWorkingHours(Date clockedOnTime, Date clockedOffTime) {
        long timeLoggedIn = clockedOffTime.getTime()-clockedOnTime.getTime();
        return Duration.ofMillis(timeLoggedIn).toHours();
    }

}
