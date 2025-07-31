package br.com.quebraGalho.quebraGalho.service;

import br.com.quebraGalho.quebraGalho.entity.Administrador;
import br.com.quebraGalho.quebraGalho.entity.LoginRequest;
import br.com.quebraGalho.quebraGalho.entity.Profissao;
import br.com.quebraGalho.quebraGalho.entity.Vendedor;
import br.com.quebraGalho.quebraGalho.exception.*;
import br.com.quebraGalho.quebraGalho.repository.ProfissaoRepository;
import br.com.quebraGalho.quebraGalho.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;
    @Autowired
    private ProfissaoRepository profissaoRepository;

    public String add(Vendedor vendedor){
        if(vendedor.getProfissoes()==null){
            throw new ProfissaoObrigatoriaException();
        }
        List<Profissao> profissoesValidas = new ArrayList<>();
        for(Profissao p:vendedor.getProfissoes()){
            Long id = p.getId();
            if(id==null){
                throw new ProfissaoObrigatoriaException();
            }
            Profissao profissaoDoBanco = profissaoRepository.findById(id).
                    orElseThrow(ProfissaoNaoExistenteException::new);

            profissoesValidas.add(profissaoDoBanco);
        }
        vendedor.setProfissoes(profissoesValidas);

        if (vendedor.getAvaliacoes()!=null){
            throw new AvaliacaoNulaExcepetion();
        }
        this.vendedorRepository.save(vendedor);
        return "Vendedor cadastrado com sucesso";
    }
    public String update(Long id,Vendedor vendedor){
        vendedor.setId(id);
        this.vendedorRepository.save(vendedor);
        return "Vendedor cadastrado com sucesso";
    }
    public Vendedor findById(Long id){
        return this.vendedorRepository.findById(id).orElseThrow(VendedorNuloException::new);
    }
    public String delete(Long id){
        this.vendedorRepository.deleteById(id);
        return "Vendedor deletado com sucesso";
    }
    public List<Vendedor> findAll(){
        List<Vendedor> lista =  this.vendedorRepository.findAll();
        return lista;
    }
    public Vendedor login(LoginRequest loginRequest){
        Optional<Vendedor> v = this.vendedorRepository.findByEmail(loginRequest.getEmail());
        if (v.isEmpty()){
            throw new VendedorNuloException();
        }
        Vendedor vendedor = v.get();
        if(vendedor.getSenha().equals(loginRequest.getSenha())){
            return vendedor;
        }
        throw new DadosNaoConferemException();
    }
}
