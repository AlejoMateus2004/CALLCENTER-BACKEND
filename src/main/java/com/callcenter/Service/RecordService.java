package com.callcenter.Service;

import com.callcenter.Domain.Record;
import com.callcenter.Domain.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RecordService {

    List<Record> getRecords();
    Record save(Record Record);
    List<Record> findRecordByUser(Optional<User> user);
    Record getRecordByDate(LocalDate date);

    Record getRecordById(int Record);

}
