package com.ProyectoFinal_Web.service;

import com.ProyectoFinal_Web.dao.UsuarioDao;
import com.ProyectoFinal_Web.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class usuarioServiceImpl implements usuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuario() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getId_Usuario()).orElse(null);
    }

}
