package com.ProyectoFinal_Web.Controller;

import com.ProyectoFinal_Web.domain.auditoria;
import com.ProyectoFinal_Web.service.auditoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class auditoriaController {

    @Autowired
    private auditoriaService auditoriaService;

    @GetMapping("/auditoria/auditoria")
    public String inicio(Model model) {
        var auditorias = auditoriaService.getAuditoria();
        model.addAttribute("auditorias", auditorias);
        return "/auditoria/auditoria";
    }

    @GetMapping("/auditoria/nuevaAuditoria")
    public String nuevoAuditoria(auditoria auditoria, Model model) {
        model.addAttribute("auditoria", auditoria);
        return "/auditoria/modifica";
    }

    @PostMapping("/auditoria/guardarAuditoria")
    public String guardarAuditoria(auditoria auditoria) {
        auditoriaService.save(auditoria);
        return "redirect:/auditoria/auditoria";
    }

    @GetMapping("/auditoria/modifica/{id_Auditoria}")
    public String modificarAuditoria(auditoria auditoria, Model model) {
        auditoria = auditoriaService.getAuditoria(auditoria);
        model.addAttribute("auditoria", auditoria);
        return "/auditoria/modifica";
    }

    @GetMapping("/auditoria/eliminar/{id_Auditoria}")
    public String eliminarAuditoria(auditoria auditoria) {
        auditoriaService.delete(auditoria);
        return "redirect:/auditoria/auditoria";
    }
}
