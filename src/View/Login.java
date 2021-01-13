package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Toolkit;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.UsuarioDAO;

@SuppressWarnings("serial")
public class Login extends JPanel{

	private JFrame fparent;
	private JPanel thisPanel;
	private JLabel lblUsuario;
	private JTextField txtusuario;
	private JLabel lblLogin;
	private JLabel lblcontraseña;
	private JPasswordField passwordField;
	private JButton btnEntrar;
	private JButton btnNuevo;
	protected Cursor cursor;
	protected ImageIcon imagenes;
	protected JLabel lblfondo;
	private UsuarioDAO BBDD;

	/**
	 * Create the application.
	 */
	public Login(JFrame fparent) {
		BBDD=new UsuarioDAO();
		try {
			initialize();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		thisPanel=this;
		this.fparent=fparent;
		fparent.setTitle("Pokedex - Login");
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

	}


//	private void loadFrame() throws MalformedURLException {

		// foto del fondo la cargo cuando el panel
//		frame.setTitle("Pokedex - Login");

//	}

	private void loadcontent() throws MalformedURLException {

		lblLogin = new JLabel("Login Entrenador");
		lblLogin.setBackground(Color.WHITE);
		lblLogin.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setBounds(55, 96, 301, 67);
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

	private void loadbuttons() {
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(237, 259, 89, 23);
		add(btnEntrar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(95, 259, 89, 23);
		add(btnNuevo);
	}

	private void setListener() {
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtusuario.getText().isEmpty() && !new String(passwordField.getPassword()).isEmpty()) {
					login();
				} else {
					try {
						JOptionPane.showMessageDialog(null, "No estas rellenando los campos,\ntoma un ditto",
								"El programa esta confuso", JOptionPane.INFORMATION_MESSAGE,
								new ImageIcon(ImageIO.read(new URL("https://images.alexonsager.net/pokemon/132.png"))));
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
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					if (!txtusuario.getText().isBlank() && !String.valueOf(passwordField.getPassword()).isBlank()) {
						login();
					}

				}
			}
		});

		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Register(thisPanel);
				txtusuario.setText("");
				passwordField.setText("");
			}
		});
	}
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

	private void login() {
		if (BBDD.login(txtusuario.getText(), new String(passwordField.getPassword()))) {
			new Pokedex(fparent.getX(),fparent.getY(),0);
			fparent.dispose();
		} else {
			int n1 = (int) (Math.random() * 151 + 1), n2 = (int) (Math.random() * 151 + 1);
			try {
				JOptionPane.showMessageDialog(null, "Oh no, tu accion ha deformado este pokemon",
						"Entrenador no existente", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ImageIO.read(new URL(
								"https://images.alexonsager.net/pokemon/fused/" + n1 + "/" + n1 + "." + n2 + ".png"))));
			} catch (HeadlessException | IOException e) {
				e.printStackTrace();
			}
			txtusuario.setText("");
			passwordField.setText("");
		}
	}
}
