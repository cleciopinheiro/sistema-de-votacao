package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe que representa o gerenciamento de votação.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaCandidata> cpfsComputados;
  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;

  /**
   * Construtor da classe GerenciamentoVotacao.
   */
  public GerenciamentoVotacao() {
    this.cpfsComputados = new ArrayList<PessoaCandidata>();
    this.pessoasCandidatas = new ArrayList<PessoaCandidata>();
    this.pessoasEleitoras = new ArrayList<PessoaEleitora>();
  }

  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean pessoaCandidataJaExiste = false;

    for (PessoaCandidata pessoaCandidata : this.pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numero) {
        pessoaCandidataJaExiste = true;
        break;
      }
    }

    if (pessoaCandidataJaExiste) {
      System.out.println("Número da pessoa candidata já utilizado!");
    } else {
      PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
      this.pessoasCandidatas.add(pessoaCandidata);
    }
  }

  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean pessoaEleitoraJaExiste = false;

    for (PessoaEleitora pessoaEleitora : this.pessoasEleitoras) {
      if (pessoaEleitora.getCpf().equals(cpf)) {
        pessoaEleitoraJaExiste = true;
        break;
      }
    }

    if (pessoaEleitoraJaExiste) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
      this.pessoasEleitoras.add(pessoaEleitora);
    }
  }
}
