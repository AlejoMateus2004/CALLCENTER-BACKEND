package com.callcenter.DAO;

import com.callcenter.Domain.Record;
import com.callcenter.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {

    List<Record> findByiduser(Optional<User> user);
    Record getRecordByDate(LocalDate date);
}