package com.teste.demo.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity //Criar a tabela no BD
@Table(name = "tb_usuario") //Cria a tabela com o nome tb_pessoa no banco
@NoArgsConstructor //Cria o construtor vazio
@AllArgsConstructor //Cria o construtor cheio
@Data //Cria os getters e setters

public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "pessoa")     //Cria o vinculo com o atributo pessoa da classe UsuarioModel, 1 Usuario para N checkin
    private List<CheckinModel> checkins;

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

    private String documento;
    private String telefone;

    public UsuarioModel(String nome){
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
}