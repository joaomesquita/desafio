<template>
  <v-flex class="pa-5" xs12>
    <v-card>
      <v-card-title>Proposta do Fornecedor {{ proposta.fornecedor }}</v-card-title>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title>Data e Horário</v-list-item-title>
          <v-list-item-subtitle>{{ proposta.dataCadastro }}</v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title>Preço</v-list-item-title>
          <v-list-item-subtitle>R${{ proposta.preco }}</v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>
      <v-list-item v-if="proposta.nota != null">
        <v-list-item-content>
          <v-list-item-title>Nota</v-list-item-title>
          <v-list-item-subtitle>{{ proposta.nota }}</v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>
      <v-list-item v-if="proposta.classificacao != null">
        <v-list-item-content>
          <v-list-item-title>Classificação</v-list-item-title>
          <v-list-item-subtitle>{{ proposta.classificacao }}</v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>
    </v-card>
  </v-flex>
</template>

<script>
  export default {
    name: 'Proposta',
    props: [
      'proposta'
    ]
  }
</script>

<style>
  .space {
    margin-top: -19px;
  }
</style>