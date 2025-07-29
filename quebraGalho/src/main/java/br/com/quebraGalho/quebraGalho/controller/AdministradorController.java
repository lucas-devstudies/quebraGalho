package br.com.quebraGalho.quebraGalho.controller;

import br.com.quebraGalho.quebraGalho.entity.Administrador;
import br.com.quebraGalho.quebraGalho.entity.LoginRequest;
import br.com.quebraGalho.quebraGalho.entity.Vendedor;
import br.com.quebraGalho.quebraGalho.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrador")
public class AdministradorController {
    @Autowired
    private AdministradorService administradorService;

    @PostMapping("/add")
    public ResponseEntity<String> save(@RequestBody Administrador administrador){
        try {
            String mensagem = this.administradorService.add(administrador);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Deu algo errado ao Salvar "+e, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Administrador administrador){
        try {
            String mensagem = this.administradorService.update(id,administrador);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Deu algo errado ao Salvar "+e, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Administrador> findById(@PathVariable Long id){
        try {
            Administrador a = this.administradorService.findById(id);
            return new ResponseEntity<>(a, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            String mensagem = this.administradorService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/findAll")
    public ResponseEntity<List<Administrador>> findAll(){
        try {
            List<Administrador> lista = this.administradorService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Administrador> login(@RequestBody LoginRequest loginRequest){
        try {
            Administrador a = this.administradorService.login(
                    loginRequest.getEmail(),
                    loginRequest.getSenha());
            return new ResponseEntity<>(a, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
