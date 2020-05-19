package br.com.desafio.backend.dto;

import br.com.desafio.backend.model.ClassificacaoEnum;

public class InserirLicitacaoInput {

    private String descricao;
    private ClassificacaoEnum classificacaoEnum;

    public InserirLicitacaoInput() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ClassificacaoEnum getClassificacaoEnum() {
        return classificacaoEnum;
    }

    public void setClassificacaoEnum(ClassificacaoEnum classificacaoEnum) {
        this.classificacaoEnum = classificacaoEnum;
    }
}
