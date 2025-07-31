package br.com.quebraGalho.quebraGalho.service;

import br.com.quebraGalho.quebraGalho.entity.Cliente;
import br.com.quebraGalho.quebraGalho.entity.LoginRequest;
import br.com.quebraGalho.quebraGalho.exception.*;
import br.com.quebraGalho.quebraGalho.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public String add(Cliente cl){
        Optional<Cliente> c = Optional.ofNullable(cl);
        if(c.isEmpty()){
            throw new ClienteIncompletoException();
        }
        Cliente cliente = c.get();
        if (cliente.getNome() !=null && cliente.getCpf() != null && cliente.getSenha()!=null && cliente.getEmail()!=null)
        {
            clienteRepository.save(cliente);
            return "Cliente adicionado com sucesso";
        }
        throw new ClienteIncompletoException();
    }
    public String update(Long id, Cliente cliente){
        cliente.setId(id);
        clienteRepository.save(cliente);
        return "Cliente atualizado com sucesso";
    }
    public Cliente findById(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(ClienteNuloException::new);
    }
    public String delete(Long id){
        clienteRepository.deleteById(id);
        return "Cliente removido com sucesso";
    }
    public List<Cliente> findAll(){
        List<Cliente> lista = clienteRepository.findAll();
        return lista;
    }
    public Cliente login(LoginRequest loginRequest){
        Optional<Cliente> c = clienteRepository.findByEmail(loginRequest.getEmail());
        if (c.isEmpty()){
            throw new ClienteNuloException();
        }
        Cliente cliente = c.get();
        if(cliente.getSenha().equals(loginRequest.getSenha())){
            return cliente;
        }
        throw new DadosNaoConferemException();
    }
}
