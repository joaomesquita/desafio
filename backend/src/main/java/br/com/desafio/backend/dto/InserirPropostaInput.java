package br.com.desafio.backend.dto;

import java.math.BigDecimal;

public class InserirPropostaInput {

    private String fornecedor;
    private BigDecimal nota;
    private BigDecimal preco;
    private String dataCadastro;
    private Long licitacaoId;

    public InserirPropostaInput() {
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Long getLicitacaoId() {
        return licitacaoId;
    }

    public void setLicitacaoId(Long licitacaoId) {
        this.licitacaoId = licitacaoId;
    }
}
