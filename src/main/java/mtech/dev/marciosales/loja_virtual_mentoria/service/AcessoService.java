package mtech.dev.marciosales.loja_virtual_mentoria.service;

import mtech.dev.marciosales.loja_virtual_mentoria.model.Acesso;
import mtech.dev.marciosales.loja_virtual_mentoria.repository.AcessoRepository;
import org.springframework.stereotype.Service;

@Service
public class AcessoService {

    private final AcessoRepository acessoRepository;

    public AcessoService(AcessoRepository acessoRepository) {
        this.acessoRepository = acessoRepository;
    }

    public Acesso salvarCadastro(Acesso acesso) {
        return acessoRepository.save(acesso);
    }

    public void deleteAcessoPorId(Long id) {
        acessoRepository.deleteById(id);
    }

    public void buscarAcessoPorId(Long id) {
        acessoRepository.findById(id);
    }
}
