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
@Table(name = "solicitar_auditoria")
public class solicitarAuditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Solicitud;
    private String nombre_solicitante;
    private String correo;
    private String telefono;
    private String cedula;
    private String puesto;
    private String empresa;
    private String area_empre;
    private String ced_empre;
    private String correo_empre;
    private String direccion_empre;

    public solicitarAuditoria() {

    }

    public solicitarAuditoria(String nombre_solicitante, String correo,
            String telefono, String cedula, String puesto, String empresa,
            String area_empre, String ced_empre, String correo_empre,
            String direccion_empre) {
        this.nombre_solicitante = nombre_solicitante;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
        this.puesto = puesto;
        this.empresa = empresa;
        this.area_empre = area_empre;
        this.ced_empre = ced_empre;
        this.correo_empre = correo_empre;
        this.direccion_empre = direccion_empre;
    }

}
