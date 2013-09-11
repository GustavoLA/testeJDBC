package br.senai.sc.model.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author leticia_jesus
 */
public class ConnectionFactory {

    private static final String STR_CONEXAO =
            "jdbc:mysql://localhost:3306/";
    private static final String DATABASE = "testandojdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "";
//para chamar o banco tem que colocar o getconnection//

    public static Connection getConnection()
            throws SQLException {

        try {

            return DriverManager.getConnection(STR_CONEXAO + DATABASE, USER, PASSWORD);
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }


    }

    public static void closeConnection(Connection con)
            throws SQLException {
        if (con != null) {
            con.close();
            System.out.println("Conexão finalizada");
        }
    }

    public static void closeConnection(Connection con, Statement st) throws SQLException {
        if (st != null) {
            st.close();
            System.out.println("Statement finalizado");
        }
        closeConnection(con);
    }

    public static void closeConnection(Connection con, Statement st, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
            System.out.println("ResultSet finalizado");
        }
        closeConnection(con, st);
    }
}
