import { api } from './api'

export default {
  buscar:() => {
    return api.get('/licitacao')
  },

  buscarPorId:(licitacaoId) => {
    return api.get(`/licitacao/${licitacaoId}`)
  },

  inserir:(licitacao) => {
    return api.post('/licitacao', licitacao)
  },

  atualizar:(licitacaoId, licitacao) => {
    return api.put(`/licitacao/${licitacaoId}`, licitacao)
  },

  remover:(licitacaoId) => {
    return api.delete(`/licitacao/${licitacaoId}`)
  }
}

