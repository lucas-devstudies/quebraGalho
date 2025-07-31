package br.com.quebraGalho.quebraGalho.service;

import br.com.quebraGalho.quebraGalho.entity.Avaliacao;
import br.com.quebraGalho.quebraGalho.entity.AvaliacaoCriacaoDTO;
import br.com.quebraGalho.quebraGalho.entity.Vendedor;
import br.com.quebraGalho.quebraGalho.exception.AvaliacaoNulaExcepetion;
import br.com.quebraGalho.quebraGalho.exception.VendedorNuloException;
import br.com.quebraGalho.quebraGalho.repository.AvaliacaoRepository;
import br.com.quebraGalho.quebraGalho.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    public String add(AvaliacaoCriacaoDTO avaliacaoCriacaoDTO){
        if (avaliacaoCriacaoDTO.getIdVendedor()==null){
            throw new VendedorNuloException();
        }
        Long idVendedor = avaliacaoCriacaoDTO.getIdVendedor();
        Vendedor vendedorExistente = vendedorRepository.findById(idVendedor)
                .orElseThrow(VendedorNuloException::new);

        Avaliacao a = new  Avaliacao();
        a.setNota(avaliacaoCriacaoDTO.getNota());
        a.setNota(avaliacaoCriacaoDTO.getNota());
        a.setTitulo(avaliacaoCriacaoDTO.getTitulo());
        a.setDescricao(avaliacaoCriacaoDTO.getDescricao());
        a.setVendedor(vendedorExistente);
        this.avaliacaoRepository.save(a);
        return "Salvo com sucesso";
    }
    public String update(Long id, AvaliacaoCriacaoDTO avaliacaoCriacaoDTO){
        if (avaliacaoCriacaoDTO.getIdVendedor()==null){
            throw new VendedorNuloException();
        }
        Avaliacao a = avaliacaoRepository.findById(id).orElseThrow(AvaliacaoNulaExcepetion::new);
        a.setNota(avaliacaoCriacaoDTO.getNota());
        a.setTitulo(avaliacaoCriacaoDTO.getTitulo());
        a.setDescricao(avaliacaoCriacaoDTO.getDescricao());
        //Não permite alterar o Vendedor. Nesse caso deve excluir a alteração
        this.avaliacaoRepository.save(a);
        return "Carro atualizado com sucesso";
    }

    public Avaliacao findById(Long id){
        Avaliacao a = this.avaliacaoRepository.findById(id).get();
        if(a.getId()==null){
            throw new AvaliacaoNulaExcepetion();
        }
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
    public Double findMediaNotas(Long id) {
        Optional<Vendedor> v = vendedorRepository.findById(id);
        if (v.isEmpty()){
            throw new VendedorNuloException();
        }
        Optional<Double> media = this.avaliacaoRepository.findMediaNotas(id);
        return media.orElse(0.0);
    }
}
