<template>
  <v-flex class="pa-5" xs12>
    <v-card class="pa-10">
      <v-card-title>
        Proposta
      </v-card-title>
      <v-card-text>
        <v-form>
          <v-row>
            <v-col cols="12">
              <v-text-field label="Fornecedor" v-model="proposta.fornecedor" required>
              </v-text-field>
            </v-col>
            <v-col cols="12">
              <v-text-field label="Nota" v-model="proposta.nota" required>
              </v-text-field>
            </v-col>
            <v-col cols="12">
              <v-text-field label="Preço" v-model="proposta.preco" required>
              </v-text-field>
            </v-col>
            <v-col cols="12">
              <v-text-field label="Data" v-model="proposta.dataCadastro" required>
              </v-text-field>
            </v-col>
            <v-col cols="12">
              <v-select
                      label="Licitação"
                      v-model="proposta.licitacaoId"
                      :items="licitacoes"
                      item-value="licitacaoId"
                      item-text="descricao"
              >
              </v-select>
            </v-col>
          </v-row>
        </v-form>
      </v-card-text>
      <v-card-actions>
        <v-btn text to="/propostas">Voltar</v-btn>
        <v-spacer></v-spacer>
        <v-btn class="primary" @click.prevent="inserir">Salvar</v-btn>
      </v-card-actions>
    </v-card>
  </v-flex>
</template>

<script>
  import PropostaService from '../../services/proposta';
  import LicitacaoService from '../../services/licitacao';

  export default {
    name: "NovoProposta",
    data() {
      return {
        proposta:  {
          fornecedor: '',
          nota: '',
          preco: '',
          dataCadastro: '',
          licitacaoId: '',
        },
        licitacoes: []
      }
    },
    mounted() {
      LicitacaoService.buscarLicitacoes().then(response => {
        this.licitacoes = response.data;
      })
    },
    methods: {
      inserir() {
        // eslint-disable-next-line no-unused-vars
        PropostaService.inserirPropostas(this.proposta).then(response => {
          this.proposta = {}
          alert('Cadastro realizado com sucesso.')
        })
      }
    }
  }
</script>

<style>

</style>