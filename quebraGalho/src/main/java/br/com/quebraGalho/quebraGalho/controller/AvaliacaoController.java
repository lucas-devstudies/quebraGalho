package br.com.quebraGalho.quebraGalho.controller;

import br.com.quebraGalho.quebraGalho.entity.Avaliacao;
import br.com.quebraGalho.quebraGalho.entity.AvaliacaoCriacaoDTO;
import br.com.quebraGalho.quebraGalho.exception.VendedorNuloException;
import br.com.quebraGalho.quebraGalho.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping("/add")
    public ResponseEntity<String> save(@RequestBody AvaliacaoCriacaoDTO avaliacaoCriacaoDTO){
        try{
            String mensagem = this.avaliacaoService.add(avaliacaoCriacaoDTO);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Deu algo errado ao Salvar"+e,HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody AvaliacaoCriacaoDTO avaliacaoCriacaoDTO){
        try{
            String mensagem = this.avaliacaoService.update(id,avaliacaoCriacaoDTO);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Deu algo errado ao Salvar"+e,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Avaliacao> findById(@PathVariable long id){
        try{
            Avaliacao avaliacao = this.avaliacaoService.findById(id);
            return new ResponseEntity<>(avaliacao, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try {
            String mensagem = this.avaliacaoService.delete(id);
            return new ResponseEntity<>(mensagem,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<Avaliacao>> findAll(){
        try {
            List<Avaliacao> lista = this.avaliacaoService.findAll();
            return new ResponseEntity<>(lista,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findMediaNotas/{id}")
    public ResponseEntity<Double> findMediaNotas(@PathVariable Long id){
        try {
            Double media = this.avaliacaoService.findMediaNotas(id);
            return new ResponseEntity<>(media,HttpStatus.OK);
        }catch (VendedorNuloException e) {
            return new ResponseEntity<>(-1.0, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
