package br.com.quebraGalho.quebraGalho.repository;

import br.com.quebraGalho.quebraGalho.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendedorRepository extends JpaRepository<Vendedor,Long> {
    Optional<Vendedor> findByEmail(String email);

}
