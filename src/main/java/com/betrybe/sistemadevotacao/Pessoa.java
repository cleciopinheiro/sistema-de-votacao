package com.betrybe.sistemadevotacao;

/**
 * Classe abstrata que representa uma pessoa.
 */
public abstract class Pessoa {
  protected String nome;
  
  /**
   * Getter and Setter.
   */
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
