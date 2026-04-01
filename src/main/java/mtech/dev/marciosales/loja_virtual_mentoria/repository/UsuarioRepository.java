package mtech.dev.marciosales.loja_virtual_mentoria.repository;

import jakarta.transaction.Transactional;
import mtech.dev.marciosales.loja_virtual_mentoria.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

  @Query(value = "select u from Usuario u where u.login = ?1")
  Usuario findByLogin(String login);
}
