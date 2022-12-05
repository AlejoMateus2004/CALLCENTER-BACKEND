package com.callcenter.Service;

import com.callcenter.DAO.RecordRepository;
import com.callcenter.Domain.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Optional<Record> findRecordById(String id) {
        return recordRepository.findById(Integer.valueOf(id));
    }
}
