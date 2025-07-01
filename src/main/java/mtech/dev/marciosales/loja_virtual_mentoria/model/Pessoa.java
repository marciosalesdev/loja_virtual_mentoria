package mtech.dev.marciosales.loja_virtual_mentoria.model;

import jakarta.persistence.*;


@Entity
@Table(name = "pessoa")
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1, initialValue = 1)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    private Long id;







  @ManyToMany(targetEntity = Endereco.class, cascade = CascadeType.ALL)
  private Endereco endereco;
}
