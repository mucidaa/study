package com.mucida.study.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "tb_ninja")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private int idade;

    @ManyToOne
    @JoinColumn(name = "id_missao")
    private MissaoModel missao;
}
