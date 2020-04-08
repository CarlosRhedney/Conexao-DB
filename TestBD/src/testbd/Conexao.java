package testbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class Conexao
{
	/**
	 * @autor Carlos Rhedney
	 */
    public static void main (String[] args)
    {
        Connection conn = null;

        try
        {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/urna";
            Class.forName ("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection (url, userName, password);
            JOptionPane.showMessageDialog(null, "Conectou");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível estabelecer conexão com o BD");
        }
        finally
        {
            if (conn != null)
            {
                try
                {
                	// Drive Conector MySQL.
            		Class.forName("com.mysql.jdbc.Driver");
            		 
            		// Conexão como BD.
            		Connection con = DriverManager.getConnection(
            		"jdbc:mysql://localhost/urna", "root", "");
            		 
            		// Objeto comdo SQL.
            		java.sql.Statement stmt = con.createStatement();
            		 
            		// Insere os dados BD.
            		stmt.executeQuery("select * from login");
            		JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            		 
            		// Fecha a conexão do o DB.
            		con.close();
            		 
            		} catch (SQLException Erro) {
            		JOptionPane.showMessageDialog(null,
            		"Erro ao tentar se conectar com o BD MYSQL: " + Erro.getMessage());
            		 
            		// Trata erros de conexão.
            		} catch (ClassNotFoundException Erro) {
            		 
            		JOptionPane.showMessageDialog(null, "Driver não encontrado!");
            		 
            		}
                catch (Exception e) { /* ignore close errors */ }
            }
        }
    }
}