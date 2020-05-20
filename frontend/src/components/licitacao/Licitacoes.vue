<template>
  <v-layout row wrap>
    <v-flex class="pa-5" xs12>
      <v-btn color="primary" to="/licitacoes/novo">Nova Licitação</v-btn>
    </v-flex>
    <Licitacao v-for="licitacao in licitacoes" :key="licitacao.licitacaoId" :licitacao="licitacao" />
  </v-layout>
</template>

<script>
  import Licitacao from './Licitacao';
  import LicitacaoService from "../../services/licitacao";

  export default {
    name: 'Licitacoes',
    components: { Licitacao },
    data() {
      return {
        licitacoes: []
      }
    },
    mounted() {
      this.listar()
    },
    methods: {
      listar() {
        LicitacaoService.buscarLicitacoes().then(response => {
          this.licitacoes = response.data;
        })
      }
    }
  }
</script>

<style>

</style>