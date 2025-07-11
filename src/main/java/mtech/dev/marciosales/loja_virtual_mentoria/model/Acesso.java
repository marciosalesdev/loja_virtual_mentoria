package mtech.dev.marciosales.loja_virtual_mentoria.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "acesso")
@SequenceGenerator(name = "seq_acesso",sequenceName = "seq_acesso",  allocationSize = 1, initialValue = 1)
public class Acesso implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ("seq_acesso"))
    private Long id;

    @Column(nullable = false)
    private String descricao;  //Acesso ex; ROLE_ADMIN ou ROLE_SECRETARIO


    public Acesso() {
    }

    public Acesso(String descricao, Long id) {
        this.descricao = descricao;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    @JsonIgnore
    @Override
    public String getAuthority() {
        return this.descricao;
    }
}
