package com.ProyectoFinal_Web.service;

import com.ProyectoFinal_Web.domain.Usuario;
import java.util.List;

public interface usuarioService {

    public List<Usuario> getUsuario();

    public void save(Usuario usuario);

    public void delete(Usuario usuario);

    public Usuario getUsuario(Usuario usuario);
}
