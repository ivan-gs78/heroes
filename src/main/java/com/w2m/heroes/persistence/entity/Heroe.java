package com.w2m.heroes.persistence.entity;


import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "heroe")
@Data
public class Heroe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter
    private String name;
    @Setter
    private String campo1;
    @Setter
    private String campo2;
    @Setter
    private String campo3;
    @Setter
    private String status;

}
