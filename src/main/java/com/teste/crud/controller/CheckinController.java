package com.teste.crud.controller;

import com.teste.crud.dto.TotalGastoDTO;
import com.teste.crud.model.CheckinModel;
import com.teste.crud.model.UsuarioModel;
import com.teste.crud.repository.CheckinRepository;
import com.teste.crud.repository.UsuarioRepository;
import com.teste.crud.service.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkin")
public class CheckinController {

    @Autowired
    private CheckinRepository checkinRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CheckinService checkinService;

    @PostMapping("/newCheckin")
    public ResponseEntity newCheckin (@RequestBody CheckinModel request){

        UsuarioModel usuario = usuarioRepository.findByNome(request.getPessoa().getNome()); //Busca o nome do usuario já cadastrado via POST do UusarioController
        if (usuario == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O usuário informado não foi encontrado!");
        }
        request.setPessoa(usuario);
        checkinService.diariaComGaragem(request); //Aplica a regra de negócio do service
        CheckinModel checkinSalvo = checkinRepository.save(request);
        return ResponseEntity.ok("Check in realizado com sucesso!");
    }

    @GetMapping("/getTotalCost/{nome}")
    public ResponseEntity getTotalCost (@PathVariable String nome){
        UsuarioModel usuario = usuarioRepository.findByNome(nome);
        List<CheckinModel> checkins = checkinRepository.findByPessoa(usuario);
        double totalGasto = checkins.stream()
                .mapToDouble(CheckinModel::getValorTotal)
                .sum();

        TotalGastoDTO totalGastoDTO = new TotalGastoDTO(totalGasto);
        return ResponseEntity.ok("O valor total gasto até o momento é: R$ "+ totalGastoDTO.getValorTotal());
    }
}