package br.com.desafio.backend.controller;

import br.com.desafio.backend.dto.InserirLicitacaoInput;
import br.com.desafio.backend.dto.LicitacaoDTO;
import br.com.desafio.backend.dto.PropostaDTO;
import br.com.desafio.backend.model.ClassificacaoEnum;
import br.com.desafio.backend.model.Licitacao;
import br.com.desafio.backend.model.Proposta;
import br.com.desafio.backend.repository.LicitacaoRepository;
import br.com.desafio.backend.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/licitacao")
public class LicitacaoController {

    @Autowired
    LicitacaoRepository licitacaoRepository;

    @Autowired
    PropostaRepository propostaRepository;

    @GetMapping
    public List<LicitacaoDTO> buscarLicitacoes() {
        List<Licitacao> licitacoes = licitacaoRepository.findAll();
        List<LicitacaoDTO> licitacaoDTOS = new ArrayList<>();

        licitacoes.forEach((licitacao -> {
            LicitacaoDTO licitacaoDTO = new LicitacaoDTO();
            licitacaoDTO.setLicitacaoId(licitacao.getId());
            licitacaoDTO.setDescricao(licitacao.getDescricao());
            licitacaoDTO.setClassificacaoEnum(licitacao.getClassificacaoEnum());
            licitacaoDTO.setPropostaDTO(buscarPropostasPorLicitacao(licitacao.getId()));

            licitacaoDTOS.add(licitacaoDTO);
        }));

        return licitacaoDTOS;
    }

    private List<PropostaDTO> buscarPropostasPorLicitacao(long licitacaoId) {
        Licitacao licitacao = licitacaoRepository.findById(licitacaoId);
        ClassificacaoEnum classificacaoEnum = null;
        List<PropostaDTO> propostaDTOS = new ArrayList<>();
        
        if (licitacao.getClassificacaoEnum() == classificacaoEnum.MENOR_PRECO) {
            List<Proposta> propostas = propostaRepository.findAllByLicitacaoIdOrderByPrecoAscDataCadastroDesc(licitacaoId);

            propostas.forEach((proposta -> {
                PropostaDTO propostaDTO = new PropostaDTO();
                propostaDTO.setPropostaId(proposta.getId());
                propostaDTO.setFornecedor(proposta.getFornecedor());
                propostaDTO.setNota(proposta.getNota());
                propostaDTO.setPreco(proposta.getPreco());
                propostaDTO.setDataCadastro(proposta.getDataCadastro());
                propostaDTO.setClassificacao(proposta.getClassificacao());

                propostaDTOS.add(propostaDTO);
            }));
        } else {
            List<Proposta> propostas = propostaRepository.findAllByLicitacaoIdOrderByNotaDescPrecoDescDataCadastroDesc(licitacaoId);

            propostas.forEach((proposta -> {
                PropostaDTO propostaDTO = new PropostaDTO();
                propostaDTO.setPropostaId(proposta.getId());
                propostaDTO.setFornecedor(proposta.getFornecedor());
                propostaDTO.setNota(proposta.getNota());
                propostaDTO.setPreco(proposta.getPreco());
                propostaDTO.setDataCadastro(proposta.getDataCadastro());
                propostaDTO.setClassificacao(proposta.getClassificacao());

                propostaDTOS.add(propostaDTO);
            }));
        }

        return propostaDTOS;
    }

    @GetMapping(path = "/{licitacaoId}")
    public LicitacaoDTO buscarLicitacaoPorId(@PathVariable(value = "licitacaoId") long licitacaoId) {
        Licitacao licitacao = licitacaoRepository.findById(licitacaoId);
        LicitacaoDTO licitacaoDTO = new LicitacaoDTO();

        licitacaoDTO.setLicitacaoId(licitacao.getId());
        licitacaoDTO.setDescricao(licitacao.getDescricao());
        licitacaoDTO.setClassificacaoEnum(licitacao.getClassificacaoEnum());
        licitacaoDTO.setPropostaDTO(buscarPropostasPorLicitacao(licitacao.getId()));

        return licitacaoDTO;
    }

    @PostMapping
    public Licitacao inserirLicitacao(@Valid @NotNull @RequestBody InserirLicitacaoInput inserirLicitacaoInput) {
        Licitacao licitacao = new Licitacao();

        licitacao.setDescricao(inserirLicitacaoInput.getDescricao());
        licitacao.setClassificacaoEnum(inserirLicitacaoInput.getClassificacaoEnum());

        return licitacaoRepository.save(licitacao);
    }

    @DeleteMapping(path = "/{licitacaoId}")
    public void removerLicitacao(@PathVariable(value = "licitacaoId") long licitacaoId) {
        licitacaoRepository.deleteById(licitacaoId);
    }

    @PutMapping(path = "/{licitacaoId}")
    public Licitacao atualizarLicitacao(@Valid @NotNull @PathVariable(value = "licitacaoId") long licitacaoId, @RequestBody LicitacaoDTO licitacaoDTO) {
        Licitacao licitacao = licitacaoRepository.findById(licitacaoId);

        licitacao.setDescricao(licitacaoDTO.getDescricao());
        licitacao.setClassificacaoEnum(licitacaoDTO.getClassificacaoEnum());

        return licitacaoRepository.save(licitacao);
    }
}
