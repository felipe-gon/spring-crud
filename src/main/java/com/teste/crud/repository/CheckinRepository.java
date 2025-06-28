package com.teste.crud.repository;

import com.teste.crud.model.CheckinModel;
import com.teste.crud.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckinRepository extends JpaRepository<CheckinModel, Long> {
List<CheckinModel> findByPessoa(UsuarioModel pessoa);
}