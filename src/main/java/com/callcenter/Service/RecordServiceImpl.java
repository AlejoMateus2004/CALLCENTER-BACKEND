package com.callcenter.Service;

import com.callcenter.DAO.RecordRepository;
import com.callcenter.Domain.Record;
import com.callcenter.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    RecordRepository recordRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Record> getRecords() {
        return recordRepository.findAll();
    }

    @Override
    public Record save(Record Record) {
        return recordRepository.save(Record);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Record> findRecordByUser(Optional<User> user) {
        return recordRepository.findByiduser(user);
    }

    @Override
    public Record getRecordByDate(LocalDate date) {
        return recordRepository.getRecordByDate(date);
    }

    @Override
    public Record getRecordById(int Record) {
        return (Record) recordRepository.findById(Record).orElse(null);
    }
}
