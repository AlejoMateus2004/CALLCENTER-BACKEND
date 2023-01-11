package com.callcenter.Service;

import com.callcenter.Domain.IncidentType;

import java.util.List;

public interface IncidentTypeService {

    List<IncidentType> getIncidentTypes();
    IncidentType save(IncidentType IncidentType);
    void delete(IncidentType IncidentType);

    IncidentType getIncidentTypeById(int id);


}
