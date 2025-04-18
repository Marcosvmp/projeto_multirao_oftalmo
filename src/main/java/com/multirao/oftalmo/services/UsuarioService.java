package com.multirao.oftalmo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.token.TokenService;
import com.multirao.oftalmo.config.TokenService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.multirao.oftalmo.dto.LoginRequestDTO;
import com.multirao.oftalmo.dto.LoginResponseDTO;
import com.multirao.oftalmo.dto.UsuarioResponseDTO;
import com.multirao.oftalmo.models.Usuario;
import com.multirao.oftalmo.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    // salva um usuario
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<Object> save(Usuario usuario) {

        usuarioRepository.save(usuario);
        return ResponseEntity.status(201).body("Usuario cadastrado com sucesso!");
    }

    // deleta um usuario
    public ResponseEntity<Object> deleteById(Long id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.status(200).body("Usuario deletado com sucesso!");
    }

    public ResponseEntity<Object> listUsuario() {
        List<UsuarioResponseDTO> usuarios = usuarioRepository.findAllByOrderByIdDesc();
        return ResponseEntity.status(200).body(usuarios);
    }

    public ResponseEntity<Object> listEmail(Usuario usuario) {
        List<UsuarioResponseDTO> usuarios = usuarioRepository.findByEmailLike("%" + usuario.getEmail() + "%");
        return ResponseEntity.status(200).body(usuarios);

    }

    public ResponseEntity<Object> listName(Usuario usuario) {
        List<UsuarioResponseDTO> usuarios = usuarioRepository.findByNameLike("%" + usuario.getName() + "%");
        return ResponseEntity.status(200).body(usuarios);
    }

    public ResponseEntity<Object> login(LoginRequestDTO usuarioDTO) {
        try {
            System.out.println(usuarioDTO.email());
            Usuario usuario = usuarioRepository.findByEmail(usuarioDTO.email())
                    .orElseThrow(() -> new UsernameNotFoundException("email ou senha inválidos!"));

            if (passwordEncoder.matches(usuarioDTO.password(), usuario.getPassword())) {
                String token = this.tokenService.generateToken(usuario);

                return ResponseEntity.ok().body(new LoginResponseDTO(usuario.getName(), usuario.getEmail(), token));
            }

            return ResponseEntity.status(400).body("email ou senha inválidos!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }

}
