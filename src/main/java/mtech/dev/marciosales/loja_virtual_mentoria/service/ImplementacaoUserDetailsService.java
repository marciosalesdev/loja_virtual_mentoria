package mtech.dev.marciosales.loja_virtual_mentoria.service;

import mtech.dev.marciosales.loja_virtual_mentoria.model.Usuario;
import mtech.dev.marciosales.loja_virtual_mentoria.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ImplementacaoUserDetailsService implements UserDetailsService {

  private final UsuarioRepository usuarioRepository;

  public ImplementacaoUserDetailsService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario usuario = usuarioRepository.findByLogin(username);
    if (usuario == null) {
      throw new UsernameNotFoundException("Usuario não foi Encontrado" + username);
    }
    return new User(usuario.getLogin(), usuario.getPassword(), usuario.getAuthorities());
  }
}
