package com.example.May_Test.repository;

import com.example.May_Test.model.BmsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BmsRepository extends JpaRepository<BmsModel, Long> {
    // it will fetch all the records of Employees in Ascending order of their salary..
    public List<BmsModel> findByOrderBySubjectAsc();

    public List<BmsModel> findBySubject(String subject);

    public List<BmsModel> findByNameAndSubject(String name, String subject);

}
