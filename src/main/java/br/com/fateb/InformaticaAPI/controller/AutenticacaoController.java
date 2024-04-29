package br.com.fateb.InformaticaAPI.controller;

import br.com.fateb.InformaticaAPI.dto.request.AutenticacaoRequest;
import br.com.fateb.InformaticaAPI.exception.ErrorMessage;
import br.com.fateb.InformaticaAPI.security.jwt.JwtToken;
import br.com.fateb.InformaticaAPI.security.jwt.JwtUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.util.ServerErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    JwtUserDetailsService detailsService;
    AuthenticationManager authenticationManager;

    @Autowired
    public void JwtUserDetailsService(JwtUserDetailsService detailsService,AuthenticationManager authenticationManager) {
        this.detailsService = detailsService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid AutenticacaoRequest autenticacao, HttpServletRequest httpRequest){
        log.info("Processo de autenticação pelo login {}", autenticacao.email());
        try{
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(autenticacao.email(), autenticacao.senha());
            authenticationManager.authenticate(authenticationToken);
            JwtToken token = detailsService.getTokenAuthenticated(autenticacao.email());
            return ResponseEntity.ok(token);
        } catch (AuthenticationException ex){
            log.warn("Bad credentials from username '{}'", autenticacao.email());
        }
        return ResponseEntity
                .badRequest()
                .body(new ErrorMessage(httpRequest, HttpStatus.BAD_REQUEST, "Credenciais invalidas"));
    }
}
