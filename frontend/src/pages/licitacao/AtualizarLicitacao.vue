<template>
  <v-flex class="pa-5" xs12>
    <v-card class="pa-10">
      <v-card-title>
        Atualizar Licitação
      </v-card-title>
      <v-card-text>
        <v-form>
          <v-row>
            <v-col cols="12">
              <v-text-field label="Descrição" v-model="licitacao.descricao" required />
            </v-col>
            <v-col cols="12">
              <v-select
                label="Tipo de Classificação"
                placeholder="Selecione"
                :items="classificacoes"
                item-text="text"
                item-value="value"
                v-model="licitacao.classificacaoEnum"
                required
              />
            </v-col>
          </v-row>
        </v-form>
      </v-card-text>
      <v-card-actions>
        <v-btn text @click="$router.push(`/licitacoes/licitacao/${licitacao.licitacaoId}`)">
          <v-icon left>mdi-arrow-left</v-icon> Voltar
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn class="primary" @click.prevent="atualizarLicitacao(licitacao.licitacaoId)">
          <v-icon left>mdi-content-save-outline</v-icon> Salvar
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-flex>
</template>

<script>
  import LicitacaoService from '../../services/licitacao'

  export default {
    name: "AtualizarLicitacao",
    data:() => ({
      licitacao: {
        licitacaoId: '',
        descricao: '',
        classificacaoEnum: ''
      },
      classificacoes: [
        {text: 'Menor Preço', value: 'MENOR_PRECO'},
        {text: 'Nota Preço', value: 'NOTA_PRECO'}
      ],
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
      atualizarLicitacao(licitacaoId) {
        try {
          LicitacaoService.atualizar(licitacaoId, this.licitacao)
            .then(response => {
              alert('Atualização realizado com sucesso.')
              console.log(response.status)
              this.licitacao = {}
              this.$router.push('/licitacoes')
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