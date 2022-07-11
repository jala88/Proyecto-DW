package com.noticiasController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class noticiasController {

    /*
    @GetMapping("/Noticias/noticias")
    public String inicio() {
        log.info("MVC");
        return "noticias";
    }
     */
    @RequestMapping(path = "/Noticias/noticias", method = RequestMethod.GET)
    public String noticias() {
        System.out.println("mvc");
        return "noticias";
    }
}
