package com.ProyectoFinal_Web.service;

import com.ProyectoFinal_Web.domain.auditor;
import java.util.List;

public interface auditorService {

    public List<auditor> getAuditor();

    public void save(auditor auditor);

    public void delete(auditor auditor);

    public auditor getAuditor(auditor auditor);
}
