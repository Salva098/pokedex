package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import DAO.UsuarioDAO;

@SuppressWarnings("serial")
public class Register extends JPanel{
	
	private JPanel parent;
	private JFrame fparent;
	private JLabel lblUsuario;
	private JTextField txtusuario;
	private JLabel lblLogin;
	private JLabel lblcontraseña;
	private JPasswordField passwordField;
	private JButton btnCancelar;
	private JButton btnRegistro;
	private JPasswordField passwordField_2;
	private JLabel lblRepetirContrasena;
	protected Cursor cursor;
	protected ImageIcon imagenes;
	protected JLabel lblfondo;
	private UsuarioDAO BBDD;

	/**
	 * constructor
	 */
	public Register(JPanel parent) {
		BBDD=new UsuarioDAO();
		this.parent=parent;
		try {
			initialize();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws MalformedURLException
	 */
	public void initialize() throws MalformedURLException {
		loadcontent();
		loadbuttons();
		setListener();
		setPanel();
		fparent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class,parent);
		fparent.setTitle("Pokedex - Register");
		fparent.setVisible(true);
		fparent.setContentPane(this);
		fparent.setVisible(true);
		
	}

	/**
	 * inicio de los liseners
	 */
	private void setListener() {
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtusuario.getText().isBlank() && !String.valueOf(passwordField.getPassword()).isBlank() && !String.valueOf(passwordField_2.getPassword()).isBlank()) {
					
				if (new String(passwordField.getPassword()).equals(new String(passwordField_2.getPassword()))) {
					signIn();
				} else {
					try {
						JOptionPane.showMessageDialog(null,
								"Oh no!! las contraseñas no coinciden y has invocado a misigno",
								"la cotraseñas no coinciden", JOptionPane.INFORMATION_MESSAGE,
								new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/4gbegfK.png"))));
					} catch (HeadlessException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					txtusuario.setText("");
					passwordField.setText("");
					passwordField_2.setText("");
				}
			}else {
				try {
					JOptionPane.showMessageDialog(null,
							"No estas rellenando los campos, toma un grimer",
							"Rellene los campos", JOptionPane.INFORMATION_MESSAGE,
							new ImageIcon(ImageIO.read(new URL("https://images.alexonsager.net/pokemon/88.png"))));
				} catch (HeadlessException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			} 
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fparent.setVisible(true);
				fparent.setTitle("Pokedex - Login");
				fparent.setContentPane(parent);
				fparent.setVisible(true);
			}
		});
	}
	
	
	/**
	 * metoro para registrar un usuario nuevo
	 */
	private void signIn() {
		if (!BBDD.comprobarUsuarios(txtusuario.getText())) {
			fparent.setContentPane(parent);
			try {
				JOptionPane.showMessageDialog(null, "Registro Completado", "Nuevo Entrenador",
						JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
								ImageIO.read(new URL("https://www.pkparaiso.com/imagenes/pokedex/frlg/025.png"))));
			} catch (HeadlessException | IOException e1) {
				e1.printStackTrace();
			}
			BBDD.register(txtusuario.getText(), new String(passwordField.getPassword()));
			txtusuario.setText("");
			passwordField.setText("");
			passwordField_2.setText("");
		} else {
			try {
				JOptionPane.showMessageDialog(null,
						"<== Este entrenador se llama " + txtusuario.getText() + "   \n\t tiene pinta de querer pelea",
						"Hay un entrenador que se se llama como tu", JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/V1Pt7o7.gif"))));
			} catch (HeadlessException | IOException e) {
				e.printStackTrace();
			}
			txtusuario.setText("");
			passwordField.setText("");
			passwordField_2.setText("");

		}
	}

	
	/**
	 * Carga los botones
	 */
	private void loadbuttons() {

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(237, 289, 89, 23);
		add(btnCancelar);

		btnRegistro = new JButton("Registrar");
		btnRegistro.setBounds(95, 289, 89, 23);
		add(btnRegistro);

	}
	
	/**
	 * Carga el contenido
	 * @throws MalformedURLException
	 */

	private void loadcontent() throws MalformedURLException {

		passwordField_2 = new JPasswordField();
		passwordField_2.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField_2.setBounds(174, 235, 152, 20);
		add(passwordField_2);

		lblRepetirContrasena = new JLabel("Repetir Contrasena:");
		lblRepetirContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepetirContrasena.setForeground(Color.BLACK);
		lblRepetirContrasena.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblRepetirContrasena.setBounds(24, 235, 140, 19);
		add(lblRepetirContrasena);

		lblLogin = new JLabel("Registro del Entrenador");
		lblLogin.setBackground(Color.WHITE);
		lblLogin.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setBounds(33, 96, 344, 67);
		add(lblLogin);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBackground(Color.BLACK);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblUsuario.setBounds(65, 176, 108, 19);
		add(lblUsuario);

		lblcontraseña = new JLabel("Contrasena:");
		lblcontraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblcontraseña.setForeground(Color.BLACK);
		lblcontraseña.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblcontraseña.setBounds(56, 206, 108, 19);
		add(lblcontraseña);

		txtusuario = new JTextField();
		txtusuario.setBounds(174, 174, 152, 20);
		add(txtusuario);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBounds(174, 206, 152, 20);
		add(passwordField);

	}
	
	
	/**
	 * Carga el panel
	 */
	public void setPanel() {
		try {
			lblfondo = new JLabel(new ImageIcon(
					ImageIO.read(new URL("https://swall.teahub.io/photos/small/26-265656_pokeball-background.jpg"))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lblfondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblfondo.setBounds(0, 0, 635, 400);

		add(lblfondo);
		setCursor();
		setLayout(null);
	}
	/*
	 * Carga el cursor
	 */
	public void setCursor() {

		try {
			imagenes = new ImageIcon(
					ImageIO.read(new URL("https://cursors2.totallyfreecursors.com/thumbnails/pokeball.gif")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Toolkit t = Toolkit.getDefaultToolkit();
		cursor = t.createCustomCursor(imagenes.getImage(), new Point(0, 0), "Cursor");
		setCursor(cursor);
	}

}
