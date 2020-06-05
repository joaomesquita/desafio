import { api } from './api';

export default {
  buscar:() => {
    return api.get('/proposta')
  },

  buscarPorId:(propostaId) => {
    return api.get(`/proposta/${propostaId}`)
  },

  inserir:(proposta) => {
    return api.post('/proposta', proposta)
  },

  atualizar:(propostaId, proposta) => {
    return api.put(`/proposta/${propostaId}`, proposta)
  },

  remover:(propostaId) => {
    return api.delete(`/proposta/${propostaId}`)
  }
}