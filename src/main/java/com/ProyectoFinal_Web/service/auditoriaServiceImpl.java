package com.ProyectoFinal_Web.service;

import com.ProyectoFinal_Web.dao.auditoriaDao;
import com.ProyectoFinal_Web.domain.auditoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class auditoriaServiceImpl implements auditoriaService {

    @Autowired
    private auditoriaDao auditoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<auditoria> getAuditor() {
        return (List<auditoria>) auditoriaDao.findAll();
    }

    @Override
    @Transactional
    public void save(auditoria auditoria) {
        auditoriaDao.save(auditoria);
    }

    @Override
    @Transactional
    public void delete(auditoria auditoria) {
        auditoriaDao.delete(auditoria);
    }

    @Override
    @Transactional(readOnly = true)
    public auditoria getAuditoria(auditoria auditoria) {
        return auditoriaDao.findById(auditoria.getId_Auditoria()).orElse(null);
    }
}
