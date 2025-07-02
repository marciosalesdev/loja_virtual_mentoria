package mtech.dev.marciosales.loja_virtual_mentoria.controller;

import mtech.dev.marciosales.loja_virtual_mentoria.model.Acesso;
import mtech.dev.marciosales.loja_virtual_mentoria.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AcessoController {
    @Autowired
    private AcessoService acessoService;


    public Acesso salvarCadastro(Acesso acesso){
        return acessoService.salvarCadastro(acesso);
    }


}
