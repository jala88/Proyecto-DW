package com.ProyectoFinal_Web.service;

import com.ProyectoFinal_Web.dao.solicitudDao;
import com.ProyectoFinal_Web.domain.solicitarAuditoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class solicitudServicesImpl implements solicitudServices {

    @Autowired
    private solicitudDao solicitudDao;

    @Override
    @Transactional(readOnly = true)
    public List<solicitarAuditoria> getSolicitarAuditoria() {
        return (List<solicitarAuditoria>) solicitudDao.findAll();
    }

    @Override
    @Transactional
    public void save(solicitarAuditoria solicitud) {
        solicitudDao.save(solicitud);
    }

    @Override
    @Transactional
    public void delete(solicitarAuditoria solicitud) {
        solicitudDao.delete(solicitud);
    }

    @Override
    @Transactional(readOnly = true)
    public solicitarAuditoria getSolicitarAuditoria(solicitarAuditoria solicitud) {
        return solicitudDao.findById(solicitud.getId_Solicitud()).orElse(null);
    }
}
