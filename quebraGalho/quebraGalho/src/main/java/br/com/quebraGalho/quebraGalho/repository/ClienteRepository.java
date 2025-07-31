package br.com.quebraGalho.quebraGalho.repository;

import br.com.quebraGalho.quebraGalho.entity.Administrador;
import br.com.quebraGalho.quebraGalho.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Optional<Cliente> findByEmail(String email);
}
