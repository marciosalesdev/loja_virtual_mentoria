package mtech.dev.marciosales.loja_virtual_mentoria.enums;

public enum TipoEndereco {

    COBRANCA("Cobrança"),
    ENTREGA("Entrega");

    private String descricao;

    TipoEndereco(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "TipoEndereco{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
