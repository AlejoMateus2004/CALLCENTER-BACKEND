package com.callcenter.Service;

import com.callcenter.DAO.BreakRepository;
import com.callcenter.Domain.Break;
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
    public List<Break> getBreaks() {
        return breakRepository.findAll();
    }

    @Override
    @Transactional
    public Break save(Break Break) {
        return breakRepository.save(Break);
    }
}
