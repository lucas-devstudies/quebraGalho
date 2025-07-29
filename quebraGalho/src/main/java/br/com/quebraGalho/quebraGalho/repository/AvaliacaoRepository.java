package br.com.quebraGalho.quebraGalho.repository;

import br.com.quebraGalho.quebraGalho.entity.Avaliacao;
import br.com.quebraGalho.quebraGalho.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    //Listar avaliações de determinado Vendedor
    public List<Avaliacao> findByVendedor(Vendedor vendedor);

    //somar e mostrar a média de notas
    //@Query("SELECT SUM(a.notas)/FROM Avaliacao a WHERE a.id_vendedor= :id")
    //public Float findMediaNotas(int id);

}
