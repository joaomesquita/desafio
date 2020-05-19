package br.com.desafio.backend.repository;

import br.com.desafio.backend.model.Licitacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicitacaoRepository extends JpaRepository<Licitacao, Long> {
    Licitacao findById(long id);
}
