package com.dbc.pessoaapi.security;

import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getTokenFromHeader(request);
        Optional<UsuarioEntity> usuario = tokenService.isValid(token);

        authenticate(usuario);
        filterChain.doFilter(request, response);
    }

    private void authenticate(Optional<UsuarioEntity> usuario) {
        if(usuario.isPresent()) {
            UsuarioEntity usuarioEntity = usuario.get();
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    usuarioEntity.getLogin(),
                    usuarioEntity.getSenha(),
                    Collections.emptyList()
            );
            SecurityContextHolder.getContext().setAuthentication(token);
        } else {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }

    private String getTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token==null) {
            return null;
        }
        return token;
    }
}
