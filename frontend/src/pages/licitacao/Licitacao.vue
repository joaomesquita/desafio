<template>
  <v-flex class="pa-5" xs12>
    <v-flex class="pb-5">
      <v-btn text @click="$router.push('/licitacoes')">
        <v-icon left>mdi-arrow-left</v-icon> Voltar
      </v-btn>
    </v-flex>
    <v-card>
      <v-card-title class="justify-space-between">
        Licitação #{{ licitacao.licitacaoId }}
        <div>
          <v-btn icon @click="$router.push(`/licitacoes/licitacao/editar/${licitacao.licitacaoId}`)">
            <v-icon>mdi-pencil-outline</v-icon>
          </v-btn>
          <v-btn icon @click="removerLicitacao(licitacao.licitacaoId)">
            <v-icon>mdi-delete-outline</v-icon>
          </v-btn>
        </div>
      </v-card-title>
      <v-card-subtitle v-if="licitacao.classificacaoEnum == 'MENOR_PRECO'">Menor Preço</v-card-subtitle>
      <v-card-subtitle v-else>Nota Preço</v-card-subtitle>
      <v-card-text>{{ licitacao.descricao }}</v-card-text>
    </v-card>
    <div class="pt-5">
      <v-card>
        <v-card-title class="justify-space-between">
          Propostas
          <v-btn icon @click="$router.push(`/licitacoes/licitacao/${licitacao.licitacaoId}/proposta/nova`)">
            <v-icon>mdi-plus</v-icon>
          </v-btn>
        </v-card-title>
        <v-simple-table fixed-header>
          <thead>
          <th class="text-left">Classificação</th>
          <th class="text-left">Fornecedor</th>
          <th class="text-left" v-if="licitacao.classificacaoEnum == 'NOTA_PRECO'">Nota</th>
          <th class="text-left">Preço</th>
          <th class="text-left">Data</th>
          <th class="text-left">Ações</th>
          </thead>
          <tbody>
          <tr v-for="proposta in licitacao.propostaDTO" :key="proposta.id" :proposta="proposta">
            <td>{{ proposta.classificacao }}</td>
            <td>{{ proposta.fornecedor }}</td>
            <td v-if="proposta.nota != null">{{ proposta.nota }}</td>
            <td>{{ proposta.preco.toLocaleString("pt-BR", { style: 'currency', currency: 'BRL' }) }}</td>
            <td>{{ proposta.dataCadastro }}</td>
            <td>
              <v-btn icon @click="$router.push(`/licitacoes/licitacao/${licitacao.licitacaoId}/proposta/editar/${proposta.propostaId}`)">
                <v-icon>mdi-pencil-outline</v-icon>
              </v-btn>
              <v-btn icon @click="removerProposta(proposta.propostaId)">
                <v-icon>mdi-delete-outline</v-icon>
              </v-btn>
            </td>
          </tr>
          </tbody>
        </v-simple-table>
      </v-card>
    </div>
  </v-flex>
</template>

<script>
  import LicitacaoService from '../../services/licitacao'
  import PropostaService from '../../services/proposta'

  export default {
    name: "Licitacao",
    data:() => ({
      licitacao: {},
      show: false
    }),
    mounted() {
      this.buscarLicitacao(this.$route.params.licitacaoId)
    },
    methods: {
      buscarLicitacao(licitacaoId) {
        try {
          LicitacaoService.buscarPorId(licitacaoId)
            .then(response => {
              this.licitacao = response.data
              console.log(response.status)
            })
        } catch(e) {
          console.log(e.response.data)
        }
      },
      removerLicitacao(licitacaoId) {
        try {
          LicitacaoService.remover(licitacaoId)
            .then(response => {
              alert('Exclusão realizada com sucesso.')
              console.log(response.status)
              this.$router.push('/licitacoes')
            })
        } catch(e) {
          console.log(e.response.data)
        }
      },
      removerProposta(propostaId) {
        try {
          PropostaService.remover(propostaId)
            .then(response => {
              alert('Exclusão realizada com sucesso.')
              console.log(response.status)
              this.buscarLicitacao(this.$route.params.licitacaoId)
            })
        } catch(e) {
          console.log(e.response.data)
        }
      }
    }
  }
</script>

<style>

</style>