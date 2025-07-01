package mtech.dev.marciosales.loja_virtual_mentoria.model;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "marca_produto")
@SequenceGenerator(name = "seq_marca_produto",sequenceName = "seq_marca_produto",allocationSize = 1, initialValue= 1)
public class MarcaProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_marca_produto"  )
    private Long id;
    @Column(nullable = false)
    private String nomeDesc;

    public MarcaProduto() {
    }

    public MarcaProduto(Long id, String nomeDesc) {
        this.id = id;
        this.nomeDesc = nomeDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDesc() {
        return nomeDesc;
    }

    public void setNomeDesc(String nomeDesc) {
        this.nomeDesc = nomeDesc;
    }
}
