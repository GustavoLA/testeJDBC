/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Endereco;
import br.senai.sc.model.persistencia.dao.EnderecoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe responsavel ela persistência da entidade endereco na base de dados
 *
 * @author gustavo_lourenco
 * @version 1.0 09/09/2013
 */
public class EnderecoDaoJDBC implements EnderecoDAO {

    private final String INSERT = "Insert into endereco(rua, estado, numero, cidade) values (?, ?, ?, ?)";
    private final String UPDATE = "update endereco set rua = ?, estado = ?, numero = ?, cidade = ? where id = ?";
    private final String DELETE = "delete from endereco where id = ?";
    private final String LIST = "select * from endereco";
    private final String LISTBYID = "select * from endereco where id = ?";


    /* 
     * Método que realiza a inserção de uma endereco na base de dados
     */
    public boolean insert(Endereco e) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);
            pstm.setString(1, e.getRua());
            pstm.setString(2, e.getEstado());
            pstm.setInt(3, e.getNumero());
            pstm.setString(4, e.getCidade());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a transação" + ex.getMessage());
            return false;
        }
    }

    /*
     * Método responsável por atualizar uma endereco na base de dados
     */
    public boolean update(Endereco e) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, e.getRua());
            pstm.setString(2, e.getEstado());
            pstm.setInt(3, e.getNumero());
            pstm.setString(4, e.getCidade());
            pstm.setInt(5, e.getId());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a transação" + ex.getMessage());
            return false;
        }
    }

    /*
     * Método responsável por remover uma endereco da base de dados
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
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a transação" + ex.getMessage());
            return false;
        }
    }

    /*
     * Método responsável por trazer as enderecos da base de dados
     */
    public List<Endereco> listAll() {
        Connection conn;
        List<Endereco> enderecos = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Endereco e = new Endereco();
                e.setCidade(rs.getString("cidade"));
                e.setRua(rs.getString("rua"));
                e.setId(rs.getInt("id"));
                e.setEstado(rs.getString("estado"));
                e.setNumero(rs.getInt("numero"));
                enderecos.add(e);
            }

            ConnectionFactory.closeConnection(conn, pstm);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a transação" + ex.getMessage());

        }
        return enderecos;
    }

    /*
     * Método responsável por listar uma endereco com o código enviado por parâmetro
     */
    public Endereco listById(int id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Endereco e = new Endereco();
                e.setCidade(rs.getString("cidade"));
                e.setRua(rs.getString("rua"));
                e.setId(rs.getInt("id"));
                e.setEstado(rs.getString("estado"));
                e.setNumero(rs.getInt("numero"));
                return e;
            }

            ConnectionFactory.closeConnection(conn, pstm);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a transação" + ex.getMessage());

        }
        return null;
    }
}
