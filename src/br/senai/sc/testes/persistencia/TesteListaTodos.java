/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.testes.persistencia;

import br.senai.sc.model.negocio.Pessoa;
import br.senai.sc.model.persistencia.PessoaDaoJDBC;
import br.senai.sc.model.persistencia.dao.PessoaDAO;
import java.util.List;

/**
 *
 * @author gustavo_lourenco
 */
public class TesteListaTodos {

    public static void main(String[] args) {

        PessoaDAO dao = new PessoaDaoJDBC();
        List<Pessoa> pessoas = dao.listAll();
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);

        }
    }
}
