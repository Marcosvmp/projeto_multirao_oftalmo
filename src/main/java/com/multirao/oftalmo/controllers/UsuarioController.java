package com.multirao.oftalmo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multirao.oftalmo.dto.LoginRequestDTO;
import com.multirao.oftalmo.models.Usuario;
import com.multirao.oftalmo.repository.UsuarioRepository;
import com.multirao.oftalmo.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // salvar
    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Usuario usuario) {
        if (usuarioRepository.existsByName(usuario.getName())) {
            return ResponseEntity.badRequest().body("Nome de usuario já existe!");
        }

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            return ResponseEntity.badRequest().body("Email de usuario ja existe!");
        }

        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));

        return usuarioService.save(usuario);

    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDTO usuario) {
        return usuarioService.login(usuario);
    }

    // deleta usuario
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

}
