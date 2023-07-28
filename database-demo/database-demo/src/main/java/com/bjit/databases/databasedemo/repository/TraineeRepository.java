package com.bjit.databases.databasedemo.repository;

import com.bjit.databases.databasedemo.model.Trainee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraineeRepository extends CrudRepository<Trainee, Long> {
        List<Trainee> findAll();
        //Trainee deleteByName(String name);
}
