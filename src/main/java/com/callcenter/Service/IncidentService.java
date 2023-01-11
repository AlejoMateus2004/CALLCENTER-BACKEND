package com.callcenter.Service;

import com.callcenter.Domain.Incident;
import com.callcenter.Domain.User;

import java.util.List;
import java.util.Optional;

public interface IncidentService {


    List<Incident> getIncidents();
    List<Incident> getIncidentsByUser(User user);
    Incident save(Incident Incident);

    Optional<Incident> findIncidentById(String id);

}
