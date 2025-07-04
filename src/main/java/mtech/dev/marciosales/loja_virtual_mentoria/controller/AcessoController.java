package mtech.dev.marciosales.loja_virtual_mentoria.controller;

import mtech.dev.marciosales.loja_virtual_mentoria.model.Acesso;
import mtech.dev.marciosales.loja_virtual_mentoria.repository.AcessoRepository;
import mtech.dev.marciosales.loja_virtual_mentoria.service.AcessoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequestMapping
@RestController
public class AcessoController {

    private final AcessoRepository acessoRepository;
    private final AcessoService acessoService;

    public AcessoController(AcessoRepository acessoRepository, AcessoService acessoService) {
        this.acessoRepository = acessoRepository;
        this.acessoService = acessoService;
    }


    @ResponseBody
    @PostMapping(value = "/salvarAccesso")
    public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso){
        Acesso acessoSalvo = acessoService.salvarCadastro(acesso);
        return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.CREATED);
    }

    @ResponseBody
    @PostMapping(value = "/deleteAcesso")
    public ResponseEntity<?> deleteAcesso(@RequestBody Acesso acesso){
       acessoRepository.deleteById(acesso.getId());
        return new ResponseEntity<>("Acesso removido", HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping("/deletePorId/{id}")
    public ResponseEntity<?> deleteAcessoPorId(@PathVariable("id") Long id){
        acessoService.deleteAcessoPorId(id);
        return new ResponseEntity<>("Acesso removido", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/acessoPorId/{id}")
    public ResponseEntity<Optional<Acesso>> acessoPorId(@PathVariable("desc") Long id) {
        Optional<Acesso> acesso = acessoRepository.findById(id);
        return new ResponseEntity<Optional<Acesso>>(acesso, HttpStatus.OK);
    }


    @ResponseBody
    @GetMapping("/obterListaPorDesc/{desc}")
    public ResponseEntity<List<Acesso>> acessoPorId(@PathVariable("desc") String desc   ) {
       List<Acesso> acesso = acessoRepository.buscarAcessoDesc(desc);
        return new ResponseEntity(acesso, HttpStatus.OK);
    }

}

