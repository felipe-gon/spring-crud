package com.teste.crud.repository;

import com.teste.crud.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    UsuarioModel findByNome(String nome);
    UsuarioModel findByDocumento(String documento);
}
