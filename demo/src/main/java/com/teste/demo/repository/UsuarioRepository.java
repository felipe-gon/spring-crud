package com.teste.demo.repository;

import com.teste.demo.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    UsuarioModel findByNome(String nome);
    UsuarioModel findByDocumento(String documento);
}
