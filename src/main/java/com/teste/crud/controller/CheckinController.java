package com.teste.crud.controller;

import com.teste.crud.model.CheckinModel;
import com.teste.crud.model.UsuarioModel;
import com.teste.crud.repository.CheckinRepository;
import com.teste.crud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkin")
public class CheckinController {

    @Autowired
    private CheckinRepository checkinRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/newCheckin")
    public ResponseEntity newCheckin (@RequestBody CheckinModel request){

        UsuarioModel usuario = usuarioRepository.findByNome(request.getPessoa().getNome()); //Busca o nome do usuario já cadastrado via POST do UusarioController
        if (usuario == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O usuário informado não foi encontrado!");
        }
        request.setPessoa(usuario);
        CheckinModel checkinSalvo = checkinRepository.save(request);
        return ResponseEntity.ok("Check in realizado com sucesso!");
    }
}
