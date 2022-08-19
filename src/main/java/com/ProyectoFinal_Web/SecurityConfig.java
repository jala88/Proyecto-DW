package com.ProyectoFinal_Web;

import com.ProyectoFinal_Web.service.UsuarioDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UsuarioDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication()
//                .withUser("Admin")
//                .password("{noop}123")
//                .roles("ADMIN")
//                .and()
//                .withUser("Usuario")
//                .password("{noop}123")
//                .roles("USER");
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/auditoria/nuevaAuditoria", "/auditoria/guardarAuditoria",
                        "/auditoria/modifica/**", "/auditoria/eliminar/**",
                        "/solicitarAuditoria/nuevaSolicitud", "/solicitarAuditoria/guardarSolicitud",
                        "/solicitarAuditoria/modifica/**", "/solicitarAuditoria/eliminar/**",
                        "/fqa/fqa", "/material/material", "/noticias/noticias")
                .hasAnyRole("ADMIN", "USER")
                .antMatchers("/auditor/nuevoAuditor", "/auditor/guardarAuditor",
                        "/auditor/modifica/**", "/auditor/eliminar/**",
                        "/usuarios/nuevoUsuario", "/usuarios/guardarUsuario",
                        "/usuarios/modifica/**", "/usuarios/eliminar/**",
                        "/auditoria/ReporteAuditoria")
                .hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");
    }

}
