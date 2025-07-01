package mtech.dev.marciosales.loja_virtual_mentoria.enums;

public enum StatusContaPagar {

    COBRANCA("Cobrança"),
    VENCIDA("Vencida"),
    ABERTA("Aberta"),
    QUITADA("Quitada"),
    RENEGOCIADA("Renegociada");


    StatusContaPagar(String descricao) {
        descricao = descricao;
    }

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }
}
