/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.testes.persistencia;

import br.senai.sc.model.negocio.Pessoa;
import br.senai.sc.model.persistencia.PessoaDaoJDBC;
import br.senai.sc.model.persistencia.dao.PessoaDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo_lourenco
 */
public class TesteInsercao {

    public static void main(String[] args) {

        Pessoa p = new Pessoa();
        p.setNome(JOptionPane.showInputDialog("Informe o nome da pessoa: "));
        String dataNascimento = JOptionPane.showInputDialog("Informe a data de nascimento da pessoa: ");
        try {

            p.setDataNascimento(new SimpleDateFormat("dd/mm/yyyy").parse(dataNascimento));
        } catch (ParseException e) {
            System.out.println("Erro ao converter a data de nascimento" + e.getMessage());
        }
        PessoaDAO dao = new PessoaDaoJDBC();
        dao.insert(p);
    }
}
