package com.company.tuberias.tuberias.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="tuberias")
public class Tuberias  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String caracteristicas;
    private String ubicacion;
    private String longintud;
    private String latitud;
}
