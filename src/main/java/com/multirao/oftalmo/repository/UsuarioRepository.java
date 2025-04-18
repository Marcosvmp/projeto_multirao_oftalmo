package com.multirao.oftalmo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multirao.oftalmo.dto.UsuarioResponseDTO;
import com.multirao.oftalmo.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    boolean existsByName(String nome);

    boolean existsByEmail(String email);

    List<UsuarioResponseDTO> findByEmailLike(String email);

    List<UsuarioResponseDTO> findByNameLike(String nome);

    List<UsuarioResponseDTO> findAllByOrderByIdDesc();

}
