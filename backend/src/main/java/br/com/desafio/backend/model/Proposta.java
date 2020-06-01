package br.com.desafio.backend.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "proposta")
public class Proposta {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fornecedor", nullable = false)
    private String fornecedor;

    @Column(name = "nota")
    private BigDecimal nota;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @Column(name = "data_cadastro", nullable = false)
    private String dataCadastro;

    @Column(name = "classificacao")
    private Integer classificacao;

    @ManyToOne
    @JoinColumn(name = "LI_ID")
    private Licitacao licitacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Licitacao getLicitacao() {
        return licitacao;
    }

    public void setLicitacao(Licitacao licitacao) {
        this.licitacao = licitacao;
    }
}
