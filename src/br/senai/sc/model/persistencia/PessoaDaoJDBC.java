/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Pessoa;
import br.senai.sc.model.persistencia.dao.PessoaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe responsavel ela persistência da entidade pessoa na base de dados
 *
 * @author gustavo_lourenco
 * @version 1.0 09/09/2013
 */
public class PessoaDaoJDBC implements PessoaDAO {

    private final String INSERT = "Insert into pessoa(nome, datanascimento) values (?, ?)";
    private final String UPDATE = "update pessoa set nome = ?, datanascimento = ? where id = ?";
    private final String DELETE = "delete from pessoa where id = ?";
    private final String LIST = "select * from pessoa";
    private final String LISTBYID = "select * from pessoa where id = ?";


    /* 
     * Método que realiza a inserção de uma pessoa na base de dados
     */
    public boolean insert(Pessoa p) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);
            pstm.setString(1, p.getNome());
            pstm.setDate(2, new java.sql.Date(p.getDataNascimento().getTime()));
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a transação"+ e.getMessage());
            return false;
        }
    }

    /*
     * Método responsável por atualizar uma pessoa na base de dados
     */
    public boolean update(Pessoa p) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, p.getNome());
            pstm.setDate(2, new java.sql.Date(p.getDataNascimento().getTime()));
            pstm.setInt(3, p.getCodigo());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a transação");
            return false;
        }
    }

    /*
     * Método responsável por remover uma pessoa da base de dados
     */
    public boolean delete(int id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);
            pstm.setInt(1, id);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a transação");
            return false;
        }
    }

    /*
     * Método responsável por trazer as pessoas da base de dados
     */
    public List<Pessoa> listAll() {
        Connection conn;
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setCodigo(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDataNascimento(rs.getDate("datanascimento"));
                pessoas.add(p);
            }

            ConnectionFactory.closeConnection(conn, pstm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a transação");

        }
        return pessoas;
    }

    /*
     * Método responsável por listar uma pessoa com o código enviado por parâmetro
     */
    public Pessoa listById(int id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setCodigo(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDataNascimento(rs.getDate("datanascimento"));
                return p;
            }

            ConnectionFactory.closeConnection(conn, pstm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a transação");

        }
        return null;
    }
}
