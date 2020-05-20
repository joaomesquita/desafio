<template>
  <v-layout row wrap>
    <v-flex class="pa-5" xs12>
      <v-btn color="primary" to="/propostas/novo">Nova Proposta</v-btn>
    </v-flex>
    <Proposta v-for="proposta in propostas" :key="proposta.propostaId" :proposta="proposta" />
  </v-layout>
</template>

<script>
  import Proposta from "./Proposta";
  import PropostaService from "../../services/proposta";

  export default {
    name: 'Propostas',
    components: { Proposta },
    data() {
      return {
        propostas: []
      }
    },
    mounted() {
      this.listar()
    },
    methods: {
      listar() {
        PropostaService.buscarPropostas().then(response => {
          this.propostas = response.data;
        })
      }
    }
  }
</script>

<style>

</style>