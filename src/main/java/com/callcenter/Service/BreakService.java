package com.callcenter.Service;

import com.callcenter.Domain.Break;
import com.callcenter.Domain.Record;

import java.util.List;

public interface BreakService {

    List<Break> getBreaksByidrecord(Record record);
    Break save(Break Break);

    Break getBreaksByidBreak(int idbreak);


}
