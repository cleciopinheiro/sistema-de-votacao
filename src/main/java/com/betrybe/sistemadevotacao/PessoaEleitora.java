package com.betrybe.sistemadevotacao;

/**
 * Classe que representa uma pessoa eleitora.
 */
public class PessoaEleitora extends Pessoa {
  private String cpf;

  /**
   * Construtor da classe PessoaEleitora.
   */
  public PessoaEleitora(String nome, String cpf) {
    super.nome = nome;
    this.cpf = cpf;
  }

  /**
   * Getter and Setter.
   */
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return super.getNome();
  }

  public void setNome(String nome) {
    super.setNome(nome);
  }
}
