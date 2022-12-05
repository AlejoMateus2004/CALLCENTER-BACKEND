package com.callcenter.Service;

import com.callcenter.DAO.IncidentRepository;
import com.callcenter.Domain.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentServiceImpl implements IncidentService{

    @Autowired
    IncidentRepository incidentRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Incident> getIncidents() {
        return incidentRepository.findAll();
    }

    @Override
    @Transactional
    public Incident save(Incident Incident) {
        return incidentRepository.save(Incident);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Incident> findIncidentById(String id) {
        return incidentRepository.findById(Integer.valueOf(id));
    }
}
