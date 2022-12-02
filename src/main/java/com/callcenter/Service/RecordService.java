package com.callcenter.Service;

import com.callcenter.Domain.Record;

import java.util.List;
import java.util.Optional;

public interface RecordService {

    List<Record> getRecords();
    Record save(Record Record);
    Optional<Record> findRecordById(String id);

}
