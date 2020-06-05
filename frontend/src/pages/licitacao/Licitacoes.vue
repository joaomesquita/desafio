<template>
  <v-layout row wrap>
    <v-flex class="pa-5" xs12>
      <v-btn class="primary" @click="$router.push('/licitacoes/nova')">
        <v-icon left>mdi-plus</v-icon> Adicionar
      </v-btn>
    </v-flex>
    <CardLicitacao v-for="licitacao in licitacoes" :key="licitacao.licitacaoId" :licitacao="licitacao"/>
  </v-layout>
</template>

<script>
  import LicitacaoService from '../../services/licitacao'
  import CardLicitacao from '../../components/licitacao/CardLicitacao'

  export default {
    name: 'Licitacoes',
    components: { CardLicitacao },
    data:() => ({
      licitacoes: [],
    }),
    mounted() {
      this.buscarLicitacoes()
    },
    methods: {
      buscarLicitacoes() {
        try {
          LicitacaoService.buscar()
            .then(response => {
              this.licitacoes = response.data;
              console.log(response.status)
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