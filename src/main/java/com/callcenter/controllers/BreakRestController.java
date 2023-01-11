package com.callcenter.controllers;

import com.callcenter.Domain.Break;
import com.callcenter.Domain.Break;
import com.callcenter.Service.BreakService;
import com.callcenter.Service.BreakService;
import com.callcenter.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/Break")
public class BreakRestController {

    @Autowired
    RecordService recordService;

    @Autowired
    BreakService breakService;

    @GetMapping("/Record/{idRecord}")
    public ResponseEntity<List<Break>> getBrakesByRecord(@PathVariable("idRecord") int idRecord) {

        var record = recordService.getRecordById(idRecord);

        if (record != null) {
            var breaks = breakService.getBreaksByidrecord(record);
            return new ResponseEntity(breaks, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/check_in_time/{id}")
    public ResponseEntity<Break> check_in_time(@PathVariable("id") int idRecord) {

        var record = recordService.getRecordById(idRecord);


        Break Break = new Break();
        Break.setClockin(String.valueOf(LocalTime.now()));
        Break.setIdrecord(record);
        breakService.save(Break);

        return new ResponseEntity<>(Break, HttpStatus.CREATED);
    }

    @PostMapping("/check_out_time/{id}")
    public ResponseEntity<Break> check_out_time(@PathVariable("id") int idBreak) {

        var Break = breakService.getBreaksByidBreak(idBreak);

        if (Break != null) {
            Break.setClockout(String.valueOf(LocalTime.now()));

            breakService.save(Break);

            return new ResponseEntity<>(Break, HttpStatus.CREATED);
        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}
