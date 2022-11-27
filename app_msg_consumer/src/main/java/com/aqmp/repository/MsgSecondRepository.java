package com.aqmp.repository;

import com.aqmp.model.MsgSecond;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MsgSecondRepository extends CrudRepository<MsgSecond, Long> {
}
