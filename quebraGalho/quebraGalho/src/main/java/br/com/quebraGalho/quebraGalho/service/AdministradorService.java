package br.com.quebraGalho.quebraGalho.service;

import br.com.quebraGalho.quebraGalho.entity.Administrador;
import br.com.quebraGalho.quebraGalho.entity.LoginRequest;
import br.com.quebraGalho.quebraGalho.exception.AdministradorIncompletoException;
import br.com.quebraGalho.quebraGalho.exception.AdministradorNuloException;
import br.com.quebraGalho.quebraGalho.exception.DadosNaoConferemException;
import br.com.quebraGalho.quebraGalho.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    public String add(Administrador al){
        Optional<Administrador> a = Optional.ofNullable(al);
        if(a.isEmpty()){
            throw new AdministradorIncompletoException();
        }
        Administrador adm = a.get();
        if (adm.getNome() !=null && adm.getCpf() != null && adm.getSenha()!=null && adm.getEmail()!=null)
        {
            this.administradorRepository.save(adm);
            return "Administrador adicionado com sucesso";
        }
        throw new AdministradorIncompletoException();
    }
    public String update(Long id, Administrador administrador){
        administrador.setId(id);
        this.administradorRepository.save(administrador);
        return "Administrador atualizado com sucesso";
    }
    public Administrador findById(Long id){
        return administradorRepository.findById(id)
                .orElseThrow(AdministradorNuloException::new);
    }
    public String delete(Long id){
        this.administradorRepository.deleteById(id);
        return "Administrador removido com sucesso";
    }
    public List<Administrador> findAll(){
        List<Administrador> lista = this.administradorRepository.findAll();
        return lista;
    }
    public Administrador login(LoginRequest loginRequest){
        Optional<Administrador> a = this.administradorRepository.findByEmail(loginRequest.getEmail());
        if (a.isEmpty()){
            throw new AdministradorNuloException();
        }
        Administrador adm = a.get();
        if(adm.getSenha().equals(loginRequest.getSenha())){
            return adm;
        }
        throw new DadosNaoConferemException();
    }
}
