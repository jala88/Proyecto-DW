package com.ProyectoFinal_Web.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "auditor")

public class auditor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Auditor;
    private String nombre;
    private String apellidos;
    private String correo;
    private String cedula;

    public auditor() {
    }

    public auditor(String nombre, String apellidos, String correo, String cedula) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.cedula = cedula;
    }

}
