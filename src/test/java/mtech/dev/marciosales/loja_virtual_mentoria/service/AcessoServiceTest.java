package mtech.dev.marciosales.loja_virtual_mentoria.service;

import mtech.dev.marciosales.loja_virtual_mentoria.LojaVirtualMentoriaApplication;
import mtech.dev.marciosales.loja_virtual_mentoria.model.Acesso;
import mtech.dev.marciosales.loja_virtual_mentoria.repository.AcessoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
class AcessoServiceTest {
    @Autowired
    private AcessoService acessoService;
    @Autowired
    private AcessoRepository acessoRepository;

    @Test
    void salvarCadastro() {
        Acesso acesso = new Acesso();
        acesso.setDescricao("descricaoagora vai");

        acessoRepository.save(acesso);
    }
}