import Vue from 'vue'
import Router from 'vue-router'

import Licitacoes from './pages/licitacao/Licitacoes'
import AdicionarLicitacao from './pages/licitacao/AdicionarLicitacao'
import Licitacao from './pages/licitacao/Licitacao'
import AtualizarLicitacao from './pages/licitacao/AtualizarLicitacao'

import AdicionarProposta from './pages/proposta/AdicionarProposta'
import AtualizarProposta from './pages/proposta/AtualizarProposta'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/licitacoes',
      name: 'licitacoes',
      component: Licitacoes
    },
    {
      path: '/licitacoes/nova',
      name: 'licitacoes-adicionar',
      component: AdicionarLicitacao
    },
    {
      path: '/licitacoes/licitacao/:licitacaoId',
      name: 'licitacao-detalhes',
      component: Licitacao
    },
    {
      path: '/licitacoes/licitacao/editar/:licitacaoId',
      name: 'licitacao-atualizar',
      component: AtualizarLicitacao
    },
    {
      path: '/licitacoes/licitacao/:licitacaoId/proposta/nova',
      name: 'propostas-adicionar',
      component: AdicionarProposta
    },
    {
      path: '/licitacoes/licitacao/:licitacaoId/proposta/editar/:propostaId',
      name: 'proposta-atualizar',
      component: AtualizarProposta
    }
  ]
})