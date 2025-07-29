package br.com.quebraGalho.quebraGalho.service;

import br.com.quebraGalho.quebraGalho.entity.Administrador;
import br.com.quebraGalho.quebraGalho.entity.Avaliacao;
import br.com.quebraGalho.quebraGalho.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
