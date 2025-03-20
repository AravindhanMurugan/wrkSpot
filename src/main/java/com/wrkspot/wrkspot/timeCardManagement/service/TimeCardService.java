package com.wrkspot.wrkspot.timeCardManagement.service;

import com.wrkspot.wrkspot.exception.InvalidTimeCardException;
import com.wrkspot.wrkspot.timeCardManagement.timeCard.TimeCard;

public interface TimeCardService {

    TimeCard createTimeCard(TimeCard timeCard);
    TimeCard updateTimeCard(TimeCard timeCard) throws InvalidTimeCardException;
}
