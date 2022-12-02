package com.callcenter.Service;

import com.callcenter.Domain.Incident;

import java.util.List;
import java.util.Optional;

public interface IncidentService {
    List<Incident> getIncidents();
    Incident save(Incident Incident);

    Optional<Incident> findIncidentById(String id);

}
