package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.UsuarioCreateDTO;
import com.dbc.pessoaapi.dto.UsuarioDTO;
import com.dbc.pessoaapi.entity.GrupoEntity;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.repository.GrupoRepository;
import com.dbc.pessoaapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final GrupoRepository grupoRepository;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public UsuarioDTO create(UsuarioCreateDTO usuarioCreateDTO) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setLogin(usuarioCreateDTO.getUsuario());
        entity.setSenha(new BCryptPasswordEncoder().encode(usuarioCreateDTO.getSenha()));
        entity.setGrupos(
                usuarioCreateDTO.getGrupos().stream()
                        .map(grupoId -> grupoRepository.findById(grupoId)
                                .orElse(null))
                        .collect(Collectors.toList())
        );
        UsuarioEntity save = usuarioRepository.save(entity);
        return new UsuarioDTO(save.getIdUsuario(), save.getUsername(), save.getGrupos().stream().map(GrupoEntity::getIdGrupo).collect(Collectors.toList()));

    }
}
