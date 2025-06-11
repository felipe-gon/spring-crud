package com.teste.crud.repository;

import com.teste.crud.model.CheckinModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckinRepository extends JpaRepository<CheckinModel, Long> {

}