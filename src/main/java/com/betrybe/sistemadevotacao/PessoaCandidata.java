package com.betrybe.sistemadevotacao;

/**
 * Classe que representa uma pessoa candidata.
 */
public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /**
   * Construtor da classe PessoaCandidata.
   */
  public PessoaCandidata(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  /**
   * Getter and Setter.
   */

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }

  /**
   * Método que retorna a quantidade de votos.
   */

  public void receberVoto() {
    this.votos += 1;
  }
}
