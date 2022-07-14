package com.ProyectoFinal_Web.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class loginAdminController {

    @GetMapping("/loginAdmin/logAdmin")
    public String inicio() {
        return "loginAdmin/logAdmin";
    }
    
}
