package com.ProyectoFinal_Web.service;

import com.ProyectoFinal_Web.domain.auditoria;
import java.util.List;

public interface auditoriaService {

    public List<auditoria> getAuditoria();

    public void save(auditoria auditoria);

    public void delete(auditoria auditoria);

    public auditoria getAuditoria(auditoria auditoria);

}
