package br.com.quebraGalho.quebraGalho.controller;

import br.com.quebraGalho.quebraGalho.entity.Administrador;
import br.com.quebraGalho.quebraGalho.entity.Cliente;
import br.com.quebraGalho.quebraGalho.entity.LoginRequest;
import br.com.quebraGalho.quebraGalho.entity.Vendedor;
import br.com.quebraGalho.quebraGalho.service.AdministradorService;
import br.com.quebraGalho.quebraGalho.service.ClienteService;
import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/add")
    public ResponseEntity<String> save(@RequestBody Cliente cliente){
        return new ResponseEntity<String>(this.clienteService.add(cliente), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Cliente cliente){
        try {
            String mensagem = this.clienteService.update(id, cliente);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Deu algo errado ao Salvar "+e, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Cliente c = this.clienteService.findById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            String mensagem = this.clienteService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/findAll")
    public ResponseEntity<List<Cliente>> findAll(){
        try {
            List<Cliente> lista = this.clienteService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Cliente> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(this.clienteService.login(loginRequest), HttpStatus.OK);
    }
}
