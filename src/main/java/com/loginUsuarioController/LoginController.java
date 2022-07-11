package com.loginUsuarioController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/loginUsuario/loginUser")
    public String user() {
        log.info("MVC");
        return "loginUser";
    }

}
