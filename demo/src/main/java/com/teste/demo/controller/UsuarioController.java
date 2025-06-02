package com.teste.demo.controller;

import com.teste.demo.DTO.UsuarioDTO;
import com.teste.demo.DataFormatter;
import com.teste.demo.model.UsuarioModel;
import com.teste.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class UsuarioController {


    @GetMapping("/getUsers")
    public ResponseEntity buscaUsuario() {
        var allProducts = usuarioRepository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("/getUserByName/{nome}")
    public ResponseEntity<UsuarioModel> buscaPorNome(@PathVariable String nome){
        UsuarioModel usuarioNome = usuarioRepository.findByNome(nome);
        return ResponseEntity.ok(usuarioNome);
    }

    @GetMapping("/getUserByDoc/{documento}")
    public ResponseEntity<UsuarioModel> buscaPorDocumento(@PathVariable String documento){
        UsuarioModel usuarioDoc = usuarioRepository.findByDocumento(documento);
        return ResponseEntity.ok(usuarioDoc);
    }

    @Autowired
    private UsuarioRepository usuarioRepository;
    DataFormatter formatter = new DataFormatter();


    @PostMapping("/createUser")
    public ResponseEntity<String> criaUsuario(@RequestBody UsuarioModel usuario) { //Cria o metodo POST que recebe o JSON de criação

        UsuarioModel usuarioSalvo = usuarioRepository.save(usuario); //Cria uma instancia do Model e recebe o metodo save do JPA para salvar usuario na tabela
        System.out.println("Usuario " + usuario.getNome() + " criado em " + formatter.formatador);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário " + usuario.getNome() + " criado com sucesso!"); //Retorna um 200 na requisição e retorna o usuario informado no POST
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deletaUsuario(@RequestBody UsuarioDTO delete){ //Cria o metodo DELETE que recebe o JSON de delete
        Long id = delete.getId(); // Cria uma variavel id para receber o ID do DTO
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok("Usuário deletado com sucesso!");

    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UsuarioModel update){
        UsuarioModel usuario = usuarioRepository.getReferenceById(id);
        usuario.setNome(update.getNome());
        usuario.setDocumento(update.getDocumento());
        usuario.setTelefone(update.getTelefone());
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario atualizado com sucesso!");
    }
}