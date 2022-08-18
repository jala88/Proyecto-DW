package com.ProyectoFinal_Web.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Usuario;
    String username;
    String password;
    String nombre;
    String correo;
    String cedula;
    Long idRol;

    public Usuario() {
    }

    public Usuario(String username, String password, String nombre, String correo, String cedula, Long idRol) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.correo = correo;
        this.cedula = cedula;
        this.idRol = idRol;
    }

}
