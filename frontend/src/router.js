import Vue from 'vue'
import Router from 'vue-router'

import Licitacoes from './components/licitacao/Licitacoes';
import Propostas from './components/proposta/Propostas';
import NovoLicitacao from './components/licitacao/NovoLicitacao';
import NovoProposta from './components/proposta/NovoProposta';

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/licitacoes',
      component: Licitacoes
    },
    {
      path: '/licitacoes/novo',
      component: NovoLicitacao
    },
    {
      path: '/propostas',
      component: Propostas
    },
    {
      path: '/propostas/novo',
      component: NovoProposta
    },
  ]
})