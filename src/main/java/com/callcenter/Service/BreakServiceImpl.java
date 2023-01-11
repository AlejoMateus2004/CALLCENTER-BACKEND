package com.callcenter.Service;

import com.callcenter.DAO.BreakRepository;
import com.callcenter.Domain.Break;
import com.callcenter.Domain.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BreakServiceImpl implements BreakService{

    @Autowired
    BreakRepository breakRepository;

    @Transactional(readOnly = true)


    @Override
    public List<Break> getBreaksByidrecord(Record record) {
        return breakRepository.getBreaksByidrecord(record);
    }

    @Override
    @Transactional
    public Break save(Break Break) {
        return breakRepository.save(Break);
    }

    @Override
    public Break getBreaksByidBreak(int idbreak) {
        return (Break) breakRepository.findById(idbreak).orElse(null);
    }
}
