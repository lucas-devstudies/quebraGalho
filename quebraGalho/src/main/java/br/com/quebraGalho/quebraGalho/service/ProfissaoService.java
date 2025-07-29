package br.com.quebraGalho.quebraGalho.service;

import br.com.quebraGalho.quebraGalho.entity.Profissao;
import br.com.quebraGalho.quebraGalho.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissaoService {

    @Autowired
    private ProfissaoRepository profissaoRepository;

    public String add(Profissao profissao){
        this.profissaoRepository.save(profissao);
        return "Salvo com sucesso";
    }
    public String update(Long id, Profissao profissao){
        profissao.setId(id);
        this.profissaoRepository.save(profissao);
        return "Carro atualizado com sucesso";
    }

    public Profissao findById(Long id){
        Profissao p = this.profissaoRepository.findById(id).get();
        return p;
    }
    public String delete(Long id){
        this.profissaoRepository.deleteById(id);
        return "Deletado com sucesso";
    }
    public List<Profissao> findAll(){
        List<Profissao> lista = this.profissaoRepository.findAll();
        return lista;
    }
}
