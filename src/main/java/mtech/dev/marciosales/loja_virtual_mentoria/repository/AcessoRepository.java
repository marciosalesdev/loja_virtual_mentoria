package mtech.dev.marciosales.loja_virtual_mentoria.repository;

import mtech.dev.marciosales.loja_virtual_mentoria.model.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AcessoRepository extends JpaRepository<Acesso, Long> {

    @Query("select a from Acesso a where upper(trim(a.descricao)) like %?1%")
    List<Acesso> buscarAcessoDesc(String desc);

    List<Acesso> id(Long id);
}
