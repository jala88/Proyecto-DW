package com.ProyectoFinal_Web.service;

import com.ProyectoFinal_Web.domain.solicitarAuditoria;
import java.util.List;

public interface solicitudServices {

    public List<solicitarAuditoria> getSolicitarAuditoria();

    public void save(solicitarAuditoria solicitud);

    public void delete(solicitarAuditoria solicitud);

    public solicitarAuditoria getSolicitarAuditoria(solicitarAuditoria solicitud);
}
