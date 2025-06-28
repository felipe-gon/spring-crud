package com.teste.crud.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "pessoa")     //Cria o vinculo com o atributo pessoa da classe UsuarioModel, 1 Usuario para N checkin
    @JsonIgnore
    private List<CheckinModel> checkins;
    private String documento;
    private String telefone;


    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public UsuarioModel(String nome){
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
}