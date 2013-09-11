/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.testes.persistencia;

import br.senai.sc.model.negocio.Endereco;
import br.senai.sc.model.persistencia.EnderecoDaoJDBC;
import br.senai.sc.model.persistencia.dao.EnderecoDAO;


/**
 *
 * @author gustavo_lourenco
 */
public class TesteListarIDEndereco {

    public static void main(String[] args) {
        EnderecoDAO dao = new EnderecoDaoJDBC();
        Endereco e = dao.listById(1);
        System.out.println(e);

    }
}
