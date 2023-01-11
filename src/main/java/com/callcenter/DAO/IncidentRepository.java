package com.callcenter.DAO;

import com.callcenter.Domain.Incident;
import com.callcenter.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Integer> {

    List<Incident> getIncidentsByiduser(User user);

}