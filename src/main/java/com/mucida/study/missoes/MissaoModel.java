package com.mucida.study.missoes;

import com.mucida.study.ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missao")
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String dificuldade;

    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;


}
