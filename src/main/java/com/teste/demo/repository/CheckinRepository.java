package com.teste.demo.repository;

import com.teste.demo.model.CheckinModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckinRepository extends JpaRepository<CheckinModel, Long> {

}