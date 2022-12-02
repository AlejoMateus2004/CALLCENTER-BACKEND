package com.callcenter.DAO;

import com.callcenter.Domain.Break;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreakRepository extends JpaRepository<Break, Integer> {
}