package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.LoginDAO;

public class Login {

	private JFrame panel;
	private JLabel lblfondo;
	private JLabel lblUsuario;
	private JTextField txtusuario;
	private JLabel lblLogin;
	private JLabel lblcontraseña;
	private JPasswordField passwordField;
	private JButton btnEntrar;
	private JButton btnNuevo;
	private JButton btnCancelar;
	private JButton btnRegistro;

	/**
	 * Create the application.
	 */
	public Login() {
		try {
			initialize();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws MalformedURLException
	 */
	private void initialize() throws MalformedURLException {
		panel = new JFrame();
		loadcontent();
		loadbuttons();
		setListener();
		loadFrame();

	}

	private void loadFrame() throws MalformedURLException {

		// foto del fondo la cargo cuando el panel
		try {
			lblfondo = new JLabel(new ImageIcon(ImageIO.read(new URL("https://swall.teahub.io/photos/small/26-265656_pokeball-background.jpg"))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lblfondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblfondo.setBounds(0, 0, 635, 400);

		panel.getContentPane().add(lblfondo);
		panel.setTitle("Pokedex - Login");
		try {
			panel.setIconImage(ImageIO.read(new URL("https://leonidasesteban.com/icons/icon-50x50.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.setBounds(100, 100, 646, 436);
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.getContentPane().setLayout(null);

		panel.setResizable(false);
		panel.setVisible(true);

	}

	private void loadcontent() throws MalformedURLException {

		lblLogin = new JLabel("Login Entrenador");
		lblLogin.setBackground(Color.WHITE);
		lblLogin.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setBounds(55, 96, 301, 67);
		panel.getContentPane().add(lblLogin);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBackground(Color.BLACK);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblUsuario.setBounds(65, 176, 108, 19);
		panel.getContentPane().add(lblUsuario);

		lblcontraseña = new JLabel("Contrasena:");
		lblcontraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblcontraseña.setForeground(Color.BLACK);
		lblcontraseña.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblcontraseña.setBounds(56, 206, 108, 19);
		panel.getContentPane().add(lblcontraseña);

		txtusuario = new JTextField();
		txtusuario.setBounds(174, 174, 152, 20);
		panel.getContentPane().add(txtusuario);
		txtusuario.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBounds(174, 206, 152, 20);
		panel.getContentPane().add(passwordField);

	}

	private void loadbuttons() {
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(237, 259, 89, 23);
		panel.getContentPane().add(btnEntrar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(95, 259, 89, 23);
		panel.getContentPane().add(btnNuevo);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(237, 259, 89, 23);
		panel.getContentPane().add(btnCancelar);
		btnCancelar.setVisible(false);

		btnRegistro = new JButton("Registrar");
		btnRegistro.setBounds(95, 259, 89, 23);
		panel.getContentPane().add(btnRegistro);
		btnRegistro.setVisible(false);
	}

	private void setListener() {
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtusuario.getText().isEmpty() && !new String(passwordField.getPassword()).isEmpty()) {
					login();
				}else {
					try {
						JOptionPane.showMessageDialog(null,
								"No estas rellenando los campos,\ntoma un ditto",
								"El programa esta confuso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ImageIO
										.read(new URL("https://images.alexonsager.net/pokemon/132.png"))));
					} catch (HeadlessException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});

		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar()==KeyEvent.VK_ENTER) {
					if (!txtusuario.getText().isEmpty() && !new String(passwordField.getPassword()).isEmpty()) {
						login();
					}
					
				}
			}
		});

		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblLogin.setText("Registro Entrenador");
				txtusuario.setText("");
				passwordField.setText("");
				btnEntrar.setVisible(false);
				btnNuevo.setVisible(false);
				btnCancelar.setVisible(true);
				btnRegistro.setVisible(true);
			}
		});

		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtusuario.getText().isEmpty() && !new String(passwordField.getPassword()).isEmpty()) {
					signIn();
				} else {
					try {
						JOptionPane.showMessageDialog(null,
								"Oh No!!, tienes que introducir valores en el usuario y contraseña del entrenador",
								"El programa esta confuso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ImageIO
										.read(new URL("https://www.pkparaiso.com/imagenes/pokedex/dp/054.gif"))));
					} catch (HeadlessException | IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblLogin.setText("Login Entrenador");
				btnEntrar.setVisible(true);
				btnNuevo.setVisible(true);
				btnCancelar.setVisible(false);
				btnRegistro.setVisible(false);
				txtusuario.setText("");
				passwordField.setText("");
			}
		});
	}

	private void login() {
		if (LoginDAO.login(txtusuario.getText(), new String(passwordField.getPassword()))) {
			new Pokedex(panel.getX(), panel.getY());
			panel.dispose();
		}else {
			int n1 = (int) (Math.random()*151+1), n2=(int) (Math.random()*151+1);
			try {
				JOptionPane.showMessageDialog(null, "Oh no, tu accion ha deformado este pokemon", "Entrenador no existente",
						JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
								ImageIO.read(new URL("https://images.alexonsager.net/pokemon/fused/"+n1+"/"+n1+"."+n2+".png"))));
			} catch (HeadlessException | IOException e) {
				e.printStackTrace();
			}
			txtusuario.setText("");
			passwordField.setText("");
		}
	}

	private void signIn() {
		if (!LoginDAO.login(txtusuario.getText(), new String(passwordField.getPassword()))) {
			try {
				JOptionPane.showMessageDialog(null, "Registro Completado", "Nuevo Entrenador",
						JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
								ImageIO.read(new URL("https://www.pkparaiso.com/imagenes/pokedex/frlg/025.png"))));
			} catch (HeadlessException | IOException e1) {
				e1.printStackTrace();
			}
//			LoginDAO.register(txtusuario.getText(), new String(passwordField.getPassword()));
			txtusuario.setText("");
			passwordField.setText("");
		} else {
			try {
				JOptionPane.showMessageDialog(null,
						"<== Este entrenador se llama " + txtusuario.getText() + " \n tiene pinta de querer pelea",
						"Hay un entrenador que se se llama como tu", JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/V1Pt7o7.gif"))));
			} catch (HeadlessException | IOException e) {
				e.printStackTrace();
			}
			txtusuario.setText("");
			passwordField.setText("");
		}
	}
}
