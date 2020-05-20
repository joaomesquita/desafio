import { api } from './api';

export default {
  buscarPropostas:() => {
    return api.get('/proposta')
  },
  inserirPropostas:(proposta) => {
    return api.post('/proposta', proposta)
  }
}