package com.ProyectoFinal_Web.Controller;

import com.ProyectoFinal_Web.domain.Usuario;
import com.ProyectoFinal_Web.service.usuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class usuarioController {

    @Autowired
    private usuarioService usuarioService;

    @GetMapping("/usuarios/usuario")
    public String inicio(Model model) {
        var usuarios = usuarioService.getUsuario();
        model.addAttribute("usuarios", usuarios);
        return "/usuarios/usuario";
    }

    @GetMapping("/usuarios/nuevoUsuario")
    public String nuevoUsuario(Usuario usuario, Model model) {
        model.addAttribute("usuario", usuario);
        return "/usuarios/modifica";
    }

    @PostMapping("/usuarios/guardarUsuario")
    public String guardarUsuario(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuarios/usuario";
    }

    @GetMapping("/usuarios/modifica/{id_Usuario}")
    public String modificarUsuario(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuarios/modifica";
    }

    @GetMapping("/usuarios/eliminar/{id_Usuario}")
    public String eliminarUsuario(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuarios/usuario";
    }
}
