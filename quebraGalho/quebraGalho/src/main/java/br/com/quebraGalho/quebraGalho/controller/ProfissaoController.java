package br.com.quebraGalho.quebraGalho.controller;

import br.com.quebraGalho.quebraGalho.entity.Profissao;
import br.com.quebraGalho.quebraGalho.service.ProfissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profissao")
public class ProfissaoController {

    @Autowired
    private ProfissaoService profissaoService;

    @PostMapping("/add")
    public ResponseEntity<String> save(@RequestBody Profissao profissao) {
        return new ResponseEntity<String>(this.profissaoService.add(profissao), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Profissao profissao) {
        return new ResponseEntity<String>(this.profissaoService.update(id, profissao), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Profissao> findById(@PathVariable Long id) {
        try {
            Profissao p = this.profissaoService.findById(id);
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            String mensagem = this.profissaoService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Profissao>> findAll() {
        try {
            List<Profissao> lista = this.profissaoService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}