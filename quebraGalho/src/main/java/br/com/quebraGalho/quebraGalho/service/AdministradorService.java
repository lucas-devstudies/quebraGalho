package br.com.quebraGalho.quebraGalho.service;

import br.com.quebraGalho.quebraGalho.entity.Administrador;
import br.com.quebraGalho.quebraGalho.exception.AdministradorNuloException;
import br.com.quebraGalho.quebraGalho.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    public String add(Administrador administrador){
        this.administradorRepository.save(administrador);
        return "Administrador adicionado com sucesso";
    }
    public String update(Long id, Administrador administrador){
        administrador.setId(id);
        this.administradorRepository.save(administrador);
        return "Administrador atualizado com sucesso";
    }
    public Administrador findById(Long id){
        Administrador a =  this.administradorRepository.findById(id).get();
        return a;
    }
    public String delete(Long id){
        this.administradorRepository.deleteById(id);
        return "Administrador removido com sucesso";
    }
    public List<Administrador> findAll(){
        List<Administrador> lista = this.administradorRepository.findAll();
        return lista;
    }
    public Administrador login(String email, String senha){
        Optional<Administrador> a = this.administradorRepository.findByEmail(email);
        if (a.isEmpty()){
            throw new AdministradorNuloException("Administrador não encontrado");
        }
        Administrador adm = a.get();
        if(adm.getSenha().equals(senha)){
            return adm;
        }
        throw new AdministradorNuloException("Dados não conferem");
    }
}
