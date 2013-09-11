/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.testes.persistencia;

import br.senai.sc.model.negocio.Endereco;
import br.senai.sc.model.persistencia.EnderecoDaoJDBC;
import br.senai.sc.model.persistencia.dao.EnderecoDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo_lourenco
 */
public class TesteInsercaoEndereco {

    public static void main(String[] args) {
        Endereco e = new Endereco();
        e.setRua(JOptionPane.showInputDialog("Rua: "));
        e.setEstado(JOptionPane.showInputDialog("Estado: "));
        e.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Número: ")));
        e.setCidade(JOptionPane.showInputDialog("Cidade: "));
        EnderecoDAO dao = new EnderecoDaoJDBC();
        dao.insert(e);
    }
}
