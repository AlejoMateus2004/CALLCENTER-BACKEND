package com.callcenter.Service;

import com.callcenter.DAO.IncidentTypeRepository;
import com.callcenter.Domain.IncidentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IncidentTypeServiceImpl implements IncidentTypeService {

    @Autowired
    IncidentTypeRepository incidentTypeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<IncidentType> getIncidentTypes() {
        return incidentTypeRepository.findAll();
    }

    @Override
    @Transactional
    public IncidentType save(IncidentType IncidentType) {
        return incidentTypeRepository.save(IncidentType);
    }

    @Override
    @Transactional
    public void delete(IncidentType IncidentType) {
        incidentTypeRepository.delete(IncidentType);
    }
}
