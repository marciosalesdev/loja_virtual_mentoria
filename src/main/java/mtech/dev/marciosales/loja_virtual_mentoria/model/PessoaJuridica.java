package mtech.dev.marciosales.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "pessoa_juridica")
@SequenceGenerator(name = "seq_pessoa_juridica", sequenceName = "seq_pessoa_juridica", allocationSize = 1,initialValue = 1)
public class PessoaJuridica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa_juridica")
    private Long id;


    private String cnpj;
    private String incricaoEstadual;
    private String incricaoMunicipial;
    private String nomeFantasia;
    private String razaoSocial;



}
