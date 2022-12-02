package com.callcenter.DAO;

import com.callcenter.Domain.IncidentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentTypeRepository extends JpaRepository<IncidentType, Integer> {
}