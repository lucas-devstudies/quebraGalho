package br.com.quebraGalho.quebraGalho.service;

import br.com.quebraGalho.quebraGalho.entity.Profissao;
import br.com.quebraGalho.quebraGalho.exception.ProfissaoNaoExistenteException;
import br.com.quebraGalho.quebraGalho.exception.ProfissaoObrigatoriaException;
import br.com.quebraGalho.quebraGalho.exception.ProfissaoSemNomeException;
import br.com.quebraGalho.quebraGalho.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissaoService {

    @Autowired
    private ProfissaoRepository profissaoRepository;

    public String add(Profissao profissao) throws ProfissaoSemNomeException {
        Optional<Profissao> pr = Optional.of(profissao);
        if(pr.isEmpty()) {
            throw new ProfissaoSemNomeException();
        }
        Profissao p = pr.get();
        if(p.getNome().length()<=3){
            throw new ProfissaoSemNomeException();
        }
        this.profissaoRepository.save(profissao);
        return "Salvo com sucesso";
    }
    public String update(Long id, Profissao profissao){
        profissao.setId(id);
        Optional<Profissao> pr = Optional.of(profissao);
        if(pr.isEmpty()){
            throw new ProfissaoObrigatoriaException();
        }
        Profissao p = pr.get();
        if(p.getNome()!=null)
        {
            throw new ProfissaoSemNomeException();
        }
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
