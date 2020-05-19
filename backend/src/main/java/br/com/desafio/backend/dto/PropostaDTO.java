package br.com.desafio.backend.dto;

import java.math.BigDecimal;

public class PropostaDTO {

    private Long propostaId;
    private String fornecedor;
    private BigDecimal nota;
    private BigDecimal preco;
    private String dataCadastro;
    private Integer classificacao;

    public PropostaDTO() {
    }

    public Long getPropostaId() {
        return propostaId;
    }

    public void setPropostaId(Long propostaId) {
        this.propostaId = propostaId;
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

    public Integer getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }
}
