package com.ProyectoFinal_Web.dao;

import com.ProyectoFinal_Web.domain.solicitarAuditoria;
import org.springframework.data.repository.CrudRepository;

public interface solicitudDao extends CrudRepository<solicitarAuditoria, Long> {

}
