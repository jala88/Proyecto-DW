package com.ProyectoFinal_Web.Controller;

import com.ProyectoFinal_Web.domain.solicitarAuditoria;
import com.ProyectoFinal_Web.service.solicitudServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class solicitarAuditoriaController {

    @Autowired
    private solicitudServices solicitudServices;

    @GetMapping("/solicitarAuditoria/solicitar")
    public String inicio(Model model) {
        var solicitudes = solicitudServices.getSolicitarAuditoria();
        model.addAttribute("solicitudes", solicitudes);
        return "/solicitarAuditoria/solicitar";
    }

    @GetMapping("/solicitarAuditoria/nuevaSolicitud")
    public String nuevaSolicitud(solicitarAuditoria solicitud, Model model) {
        model.addAttribute("solicitud", solicitud);
        return "/solicitarAuditoria/modifica";
    }

    @PostMapping("/solicitarAuditoria/guardarSolicitud")
    public String guardarSolicitud(solicitarAuditoria solicitud) {
        solicitudServices.save(solicitud);
        return "redirect:/solicitarAuditoria/solicitar";
    }

    @GetMapping("/solicitarAuditoria/modifica/{id_Solicitud}")
    public String modificarSolicitud(solicitarAuditoria solicitud, Model model) {
        solicitud = solicitudServices.getSolicitarAuditoria(solicitud);
        model.addAttribute("solicitud", solicitud);
        return "/solicitarAuditoria/modifica";
    }
    
    @GetMapping("/solicitarAuditoria/eliminar/{id_Solicitud}")
    public String eliminarSolicitud(solicitarAuditoria solicitud) {
        solicitudServices.delete(solicitud);
        return "redirect:/solicitarAuditoria/solicitar";
    }
}
