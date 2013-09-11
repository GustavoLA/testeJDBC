package br.senai.sc.model.negocio;

import java.util.Date;

/**
 *
 * @author leticia_jesus
 */
public class Pessoa {

    private int codigo;
    private String nome;
    private Date dataNascimento;
    private Endereco endereco;

    public int getCodigo() {
        return codigo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return " Codigo:" + codigo + ",'\nNome:" + nome + ",\nDataNascimento:"
                + dataNascimento + "\nEndereço: " + endereco;
    }
}
