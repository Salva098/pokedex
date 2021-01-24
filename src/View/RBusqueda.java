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
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import DAO.PokemonDAO;
import Models.Pokemon;
import Util.TextHelp;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class RBusqueda implements KeyListener {

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
	private int id;
	private MediaPlayer mediaPlayer;
	private JButton btnAtras;
	private JLabel PokemonLogo;
	private TextHelp text;
	private PokemonDAO BBDD;
	private JMenuBar menuBar;
	private JMenu mnInicio;
	private JMenuItem mntmUsuario;
	private JMenu mnPokemon;
	private JMenuItem mntmnewPokemon;
	private JMenuItem mntmEditPokemon;
	private String usuario;
	private JMenuItem mntmBorrarPokemon;
	private ArrayList<Pokemon> listaPokemon;

	/**
	 * Create the application.
	 */
	
	/**
	 * Constructor para el frame que muestra el resultado de la busqueda
	 * @param x coordenada en el eje X
	 * @param y coordenada en el eje Y
	 * @param usuario nombre del usuario
	 * @param listaPokemon arraylist de los pokemons
	 */
	public RBusqueda(int x, int y, String usuario, ArrayList<Pokemon> listaPokemon) {
		BBDD = new PokemonDAO();
		text = new TextHelp();
		this.listaPokemon=listaPokemon;
		id=0;
		this.usuario = usuario;
		initialize();
		mntmUsuario.setText("Usuario: " + usuario);
		frame.setBounds(x, y, 812, 643);
		frame.setVisible(true);
	}
	

	/**
	 * Inicio de los componente del frame
	 */
	private void initialize() {
		frame = new JFrame();
		com.sun.javafx.application.PlatformImpl.startup(() -> {});
		loadcontent();
		loadPokemon(listaPokemon.get(0));
		loadbuttons();
		setListener();
		loadFrame();
		frame.setResizable(false);
		frame.addKeyListener(this);
		frame.setFocusable(true);
		frame.setFocusTraversalKeysEnabled(false);

	}

	/**
	 * carga los componentes del pokemon
	 * @param Poke pokemon que se va a cargar
	 */
	public void loadPokemon(Pokemon Poke) {
		String[] tipos;

		
		String nombre = Poke.getNombre(), nombrepokedex = "";
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
		mediaPlayer = new MediaPlayer(new Media(Poke.getSonido()));
		lblNombre.setText(text.toMayus(nombrepokedex));
		lblNumero.setText(String.valueOf(Poke.getId_pokemon()));

		lblHabilidad.setText(text.toMayus(Poke.getHabilidad()));
		lblAltura.setText(String.valueOf(Poke.getAltura()));
		lblPeso.setText(String.valueOf(Poke.getPeso()));
		lblCategoria.setText(text.toMayus(Poke.getCategoria()));
		tipos = Poke.getTipo().split(", ");
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
		textAreaDescrp.setText(Poke.getDescripcion());

		try {
			lblpokeimg.setIcon(new ImageIcon(new URL(Poke.getGif())));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			lblImgPokemon.setIcon(new ImageIcon(new URL(Poke.getImagen())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setTitle("Pokedex - " + Poke.getNombre());
	}

	
	/**
	 * cargar el frame
	 */
	private void loadFrame() {
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

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		lblfondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblfondo.setBounds(0, 0, 796, 608);
		frame.getContentPane().add(lblfondo);
		frame.setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setResizable(false); // false

	}

	/**
	 * carga los liseners
	 */
	private void setListener() {

		mntmBorrarPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombrePoke = JOptionPane.showInputDialog(frame, "Dime el nombre del pokemon: ",
						"Confirmacion de eliminar el Pokemon", JOptionPane.INFORMATION_MESSAGE);
				if (nombrePoke != null) {
					if (nombrePoke.equalsIgnoreCase(listaPokemon.get(id).getNombre())) {
						BBDD.borrarPokemon(listaPokemon.get(id).getId_pokemon());
						listaPokemon.remove(listaPokemon.get(id));
						JOptionPane.showMessageDialog(frame, "Pokemon Borrado Correctamente");
						if (listaPokemon.size()>1) {
							siguiente();
						}else {
							new Pokedex(frame.getX(), frame.getY(), usuario);
							frame.dispose();
						}
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
				new NewPokemon(frame.getX(), frame.getY(), listaPokemon.get(id), usuario);
				frame.dispose();
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
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Pokedex(frame.getX(),frame.getY(),usuario);
				frame.dispose();
			}
		});

	}

	/**
	 * carga los botones
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

		btnAtras = new JButton("Atras");
		btnAtras.setBounds(556, 544, 102, 36);
		frame.getContentPane().add(btnAtras);
	}

	/**
	 * carga el contenido
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
		lblImgPokemon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				mediaPlayer.play();
			}
		});
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
	 * metodo para pasar al siguiente pokemon en el Arraylist
	 */
	private void siguiente() {
		if (++id<listaPokemon.size()) {
			loadPokemon(listaPokemon.get(id));
		}else {
			id=0;
			loadPokemon(listaPokemon.get(id));
		}
	}
	
	/**
	 * metodo para pasar al siguiente pokemon en el Arraylist
	 */
	private void anterior() {
		if (--id>0) {
			loadPokemon(listaPokemon.get(id));
		}else {
			id=listaPokemon.size()-1;
			loadPokemon(listaPokemon.get(id));
		}

	}
	
	
	

	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * metodo para cambiar el pokemon mediante las flechas del teclado
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
