package com.callcenter.controllers;


import com.callcenter.Domain.Record;
import com.callcenter.Domain.User;
import com.callcenter.Service.RecordService;
import com.callcenter.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Records")
public class RecordRestController {


    @Autowired
    UserService userService;

    @Autowired
    RecordService recordService;

    @GetMapping("/User/{id}")
    public ResponseEntity<List<Record>> getAllRecordsByUser(@PathVariable("id") int iduser){

        var user = userService.findUserById(String.valueOf(iduser));

        return new ResponseEntity<>(recordService.findRecordByUser(Optional.ofNullable(user)), HttpStatus.OK);
    }

    @PostMapping("/check_in_time/{id}")
    public ResponseEntity<Record> check_in_time(@PathVariable("id") int iduser) {

        var user = userService.findUserById(String.valueOf(iduser));


        Record record = new Record();
        record.setClockin(String.valueOf(LocalTime.now()));
        record.setDate(LocalDate.now());
        record.setIduser(user);
        recordService.save(record);

        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @PostMapping("/check_out_time/{id}")
    public ResponseEntity<Record> check_out_time(@PathVariable("id") int iduser) {

        var user = userService.findUserById(String.valueOf(iduser));


        var record = recordService.getRecordByDate(LocalDate.now());
        record.setClockout(String.valueOf(LocalTime.now()));
        recordService.save(record);

        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

}
