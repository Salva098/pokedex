package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import DAO.PokemonDAO;
import Models.Pokemon;
import Util.TextHelp;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Pokedex implements KeyListener {

	private JFrame frame;
	private JLabel lblfondo;
	private JLabel lblImgPokemon;
	private JLabel lblDatosPokemon;
	private JLabel lblNumeroPokemon;
	private JLabel lblNombrePokemon;
	private JLabel lblAlturaPokemon;
	private JLabel lblPesoPokemon;
	private JLabel lblCategoriaPokemon;
	private JLabel lblTipoPokemon;
	private JLabel lblNumero;
	private JLabel lblDescripcionPokemon;
	private JLabel lblNombre;
	private JLabel lblAltura;
	private JLabel lblPeso;
	private JLabel lblCategoria;
	private JLabel lblTipo_1;
	private JLabel lblTipo_2;
	private JButton btnanterior;
	private JButton btnSiguiente;
	private JTextArea textAreaDescrp;
	private JLabel lblHabilidadPokemon;
	private JLabel lblHabilidad;
	private JLabel lblpokeimg;
	private Pokemon pokimon;
	private MediaPlayer mediaPlayer;
	private JLabel PokemonLogo;
	private int id;
	private TextHelp text;
	private PokemonDAO BBDD;
	private JMenuBar menuBar;
	private JMenu mnInicio;
	private JMenuItem mntmUsuario;
	private JMenu mnPokemon;
	private JMenuItem mntmnewPokemon;
	private JMenuItem mntmEditPokemon;
	private JMenuItem mntmBuscarPokemon;
	private String usuario;
	private JMenuItem mntmBorrarPokemon;
	private JSeparator separator;
	private JMenuItem mntmCerrarSesion;

	/**
	 * Create the application.
	 */
	/**
	 * Constructor que empieza con la id que se le pase
	 * 
	 * @param x       posicion de la ventana en el eje X
	 * @param y       posicion de la ventana en el eje Y
	 * @param id      con la que empieza la pokedex
	 * @param usuario nombre del usuario que entra
	 */
	public Pokedex(int x, int y, int id, String usuario) {
		BBDD = new PokemonDAO();
		text = new TextHelp();
		this.usuario = usuario;
		this.id = id;
		initialize();
		mntmUsuario.setText("Usuario: " + usuario);
		frame.setBounds(x, y, 812, 643);
	}

	/**
	 * Constructor que empieza con el primer pokemon
	 * 
	 * @param x       posicion de la ventana en el eje X
	 * @param y       posicion de la ventana en el eje Y
	 * @param usuario nombre del usuario que entra
	 */

	public Pokedex(int x, int y, String usuario) {
		BBDD = new PokemonDAO();
		text = new TextHelp();
		this.usuario = usuario;
		id = BBDD.primerPokemon();
		initialize();
		mntmUsuario.setText("Usuario: " + usuario);

		frame.setBounds(x, y, 812, 643);
	}

	/**
	 * inicia los componentes del frame
	 */
	private void initialize() {
		frame = new JFrame();
		com.sun.javafx.application.PlatformImpl.startup(() -> {
		});
		loadcontent();
		loadPokemon(id);
		loadbuttons();
		setListener();
		loadFrame();
		frame.setResizable(false);
		frame.addKeyListener(this);
		frame.setFocusable(true);
		frame.setFocusTraversalKeysEnabled(false);

	}

	/**
	 * metodo para cargar el pokemon en los campos de las labels
	 * 
	 * @param id del pokemon que quieres cargar
	 */
	public void loadPokemon(int id) {
		String[] tipos;

		pokimon = BBDD.getPokemonDAO(id);

		String nombre = pokimon.getNombre(), nombrepokedex = "";
		if (nombre.equalsIgnoreCase("nidoranf")) {
			nombrepokedex = "Nidoran (F)";
		} else if (nombre.equalsIgnoreCase("nidoranm")) {
			nombrepokedex = "Nidoran (M)";
		} else if (nombre.equalsIgnoreCase("mrmime")) {
			nombrepokedex = "Mr. Mime";
		} else if (nombre.equalsIgnoreCase("Farfetch'd")) {
			nombrepokedex = "Farfetch'd";
		} else {
			nombrepokedex = nombre;
		}
		mediaPlayer = new MediaPlayer(new Media(pokimon.getSonido()));
		lblNombre.setText(text.toMayus(nombrepokedex));
		lblNumero.setText(String.valueOf(pokimon.getId_pokemon()));

		lblHabilidad.setText(text.toMayus(pokimon.getHabilidad()));
		lblAltura.setText(String.valueOf(pokimon.getAltura()));
		lblPeso.setText(String.valueOf(pokimon.getPeso()));
		lblCategoria.setText(text.toMayus(pokimon.getCategoria()));
		tipos = pokimon.getTipo().split(", ");
		try {
			lblTipo_1.setIcon(new ImageIcon(new URL(BBDD.geticonoTipo(tipos[0]))));
		} catch (MalformedURLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (tipos.length == 2) {
			try {
				lblTipo_2.setIcon(new ImageIcon(new URL(BBDD.geticonoTipo(tipos[1]))));
			} catch (MalformedURLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		} else {
			try {

				lblTipo_2.setIcon(new ImageIcon(new URL("https://bit.ly/2Kr76Pi")));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		textAreaDescrp.setText(pokimon.getDescripcion());

		try {
			lblpokeimg.setIcon(new ImageIcon(new URL(pokimon.getGif())));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			lblImgPokemon.setIcon(new ImageIcon(new URL(pokimon.getImagen())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setTitle("Pokedex - " + pokimon.getNombre());
	}

	/**
	 * Cargar el Frame
	 */
	private void loadFrame() {
		// foto del fondo la cargo cuando el panel
		try {
			lblfondo = new JLabel(new ImageIcon(new URL("https://gran4u.xtgem.com/Pokedex.png")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			frame.setIconImage(ImageIO.read(
					new URL("https://cdn0.iconfinder.com/data/icons/pokemon-go-vol-2/135/_pokemon_moltres-512.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.setTitle("Pokedex - " + pokimon.getNombre());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		lblfondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblfondo.setBounds(0, 0, 796, 608);
		frame.getContentPane().add(lblfondo);
		frame.setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setResizable(false); // false
		frame.setVisible(true);// true

	}

	/**
	 * Carga los liseners
	 */
	private void setListener() {

		mntmBorrarPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombrePoke = JOptionPane.showInputDialog(frame, "Dime el nombre del pokemon: ",
						"Confirmacion de eliminar el Pokemon", JOptionPane.INFORMATION_MESSAGE);
				if (nombrePoke != null) {
					if (nombrePoke.equalsIgnoreCase(pokimon.getNombre())) {
						BBDD.borrarPokemon(id);
						siguiente();
						JOptionPane.showMessageDialog(frame, "Pokemon Borrado Correctamente");
					} else {
						JOptionPane.showMessageDialog(frame, "No has escrito bien el nombre del pokemon", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				}

			}
		});

		mntmnewPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewPokemon(frame.getX(), frame.getY(), usuario);
				frame.dispose();
			}
		});
		mntmEditPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewPokemon(frame.getX(), frame.getY(), pokimon, usuario);
				frame.dispose();
			}
		});
		mntmBuscarPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuscarPokimon(frame, usuario);
			}
		});
		btnanterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anterior();
				frame.requestFocus();

			}
		});

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siguiente();
				frame.requestFocus();
			}
		});
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainView();
				frame.dispose();
			}
		});

		lblImgPokemon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				mediaPlayer.play();
			}
		});
	}

	/**
	 * Carga los Botones
	 */
	private void loadbuttons() {
		try {
			btnanterior = new JButton(
					new ImageIcon(new URL("https://assets.pokemon.com/static2/_ui/img/lightbox/prev.png")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnanterior.setBounds(457, 544, 89, 36);
		frame.getContentPane().add(btnanterior);

		try {
			btnSiguiente = new JButton(
					new ImageIcon(new URL("https://assets.pokemon.com/static2/_ui/img/lightbox/next.png")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnSiguiente.setBounds(668, 544, 89, 36);
		frame.getContentPane().add(btnSiguiente);
	}

	/**
	 * Carga los componentes
	 */
	private void loadcontent() {

		try {
			PokemonLogo = new JLabel(new ImageIcon(new URL(
					"https://assets.pokemon.com/assets/cms2-es-es/img/misc/gus/buttons/logo-pokemon-79x45.png")));
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 806, 19);
		frame.getContentPane().add(menuBar);

		mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);

		mntmUsuario = new JMenuItem("usuario");
		mnInicio.add(mntmUsuario);

		mnPokemon = new JMenu("Pokemon");
		menuBar.add(mnPokemon);

		mntmnewPokemon = new JMenuItem("Nuevo Pokemon");
		mnPokemon.add(mntmnewPokemon);

		mntmEditPokemon = new JMenuItem("Editar Pokemon");
		mnPokemon.add(mntmEditPokemon);

		mntmBorrarPokemon = new JMenuItem("Borrar Pokemon");
		mnPokemon.add(mntmBorrarPokemon);

		separator = new JSeparator();
		mnPokemon.add(separator);

		mntmBuscarPokemon = new JMenuItem("Buscar Pokemon");
		mnPokemon.add(mntmBuscarPokemon);

		JSeparator separator_2 = new JSeparator();
		mnInicio.add(separator_2);

		mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mnInicio.add(mntmCerrarSesion);

		lblTipo_2 = new JLabel();
		lblTipo_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo_2.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTipo_2.setBounds(668, 376, 89, 26);
		frame.getContentPane().add(lblTipo_2);
		PokemonLogo.setHorizontalAlignment(SwingConstants.CENTER);
		PokemonLogo.setBounds(707, 11, 89, 36);
		frame.getContentPane().add(PokemonLogo);

		lblpokeimg = new JLabel();
		lblpokeimg.setHorizontalAlignment(SwingConstants.CENTER);
		lblpokeimg.setBounds(199, 352, 160, 141);
		frame.getContentPane().add(lblpokeimg);

		lblHabilidadPokemon = new JLabel("Habilidad: ");
		lblHabilidadPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHabilidadPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblHabilidadPokemon.setBounds(457, 352, 121, 26);
		frame.getContentPane().add(lblHabilidadPokemon);

		lblHabilidad = new JLabel();
		lblHabilidad.setToolTipText("Hola");
		lblHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabilidad.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblHabilidad.setBounds(588, 353, 169, 25);
		frame.getContentPane().add(lblHabilidad);

		textAreaDescrp = new JTextArea();
		textAreaDescrp.setWrapStyleWord(true);
		textAreaDescrp.setEditable(false);
		textAreaDescrp.setBackground(Color.GREEN);
		textAreaDescrp.setBounds(467, 443, 290, 90);
		textAreaDescrp.setLineWrap(true);
		frame.getContentPane().add(textAreaDescrp);

		lblTipo_1 = new JLabel();
		lblTipo_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo_1.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTipo_1.setBounds(578, 376, 89, 26);
		frame.getContentPane().add(lblTipo_1);

		lblCategoria = new JLabel();
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblCategoria.setBounds(588, 330, 169, 19);
		frame.getContentPane().add(lblCategoria);

		lblPeso = new JLabel();
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblPeso.setBounds(588, 300, 169, 19);
		frame.getContentPane().add(lblPeso);

		lblAltura = new JLabel();
		lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblAltura.setBounds(588, 270, 169, 19);
		frame.getContentPane().add(lblAltura);

		lblNombre = new JLabel();
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNombre.setBounds(588, 240, 169, 19);
		frame.getContentPane().add(lblNombre);

		lblNumero = new JLabel();
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNumero.setBounds(588, 210, 169, 19);
		frame.getContentPane().add(lblNumero);

		lblDescripcionPokemon = new JLabel("Descripcion:");
		lblDescripcionPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcionPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblDescripcionPokemon.setBounds(457, 413, 121, 19);
		frame.getContentPane().add(lblDescripcionPokemon);

		lblTipoPokemon = new JLabel("Tipo: ");
		lblTipoPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTipoPokemon.setBounds(457, 383, 118, 19);
		frame.getContentPane().add(lblTipoPokemon);

		lblCategoriaPokemon = new JLabel("Categoria: ");
		lblCategoriaPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoriaPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblCategoriaPokemon.setBounds(457, 330, 121, 19);
		frame.getContentPane().add(lblCategoriaPokemon);

		lblPesoPokemon = new JLabel("Peso: ");
		lblPesoPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesoPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblPesoPokemon.setBounds(457, 300, 121, 19);
		frame.getContentPane().add(lblPesoPokemon);

		lblAlturaPokemon = new JLabel("Altura: ");
		lblAlturaPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlturaPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblAlturaPokemon.setBounds(457, 270, 121, 19);
		frame.getContentPane().add(lblAlturaPokemon);

		lblNombrePokemon = new JLabel("Nombre: ");
		lblNombrePokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombrePokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNombrePokemon.setBounds(457, 240, 121, 19);
		frame.getContentPane().add(lblNombrePokemon);

		lblNumeroPokemon = new JLabel("Numero: ");
		lblNumeroPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNumeroPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPokemon.setBounds(457, 210, 121, 19);
		frame.getContentPane().add(lblNumeroPokemon);

		lblImgPokemon = new JLabel();
		lblImgPokemon.setToolTipText("Pulsame para escucharme");
		lblImgPokemon.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgPokemon.setBounds(28, 157, 331, 336);
		frame.getContentPane().add(lblImgPokemon);

		lblDatosPokemon = new JLabel("Datos Pokemon:");
		lblDatosPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblDatosPokemon.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosPokemon.setBounds(457, 173, 303, 26);
		frame.getContentPane().add(lblDatosPokemon);

	}

	/**
	 * metodo para mostrar el siguiente pokemon existente
	 */
	private void siguiente() {
		boolean siguiente = true;
		id++;
		while (siguiente) {

			if (BBDD.hayPokemon(id)) {
				loadPokemon(id);
				siguiente = false;
			} else {
				id++;
				if (BBDD.ultimoPokemon() < id) {
					id = BBDD.primerPokemon();
					loadPokemon(id);
					siguiente = false;
				} else {
					siguiente = true;
				}
			}
		}
	}

	/**
	 * metodo para mostrar el anterior pokemon existente
	 */
	private void anterior() {
		boolean siguiente = true;
		id--;
		while (siguiente) {
			if (BBDD.hayPokemon(id)) {
				loadPokemon(id);
				siguiente = false;
			} else {
				id--;
				if (BBDD.primerPokemon() > id) {
					id = BBDD.ultimoPokemon();
					loadPokemon(id);
					siguiente = false;
				} else {
					siguiente = true;
				}
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * metodo para moverse con las flechas
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			siguiente();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			anterior();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
