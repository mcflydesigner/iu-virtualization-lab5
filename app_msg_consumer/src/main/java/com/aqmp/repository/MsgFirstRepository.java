package com.aqmp.repository;

import com.aqmp.model.MsgFirst;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  MsgFirstRepository extends CrudRepository<MsgFirst, Long> {

}
