package com.callcenter.DAO;

import com.callcenter.Domain.Break;
import com.callcenter.Domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreakRepository extends JpaRepository<Break, Integer> {

    List<Break> getBreaksByidrecord(Record record);
}