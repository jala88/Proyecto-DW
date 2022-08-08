package com.ProyectoFinal_Web.service;

import com.ProyectoFinal_Web.dao.auditorDao;
import com.ProyectoFinal_Web.domain.auditor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class auditorServiceImpl implements auditorService {

    @Autowired
    private auditorDao auditorDao;

    @Override
    @Transactional(readOnly = true)
    public List<auditor> getAuditor() {
        return (List<auditor>) auditorDao.findAll();
    }

    @Override
    @Transactional
    public void save(auditor auditor) {
        auditorDao.save(auditor);
    }

    @Override
    @Transactional
    public void delete(auditor auditor) {
        auditorDao.delete(auditor);
    }

    @Override
    @Transactional(readOnly = true)
    public auditor getAuditor(auditor auditor) {
        return auditorDao.findById(auditor.getId_Auditor()).orElse(null);
    }
}
