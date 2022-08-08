package com.ProyectoFinal_Web.Controller;

import com.ProyectoFinal_Web.domain.auditor;
import com.ProyectoFinal_Web.service.auditorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class auditorController {

    @Autowired
    private auditorService auditorService;

    @GetMapping("/auditor/auditor")
    public String inicio(Model model) {
        var auditores = auditorService.getAuditor();
        model.addAttribute("auditores", auditores);
        return "/auditor/auditor";
    }

    @GetMapping("/auditor/nuevoAuditor")
    public String nuevoAuditor(auditor auditor, Model model) {
        model.addAttribute("auditor", auditor);
        return "/auditor/modifica";
    }

    @PostMapping("/auditor/guardarAuditor")
    public String guardarAuditor(auditor auditor) {
        auditorService.save(auditor);
        return "redirect:/auditor/auditor";
    }

    @GetMapping("/auditor/modifica/{id_Auditor}")
    public String modificarAuditor(auditor auditor, Model model) {
        auditor = auditorService.getAuditor(auditor);
        model.addAttribute("auditor", auditor);
        return "/auditor/modifica";
    }

    @GetMapping("/auditor/eliminar/{id_Auditor}")
    public String eliminarAuditor(auditor auditor) {
        auditorService.delete(auditor);
        return "redirect:/auditor/auditor";
    }
}
