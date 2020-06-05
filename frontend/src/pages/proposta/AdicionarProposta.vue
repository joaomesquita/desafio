<template>
  <v-flex class="pa-5" xs12>
    <v-card class="pa-10">
      <v-card-title>
        Adicionar Proposta na Licitação #{{ licitacao.licitacaoId }}
      </v-card-title>
      <v-card-text>
        <div class="text-justify">
          <p v-if="licitacao.classificacaoEnum == 'MENOR_PRECO'">Menor Preço</p>
          <p v-else>Nota Preço</p>
          <p>{{ licitacao.descricao }}</p>
        </div>
        <v-row>
          <v-col cols="12">
            <v-text-field label="Fornecedor" v-model="proposta.fornecedor" required />
          </v-col>
          <v-col cols="12" v-if="licitacao.classificacaoEnum == 'NOTA_PRECO'">
            <v-text-field label="Nota" v-model="proposta.nota" required />
          </v-col>
          <v-col cols="12">
            <v-text-field label="Preço" v-model="proposta.preco" required />
          </v-col>
        </v-row>
      </v-card-text>
      <v-card-actions>
        <v-btn text @click="$router.push(`/licitacoes/licitacao/${licitacao.licitacaoId}`)">
          <v-icon left>mdi-arrow-left</v-icon> Voltar
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn class="primary" @click.prevent="inserirProposta">
          <v-icon left>mdi-content-save-outline</v-icon> Salvar
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-flex>
</template>

<script>
  import PropostaService from '../../services/proposta'
  import LicitacaoService from '../../services/licitacao'

  export default {
    name: "AdicionarProposta",
    data:() => ({
      proposta:  {
        fornecedor: '',
        nota: '',
        preco: '',
        licitacaoId: '',
      },
      licitacao: {}
    }),
    mounted() {
      this.buscarLicitacao(this.$route.params.licitacaoId)
      this.proposta.licitacaoId = this.$route.params.licitacaoId
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
      inserirProposta() {
        try {
          PropostaService.inserir(this.proposta)
            .then(response => {
              alert('Cadastro realizado com sucesso.')
              console.log(response.status)
              this.proposta = {}
              this.$router.push(`/licitacoes/licitacao/${this.licitacao.licitacaoId}`)
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