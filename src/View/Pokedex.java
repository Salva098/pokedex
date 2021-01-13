package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import DAO.PokemonDAO;
import Models.Pokemon;
import Util.TextHelp;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Pokedex {

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
	private DecimalFormat pkimg;
	private JButton btnAtras;
	private JButton btnAnadir;
	private JLabel PokemonLogo;
	private JLabel lblBuscarPoke;
	private int id;
	private JLabel lblEdit;
	private TextHelp text;
	private PokemonDAO BBDD;

	/**
	 * Create the application.
	 */
	public Pokedex(int x, int y, int indice) {
		BBDD= new PokemonDAO();
		text = new TextHelp();
		if (indice==0) {
			id=1;
		}else {
			id=indice;
		}
		initialize();
		frame.setBounds(x, y, 812, 643);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		com.sun.javafx.application.PlatformImpl.startup(()->{});
		loadcontent();
		loadPokemon(id);
		loadbuttons();
		setListener();
		loadFrame();

	}

	private void loadPokemon(int id) {
		String[] tipos;
		pokimon = BBDD.getPokemonDAO(id);
		String nombre = pokimon.getNombre(),nombrepokedex="";
		pkimg =new DecimalFormat("000");
		if (nombre.equalsIgnoreCase("nidoranf")) {
			nombrepokedex="Nidoran (F)";
		}else if (nombre.equalsIgnoreCase("nidoranm")) {
			nombrepokedex="Nidoran (M)";
		}else if (nombre.equalsIgnoreCase("mrmime")) {
			nombrepokedex="Mr. Mime";
		}else if (nombre.equalsIgnoreCase("Farfetch'd")) {
			nombrepokedex="Farfetch'd";
		}else {
			nombrepokedex=nombre;
		}
		
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
		if (tipos.length==2) {
			try {
				lblTipo_2.setIcon(new ImageIcon(new URL(BBDD.geticonoTipo(tipos[1]))));
			} catch (MalformedURLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}else {
			try {
				lblTipo_2.setIcon(new ImageIcon(new URL("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/9c64cfe3-bb3b-4ae8-b5a6-d2f39d21ff87/d3jme6i-8c702ad4-4b7a-4763-9901-99f8b4f038b0.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvOWM2NGNmZTMtYmIzYi00YWU4LWI1YTYtZDJmMzlkMjFmZjg3XC9kM2ptZTZpLThjNzAyYWQ0LTRiN2EtNDc2My05OTAxLTk5ZjhiNGYwMzhiMC5wbmcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.JAMbat4sBPIi4yMAvudrMIWf7vOdCgts3vn-JqFq1Oo")));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		textAreaDescrp.setText(pokimon.getDescripcion());
		
		try {
			lblpokeimg.setIcon(new ImageIcon(new URL("https://play.pokemonshowdown.com/sprites/ani/"+nombre.toLowerCase()+".gif")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			lblImgPokemon.setIcon(new ImageIcon(new URL("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/"+pkimg.format(id)+".png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setTitle("Pokedex - "+pokimon.getNombre());

	}

	private void loadFrame() {
		// foto del fondo la cargo cuando el panel
		try {
			lblfondo = new JLabel(new ImageIcon(new URL("https://gran4u.xtgem.com/Pokedex.png")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			frame.setIconImage(ImageIO.read(new URL("https://cdn0.iconfinder.com/data/icons/pokemon-go-vol-2/135/_pokemon_moltres-512.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.setTitle("Pokedex - "+pokimon.getNombre());
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

	private void setListener() {
		btnanterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BBDD.haySiguiente(--id)) {
					loadPokemon(id);
				}else {
					id=BBDD.cuantosPokemonHay();
					loadPokemon(id);
				}
					
			}
		});

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BBDD.haySiguiente(++id)) {
					loadPokemon(id);
				}else {
					id=1;
					loadPokemon(id);
				}
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainView();
				frame.dispose();
			}
		});
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewPokemon(frame.getX(), frame.getY(), null);
				frame.dispose();
			}
		});
		lblEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new NewPokemon(frame.getX(), frame.getY(), pokimon);
				frame.dispose();
			}
		});
	}

	private void loadbuttons() {
		try {
			btnanterior = new JButton(new ImageIcon(new URL("https://assets.pokemon.com/static2/_ui/img/lightbox/prev.png")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnanterior.setBounds(457, 544, 89, 36);
		frame.getContentPane().add(btnanterior);

		try {
			btnSiguiente = new JButton(new ImageIcon(new URL("https://assets.pokemon.com/static2/_ui/img/lightbox/next.png")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnSiguiente.setBounds(668, 544, 89, 36);
		frame.getContentPane().add(btnSiguiente);

		btnAtras = new JButton("Atras");
		btnAtras.setBounds(556, 544, 102, 36);
		frame.getContentPane().add(btnAtras);

		btnAnadir = new JButton("Anadir");
		btnAnadir.setBounds(467, 127, 89, 23);
		frame.getContentPane().add(btnAnadir);
	}

	private void loadcontent() {
		
		lblBuscarPoke = new JLabel("Haz click para buscar");
		
		
		lblBuscarPoke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 String[] options1 = { "Pokemon ID", "Pokemon Nombre", "Pokemon Tipo" };
				 JPanel panel = new BuscarPokimon();
				 JOptionPane.showMessageDialog(frame, panel);
//		           int result = JOptionPane.showmensageDialog(frame,panel , "Enter a Number",
//		                   JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION,
//		                   null, options1, null);
//				int buscarid =Integer.parseInt(JOptionPane.showInputDialog(frame,"Dime la id del pokemon",JOptionPane.QUESTION_MESSAGE));
//					if (PokemonDAO.haySiguiente(buscarid)) {
//						loadPokemon(buscarid);
//						id =buscarid;
//					}else {
//					try {
//						JOptionPane.showMessageDialog(null,"La id esa no existe", "Ese pokemon no se encuentra", JOptionPane.ERROR_MESSAGE, new ImageIcon(new URL("https://play.pokemonshowdown.com/sprites/gen5ani/spinda.gif")));
//					} catch (HeadlessException | IOException e1) {
//						e1.printStackTrace();
//					}
//				}
			}
		});
		
		try {
			PokemonLogo = new JLabel(new ImageIcon(new URL("https://assets.pokemon.com/assets/cms2-es-es/img/misc/gus/buttons/logo-pokemon-79x45.png")));
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		lblEdit = new JLabel("Haz click para editar el Pokemon");
		lblEdit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEdit.setBounds(152, 138, 207, 19);
		frame.getContentPane().add(lblEdit);
		
		lblTipo_2 = new JLabel();
		lblTipo_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo_2.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTipo_2.setBounds(668, 376, 89, 26);
		frame.getContentPane().add(lblTipo_2);
		PokemonLogo.setHorizontalAlignment(SwingConstants.CENTER);
		PokemonLogo.setBounds(707, 11, 89, 36);
		frame.getContentPane().add(PokemonLogo);
		
		
		lblBuscarPoke.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblBuscarPoke.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarPoke.setBounds(108, 494, 153, 48);
		frame.getContentPane().add(lblBuscarPoke);
		
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
		lblImgPokemon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mediaPlayer = new MediaPlayer(new Media("https://play.pokemonshowdown.com/audio/cries/"+pokimon.getNombre().toLowerCase()+".mp3"));
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
}
