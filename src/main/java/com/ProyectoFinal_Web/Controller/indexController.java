
package com.ProyectoFinal_Web.Controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Kevin
 */
public class indexController {
    
    
    @GetMapping("/")
    public String inicio() {
        return "index";
    }
}
