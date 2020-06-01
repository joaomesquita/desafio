package br.com.desafio.backend.repository;

import br.com.desafio.backend.model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    Proposta findById(long id);

    List<Proposta> findAllByLicitacaoId(Long licitacaoId);

    List<Proposta> findAllByLicitacaoIdOrderByPrecoAscDataCadastroDesc(Long licitacaoId);

    List<Proposta> findAllByLicitacaoIdOrderByNotaDescPrecoDescDataCadastroDesc(Long licitacaoId);
}