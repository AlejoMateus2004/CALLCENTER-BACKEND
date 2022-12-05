package com.callcenter.Service;

import com.callcenter.Domain.Break;

import java.util.List;

public interface BreakService {

    List<Break> getBreaks();
    Break save(Break Break);


}
