package mtech.dev.marciosales.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pessoa_fisica")
@SequenceGenerator(name = "seq_pessoa_fisica",sequenceName = "seq_pessoa_fisica", allocationSize = 1, initialValue = 1)
public class PessoaFisica implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa_fisica")
    private Long id;

    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;


}
