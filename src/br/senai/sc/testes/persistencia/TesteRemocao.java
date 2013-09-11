/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.testes.persistencia;

import br.senai.sc.model.persistencia.PessoaDaoJDBC;
import br.senai.sc.model.persistencia.dao.PessoaDAO;

/**
 *
 * @author gustavo_lourenco
 */
public class TesteRemocao {

    public static void main(String[] args) {

        PessoaDAO dao = new PessoaDaoJDBC();
        dao.delete(1);
        
    }
}
