package br.com.fateb.InformaticaAPI.security.jwt;

import br.com.fateb.InformaticaAPI.repository.ProdutoRepository;
import br.com.fateb.InformaticaAPI.service.CategoriaService;
import br.com.fateb.InformaticaAPI.service.FornecedorService;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    JwtUserDetailsService detailsService;

    @Autowired
    public void JwtUserDetailsService(JwtUserDetailsService detailsService) {
        this.detailsService = detailsService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String token = request.getHeader(JwtUtils.JWT_AUTHORIZATION);
        if(token == null || !token.startsWith(JwtUtils.JWT_BEARER)){
            log.info("JWT esta nulo, vaziou ou não iniciado com 'Bearer '.");
            filterChain.doFilter(request, response);
            return;
        }

        if(!JwtUtils.isTokenValid(token)){
            log.warn("JWT esta invalido ou expirado.");
            filterChain.doFilter(request, response);
            return;
        }

        String login = JwtUtils.getUsernameFromToken(token);

        toAuthentication(request, login);

        filterChain.doFilter(request, response);
    }

    private void toAuthentication(HttpServletRequest request, String login) {
        UserDetails userDetails = detailsService.loadUserByUsername(login);

        UsernamePasswordAuthenticationToken authenticationToken = UsernamePasswordAuthenticationToken
                .authenticated(userDetails, null, userDetails.getAuthorities());

        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
}
