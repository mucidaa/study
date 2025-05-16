package com.mucida.study.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "tb_ninja")
@Data
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
