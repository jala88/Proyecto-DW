package com.loginAdminController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class loginAdminController {

    @GetMapping("/")
    public String index() {
        log.info("MVC");
        return "index";
    }
}
