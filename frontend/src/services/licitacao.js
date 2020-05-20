import { api } from './api';

export default {
  buscarLicitacoes:() => {
      return api.get('/licitacao')
  },
  inserirLicitacao:(licitacao) => {
    return api.post('/licitacao', licitacao)
  }
}