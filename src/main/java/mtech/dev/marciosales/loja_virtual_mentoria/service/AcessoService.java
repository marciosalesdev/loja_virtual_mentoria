package mtech.dev.marciosales.loja_virtual_mentoria.service;

import mtech.dev.marciosales.loja_virtual_mentoria.model.Acesso;
import mtech.dev.marciosales.loja_virtual_mentoria.repository.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcessoService {

    @Autowired
    private AcessoRepository  acessoRepository;


    public Acesso salvarCadastro(Acesso acesso) {
        return acessoRepository.save(acesso);
    }
}
