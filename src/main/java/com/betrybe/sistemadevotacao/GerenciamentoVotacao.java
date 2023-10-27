package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe que representa o gerenciamento de votação.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<String> cpfsComputados;
  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;

  /**
   * Construtor da classe GerenciamentoVotacao.
   */
  public GerenciamentoVotacao() {
    this.cpfsComputados = new ArrayList<>();
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
  }

  public ArrayList<String> getCpfsComputados() {
    return cpfsComputados;
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
      PessoaCandidata novaPessoaCandidata = new PessoaCandidata(nome, numero);
      this.pessoasCandidatas.add(novaPessoaCandidata);
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

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (!cpfsComputados.isEmpty()) {
      for (String cpf : cpfsComputados) {
        if (cpf.equals(cpfPessoaEleitora)) {
          System.out.println("Pessoa eleitora já votou!");
          return;
        }
      }
    }
    cpfsComputados.add(cpfPessoaEleitora);
    for (PessoaCandidata pessoa : pessoasCandidatas) {
      if (pessoa.getNumero() == numeroPessoaCandidata) {
        pessoa.receberVoto();
      }
    }
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um "
          + " voto para mostrar o resultado");
      return;
    }
    int total = cpfsComputados.size();
    for (PessoaCandidata candidata : pessoasCandidatas) {
      System.out.printf("Nome: %s - %d votos ( %d%% )%n",
          candidata.getNome(),
          candidata.getVotos(),
          Math.round((float) candidata.getVotos() / total * 100)
      );
    }
    System.out.printf("Total de votos: %d%n", total);
  }
}
