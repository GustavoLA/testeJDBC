/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.testes.persistencia;

import br.senai.sc.model.negocio.Endereco;
import br.senai.sc.model.persistencia.EnderecoDaoJDBC;
import br.senai.sc.model.persistencia.dao.EnderecoDAO;
import java.util.List;

/**
 *
 * @author gustavo_lourenco
 */
public class TesteListaTodosEndereco {

    public static void main(String[] args) {
        EnderecoDAO dao = new EnderecoDaoJDBC();
        List<Endereco> enderecos = dao.listAll();
        for (Endereco endereco : enderecos) {
            System.out.println(endereco);
        }
    }
}
