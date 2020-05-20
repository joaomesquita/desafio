package br.com.desafio.backend.controller;

import br.com.desafio.backend.dto.InserirPropostaInput;
import br.com.desafio.backend.dto.PropostaDTO;
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
@RequestMapping(value = "/proposta")
public class PropostaController {

    @Autowired
    PropostaRepository propostaRepository;

    @Autowired
    LicitacaoRepository licitacaoRepository;

    @GetMapping
    public List<PropostaDTO> buscarPropostas() {
        List<Proposta> propostas = propostaRepository.findAll();
        List<PropostaDTO> propostaDTOS = new ArrayList<>();

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

        return propostaDTOS;
    }

    @GetMapping(path = "/{propostaId}")
    public Proposta buscarPropostaPorId(@PathVariable(value = "propostaId") long propostaId) {
        return propostaRepository.findById(propostaId);
    }

    @PostMapping
    public Proposta inserirProposta(@Valid @NotNull @RequestBody InserirPropostaInput inserirPropostaInput) {
        Proposta proposta = new Proposta();

        proposta.setFornecedor(inserirPropostaInput.getFornecedor());
        proposta.setNota(inserirPropostaInput.getNota());
        proposta.setPreco(inserirPropostaInput.getPreco());
        proposta.setDataCadastro(inserirPropostaInput.getDataCadastro());
        proposta.setClassificacao(null);
        proposta.setLicitacao(licitacaoRepository.findById(inserirPropostaInput.getLicitacaoId()).orElse(null));

        return propostaRepository.save(proposta);
    }

//TODO
//    private Integer buscarClassificacao(Long licitacaoId) {
//    }

    @DeleteMapping(path = "/{propostaId}")
    public void removerProposta(@PathVariable(value = "propostaId") long propostaId) {
        propostaRepository.deleteById(propostaId);
    }
}
