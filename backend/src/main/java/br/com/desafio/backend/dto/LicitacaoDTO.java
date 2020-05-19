package br.com.desafio.backend.dto;

import br.com.desafio.backend.model.ClassificacaoEnum;

import java.util.List;

public class LicitacaoDTO {

    private Long licitacaoId;
    private String descricao;
    private ClassificacaoEnum classificacaoEnum;
    private List<PropostaDTO> propostaDTO;

    public LicitacaoDTO() {
    }

    public Long getLicitacaoId() {
        return licitacaoId;
    }

    public void setLicitacaoId(Long licitacaoId) {
        this.licitacaoId = licitacaoId;
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

    public List<PropostaDTO> getPropostaDTO() {
        return propostaDTO;
    }

    public void setPropostaDTO(List<PropostaDTO> propostaDTO) {
        this.propostaDTO = propostaDTO;
    }
}
