package br.com.quebraGalho.quebraGalho.controller;

import br.com.quebraGalho.quebraGalho.entity.Administrador;
import br.com.quebraGalho.quebraGalho.entity.LoginRequest;
import br.com.quebraGalho.quebraGalho.entity.Vendedor;
import br.com.quebraGalho.quebraGalho.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PostMapping("/add")
    public ResponseEntity<String> save(@RequestBody Vendedor vendedor){
        return new ResponseEntity<String>(this.vendedorService.add(vendedor), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Vendedor vendedor){
        try {
            String mensagem = this.vendedorService.update(id,vendedor);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Deu algo errado ao Salvar "+e, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Vendedor> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.vendedorService.findById(id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            String mensagem = this.vendedorService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<Vendedor>> findAll(){
        try {
            List<Vendedor> lista = this.vendedorService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Vendedor> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(this.vendedorService.login(loginRequest), HttpStatus.OK);
    }
}
