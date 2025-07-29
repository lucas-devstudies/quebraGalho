package br.com.quebraGalho.quebraGalho.service;

import br.com.quebraGalho.quebraGalho.entity.Avaliacao;
import br.com.quebraGalho.quebraGalho.entity.Vendedor;
import br.com.quebraGalho.quebraGalho.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public String add(Avaliacao avaliacao){
        this.avaliacaoRepository.save(avaliacao);
        return "Salvo com sucesso";
    }
    public String update(Long id, Avaliacao avaliacao){
        avaliacao.setId(id);
        this.avaliacaoRepository.save(avaliacao);
        return "Carro atualizado com sucesso";
    }

    public Avaliacao findById(Long id){
        Avaliacao a = this.avaliacaoRepository.findById(id).get();
        return a;
    }
    public String delete(Long id){
        this.avaliacaoRepository.deleteById(id);
        return "Deletado com sucesso";
    }
    public List<Avaliacao> findAll(){
        List<Avaliacao> lista = this.avaliacaoRepository.findAll();
        return lista;
    }
    public List<Avaliacao> findByVendedor(long id){
        Vendedor v = new Vendedor();
        v.setId(id);
        return this.avaliacaoRepository.findByVendedor(v);
    }
}
