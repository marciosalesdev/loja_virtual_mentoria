//package mtech.dev.marciosales.loja_virtual_mentoria.security;
//
//import mtech.dev.marciosales.loja_virtual_mentoria.repository.AcessoRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private final UsuarioRepository usuarioRepository;
//
//    public UserDetailsServiceImpl(AcessoRepository acessoRepository) {
//        this.usuarioRepository = usuarioRepository;
//    }
//
//    //implementa o metodo de carregar usuario pelo email
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        //vai no banco de dados buscar usuario pelo email
//         Usuario usuario = usuarioRepository.findByEmail(email)
//                 .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado": + email )
//
//        return org.springframework.security.core.userdetails.User
//                .withUsername(usuario.getEmail())//define o nome do usuario como email
//                .password(usuario.getSenha())//define a senha do usuario
//                .build();//constroi o objeto details
//        }
//}
