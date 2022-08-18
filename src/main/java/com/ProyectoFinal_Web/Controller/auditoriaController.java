package com.ProyectoFinal_Web.Controller;

import com.ProyectoFinal_Web.domain.auditoria;
import com.ProyectoFinal_Web.service.AuditoriaReportService;
import com.ProyectoFinal_Web.service.auditoriaService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private AuditoriaReportService auditoriaReportService;

    @GetMapping(value = "/auditoria/ReporteAuditoria", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFile() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(auditoriaReportService.generateReport()));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);
            return targetArray;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
