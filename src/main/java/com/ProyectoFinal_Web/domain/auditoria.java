package com.ProyectoFinal_Web.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "auditoria")
public class auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Auditoria;
    private String auditor;
    private String fecha;
    private String area_auditada;
    private String calificacion;

    public auditoria() {
    }

    public auditoria(String auditor, String fecha, String area_auditada, String calificacion) {
        this.auditor = auditor;
        this.fecha = fecha;
        this.area_auditada = area_auditada;
        this.calificacion = calificacion;
    }

}
