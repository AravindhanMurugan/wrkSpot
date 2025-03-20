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
        timeCard.setTimeCardStatus(TimeCardStatus.CLOCKED_ON);
        return timeCard;
    }

    @Override
    public TimeCard updateTimeCard(TimeCard timeCard) throws InvalidTimeCardException {
        if (!timeCard.getTimeCardStatus().equals(TimeCardStatus.CLOCKED_ON)) {
            throw new InvalidTimeCardException("No clock on record found...");
        }
        timeCard.setTimeCardStatus(TimeCardStatus.CLOCKED_OFF);
        timeCard.setTotalWorkingHours(getTotalWorkingHours(timeCard.getClockedOnTime(), timeCard.getClockedOffTime()));
        return timeCard;
    }

    private long getTotalWorkingHours(Date clockedOnTime, Date clockedOffTime) {
        long timeLoggedIn = clockedOffTime.getTime()-clockedOnTime.getTime();
        return Duration.ofMillis(timeLoggedIn).toHours();
    }

}
