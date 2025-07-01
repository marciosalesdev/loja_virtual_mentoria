package mtech.dev.marciosales.loja_virtual_mentoria.model;


import jakarta.persistence.*;
import mtech.dev.marciosales.loja_virtual_mentoria.enums.TipoEndereco;

import java.io.Serializable;

@Entity
@Table(name = "endereco")
@SequenceGenerator(name = "seq_endereco",sequenceName = "seq_endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
    private Long id;

    private String ruaLogradouro;
    private String cep;
    private String numero;
    private String complemento;
    private String bairro;
    private String uf;
    private String cidade;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_id"))
    private Pessoa pessoa;

    @Enumerated(EnumType.STRING)
    private TipoEndereco  tipoEndereco;

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Endereco() {
    }

    public Endereco(Long id, String ruaLogradouro, String cep, String numero, String complemento, String bairro, String uf, String cidade, Pessoa pessoa) {
        this.id = id;
        this.ruaLogradouro = ruaLogradouro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.uf = uf;
        this.cidade = cidade;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuaLogradouro() {
        return ruaLogradouro;
    }

    public void setRuaLogradouro(String ruaLogradouro) {
        this.ruaLogradouro = ruaLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
