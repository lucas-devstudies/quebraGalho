package br.com.quebraGalho.quebraGalho.repository;

import br.com.quebraGalho.quebraGalho.entity.Avaliacao;
import br.com.quebraGalho.quebraGalho.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    //somar e mostrar a média de notas
    @Query("SELECT AVG(a.nota) FROM Avaliacao a WHERE a.vendedor.id = :idVendedor")
    public Optional<Double> findMediaNotas(@Param("idVendedor") Long idVendedor);

}
