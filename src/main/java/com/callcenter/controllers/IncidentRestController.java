package com.callcenter.controllers;


import com.callcenter.Domain.Incident;
import com.callcenter.Domain.User;
import com.callcenter.Service.IncidentService;
import com.callcenter.Service.IncidentTypeService;
import com.callcenter.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Incident")
public class IncidentRestController {

    @Autowired
    IncidentTypeService incidentTypeService;

    @Autowired
    IncidentService incidentService;

    @Autowired
    UserService userService;


    @GetMapping("/all/{id}")
    public ResponseEntity<List<Incident>> getIncidentsByUser(@PathVariable("id") String iduser) {

        var user= userService.findUserById(iduser);

        var incidents = incidentService.getIncidentsByUser(user);

        return new ResponseEntity<>(incidents, HttpStatus.OK);
    }

    @PostMapping("/newIncident")
    public ResponseEntity<Incident> saveIncident(@RequestBody Map<String,String> params) {


        Incident incident = new Incident()
                ;
        incident.setDate(LocalDate.now());
//
        var user = userService.findUserById(params.get("iduser"));
        var incidentType = incidentTypeService.getIncidentTypeById(Integer.parseInt(params.get("idincidentType")));


        incident.setIduser(user);
        incident.setIdincidentType(incidentType);
        incident.setReason(params.get("reason"));
        return new ResponseEntity<Incident>(incidentService.save(incident), HttpStatus.CREATED);
    }
}
