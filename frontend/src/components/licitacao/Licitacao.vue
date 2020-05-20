<template>
  <v-flex class="pa-5" xs12>
    <v-card>
      <v-card-title>Licitação #{{ licitacao.licitacaoId }}</v-card-title>
      <v-card-subtitle v-if="licitacao.classificacaoEnum == 'MENOR_PRECO'">Menor Preço</v-card-subtitle>
      <v-card-subtitle v-else>Nota Preço</v-card-subtitle>
      <v-card-text>{{ licitacao.descricao }}</v-card-text>
      <v-card-actions>
        <v-btn text @click="show = !show">Ver Propostas</v-btn>
      </v-card-actions>

      <v-expand-transition>
        <div v-show="show">
          <v-divider></v-divider>
          <v-simple-table fixed-header>
            <thead>
              <th class="text-left">Classificação</th>
              <th class="text-left">Fornecedor</th>
              <th class="text-left">Nota</th>
              <th class="text-left">Preço</th>
              <th class="text-left">Data</th>
            </thead>
            <tbody>
              <tr v-for="proposta in licitacao.propostaDTO" :key="proposta.id" :proposta="proposta">
                <td>{{ proposta.classificacao }}</td>
                <td>{{ proposta.fornecedor }}</td>
                <td>{{ proposta.nota }}</td>
                <td>{{ proposta.preco }}</td>
                <td>{{ proposta.dataCadastro }}</td>
              </tr>
            </tbody>
          </v-simple-table>
        </div>
      </v-expand-transition>
    </v-card>
  </v-flex>
</template>

<script>
  export default {
    name: 'Licitacao',
    props: [
      'licitacao'
    ],
    data:() => ({
      show: false,
    })
  }
</script>

<style scoped>

</style>