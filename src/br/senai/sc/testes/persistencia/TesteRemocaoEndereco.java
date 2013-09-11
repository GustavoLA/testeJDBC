/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.testes.persistencia;

import br.senai.sc.model.persistencia.EnderecoDaoJDBC;
import br.senai.sc.model.persistencia.dao.EnderecoDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo_lourenco
 */
public class TesteRemocaoEndereco {
    public static void main(String[] args) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID a ser deletedo: "));
        EnderecoDAO dao = new EnderecoDaoJDBC();
        dao.delete(id);
    }
    
}
