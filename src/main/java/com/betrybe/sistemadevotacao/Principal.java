package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe que representa o gerenciamento total de votação.
 */
public class Principal {

  /**
   * Construtor da classe Principal.
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    GerenciamentoVotacao gerenciamento = new GerenciamentoVotacao();
    Scanner scanner = new Scanner(System.in);

    int opcaoCandidato;
    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente á opção desejada:");
      opcaoCandidato = Integer.parseInt(scanner.nextLine());

      if (opcaoCandidato == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nomeCandidato = scanner.nextLine();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidato = Integer.parseInt(scanner.nextLine());
        gerenciamento.cadastrarPessoaCandidata(nomeCandidato, numeroCandidato);
      }
    } while (opcaoCandidato != 2);

    int opcaoEleitor;
    do {
      System.out.println("Cadastrar eleitor?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente á opção desejada:");
      opcaoEleitor = Integer.parseInt(scanner.nextLine());

      if (opcaoEleitor == 1) {
        System.out.println("Entre com o nome do eleitor:");
        String nomeEleitor = scanner.nextLine();
        System.out.println("Entre com o título do eleitor:");
        String tituloEleitor = scanner.nextLine();
        gerenciamento.cadastrarPessoaEleitora(nomeEleitor, tituloEleitor);
      }
    } while (opcaoEleitor != 2);

    boolean votacaoAtiva = true;
    while (votacaoAtiva) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      int opcaoVotacao = Integer.parseInt(scanner.nextLine());

      switch (opcaoVotacao) {
        case 1:
          System.out.print("Entre com o CPF da pessoa eleitora: ");
          String cpf = scanner.nextLine();

          System.out.print("Entre com o número da pessoa candidata: ");
          int number = Integer.parseInt(scanner.nextLine());

          gerenciamento.votar(cpf, number);
          break;
        case 2:
          gerenciamento.mostrarResultado();
          break;
        case 3:
          gerenciamento.mostrarResultado();
          votacaoAtiva = false;
          break;
        default:
          System.out.println("Opção inválida! Tente novamente.");
          break;
      }
    }

    scanner.close();
  }
}
