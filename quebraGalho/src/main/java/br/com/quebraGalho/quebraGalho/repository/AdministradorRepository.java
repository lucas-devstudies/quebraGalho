package br.com.quebraGalho.quebraGalho.repository;

import br.com.quebraGalho.quebraGalho.entity.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador,Long> {
    Optional<Administrador> findByEmail(String email);

}
