package com.wrkspot.wrkspot.timeCardManagement.controller;

import com.wrkspot.wrkspot.exception.InvalidTimeCardException;
import com.wrkspot.wrkspot.timeCardManagement.serviceImpl.TimeCardServiceImpl;
import com.wrkspot.wrkspot.timeCardManagement.timeCard.TimeCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timeCard")
public class TimeCardController {

    @Autowired
    private TimeCardServiceImpl timeCardServiceImpl;

    @PostMapping("/clockOn")
    public ResponseEntity<?> createTimeCard(@RequestBody TimeCard timeCard) {
        return new ResponseEntity<>(timeCardServiceImpl.createTimeCard(timeCard), HttpStatus.OK);
    }

    @PutMapping("/clockOff")
    public ResponseEntity<?> updateTimeCard(@RequestBody TimeCard timeCard) throws InvalidTimeCardException {
        return new ResponseEntity<>(timeCardServiceImpl.updateTimeCard(timeCard), HttpStatus.OK);
    }

    @PutMapping("/approveTimeCard")
    public ResponseEntity<?> approveTimeCard(@RequestBody TimeCard timeCard) throws InvalidTimeCardException {
        return new ResponseEntity<>(timeCardServiceImpl.approveTimeCard(timeCard), HttpStatus.OK);
    }
}
