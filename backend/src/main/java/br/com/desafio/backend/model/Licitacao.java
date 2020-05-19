package br.com.desafio.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "licitacao")
public class Licitacao {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "classificacao", nullable = false)
    private ClassificacaoEnum classificacaoEnum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
