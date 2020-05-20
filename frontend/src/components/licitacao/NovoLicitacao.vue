<template>
  <v-flex class="pa-5" xs12>
    <v-card class="pa-10">
      <v-card-title>
        Licitação
      </v-card-title>
      <v-card-text>
        <v-form >
          <v-row>
            <v-col cols="12">
              <v-text-field label="Descrição" v-model="licitacao.descricao" required>
              </v-text-field>
            </v-col>
            <v-col cols="12">
              <v-select label="Classificação" :items="items" v-model="licitacao.classificacaoEnum" required>
              </v-select>
            </v-col>
          </v-row>
        </v-form>
      </v-card-text>
      <v-card-actions>
        <v-btn text to="/licitacoes">Voltar</v-btn>
        <v-spacer></v-spacer>
        <v-btn class="primary" @click.prevent="inserir">Salvar</v-btn>
      </v-card-actions>
    </v-card>
  </v-flex>
</template>

<script>
  import LicitacaoService from "../../services/licitacao";

  export default {
    name: 'NovoLicitacao',
    data() {
      return {
        licitacao:  {
          licitacaoId: '',
          descricao: '',
          classificacaoEnum: '',
        },
        items: [
            'MENOR_PRECO',
            'NOTA_PRECO'
        ]
      }
    },
    methods: {
      inserir() {
        // eslint-disable-next-line no-unused-vars
        LicitacaoService.inserirLicitacao(this.licitacao).then(response => {
          this.licitacao = {}
          alert('Cadastro realizado com sucesso.')
        })
      }
    }
  }
</script>

<style>

</style>