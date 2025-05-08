package com.mucida.study.ninjas;

import com.mucida.study.missoes.MissaoModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tb_ninja")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private int idade;

    @ManyToOne
    @JoinColumn(name = "id_missao")
    private MissaoModel missao;

    public NinjaModel() {
    }

    public NinjaModel(String name, String email, int idade) {
        this.name = name;
        this.email = email;
        this.idade = idade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
