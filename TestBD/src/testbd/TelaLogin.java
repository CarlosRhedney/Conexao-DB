package testbd;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaLogin extends JFrame {

	/**
	 * @autor Carlos Rhedney
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 530);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(118, 93, 425, 334);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(50, 106, 316, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaLogin.class.getResource("")));
		label.setBounds(21, 114, 31, 26);
		panel.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(50, 157, 316, 40);
		panel.add(passwordField);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaLogin.class.getResource("")));
		label_1.setBounds(21, 166, 48, 26);
		panel.add(label_1);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Conexao();
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnEntrar.setBackground(new Color(153, 153, 153));
		btnEntrar.setBounds(223, 226, 116, 40);
		panel.add(btnEntrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnSair.setBackground(new Color(153, 153, 153));
		btnSair.setBounds(83, 226, 116, 40);
		panel.add(btnSair);
		
		JLabel lblEfetuarLogin = new JLabel("Efetuar Login");
		lblEfetuarLogin.setForeground(new Color(153, 153, 153));
		lblEfetuarLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		lblEfetuarLogin.setBounds(81, 38, 240, 46);
		panel.add(lblEfetuarLogin);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(TelaLogin.class.getResource("")));
		label_2.setBounds(296, 22, 71, 79);
		contentPane.add(label_2);
	}

	public void Conexao() {
		try {
		// Drive Conector MySQL.
		Class.forName("com.mysql.jdbc.Driver");
		 
		// Conexão como BD.
		Connection con = DriverManager.getConnection(
		"jdbc:mysql://localhost/urna", "root", "");
		 
		// Objeto comdo SQL.
		java.sql.Statement stmt = con.createStatement();
		 
		// Pega os dados do formulário,
		String usuario = textField.getText();
		String senha = new String(passwordField.getPassword());
		 
		// Insere os dados BD.
		stmt.executeUpdate("insert into login (usuario, senha) values ('"
		+ usuario
		+ "','"
		+ senha
		+ "')");
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
	}
}
