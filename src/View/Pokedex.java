package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import DAO.PokemonDAO;
import Models.Pokemon;
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
	private JLabel lblTipo;
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
	JButton btnAnadir;
	private int id;

	/**
	 * Create the application.
	 */
	public Pokedex(int x, int y) {
		initialize();
		frame.setBounds(x, y, 775, 597);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		com.sun.javafx.application.PlatformImpl.startup(()->{});
		id=1;
		loadcontent();
		loadPokemon(id);
		loadbuttons();
		setListener();
		loadFrame();

	}

	private void loadPokemon(int id) {
		pokimon = PokemonDAO.getPokemonDAO(id);
		String nombre = pokimon.getNombre(),nombrepokedex="";
		pkimg =new DecimalFormat("000");
		if (nombre.equalsIgnoreCase("nidoranf")) {
			lblNombre.setText("Nidoran (M)");
			nombrepokedex="Nidoran (M)";
		}else {
			nombrepokedex=nombre;
		}
		
		lblNombre.setText(nombrepokedex);
		lblNumero.setText(String.valueOf(pokimon.getId_pokemon()));
		
		lblHabilidad.setText(pokimon.getHabilidad());
		lblAltura.setText(String.valueOf(pokimon.getAltura()));
		lblPeso.setText(String.valueOf(pokimon.getPeso()));
		lblCategoria.setText(pokimon.getCategoria());
		lblTipo.setText(pokimon.getTipo());
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
			lblfondo = new JLabel(new ImageIcon(new URL("https://i.imgur.com/k7EDxUM.png")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lblfondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblfondo.setBounds(-42, -54, 827, 655);
		frame.getContentPane().add(lblfondo);

		try {
			frame.setIconImage(ImageIO.read(new URL("https://cdn.streamloots.com/uploads/5c902008faf5150030b1008d/95c6e8bc-52ab-4a69-a4f4-99e2e0b7706d.gif")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.setTitle("Pokedex - "+pokimon.getNombre());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setResizable(false); // false
		frame.setVisible(true);// true

	}

	private void setListener() {
		btnanterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id-- > 1) {
					loadPokemon(id);
				}else {
					id++;
				}
					
			}
		});

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PokemonDAO.haySiguiente(++id)) {
					loadPokemon(id);
				}else {
					id--;
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
				new NewPokemon(frame.getX(), frame.getY());
				frame.dispose();
			}
		});
	}

	private void loadbuttons() {
		btnanterior = new JButton("<=");
		btnanterior.setBounds(440, 504, 89, 23);
		frame.getContentPane().add(btnanterior);

		btnSiguiente = new JButton("=>");
		btnSiguiente.setBounds(635, 504, 89, 23);
		frame.getContentPane().add(btnSiguiente);

		btnAtras = new JButton("Atras");
		btnAtras.setBounds(536, 504, 89, 23);
		frame.getContentPane().add(btnAtras);

		btnAnadir = new JButton("Anadir");
		btnAnadir.setBounds(447, 106, 89, 23);
		frame.getContentPane().add(btnAnadir);
	}

	private void loadcontent() {
		
		JLabel lblBuscarPoke = new JLabel("Haz click para buscar");
		lblBuscarPoke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					
				int buscarid =Integer.parseInt(JOptionPane.showInputDialog(null,"Dime la id del pokemon",JOptionPane.QUESTION_MESSAGE));
					if (PokemonDAO.haySiguiente(buscarid)) {
						loadPokemon(buscarid);
						id =buscarid;
					}else {
					try {
						JOptionPane.showMessageDialog(null,"La id esa no existe", "Ese pokemon no se encuentra", JOptionPane.ERROR_MESSAGE, new ImageIcon(new URL("https://play.pokemonshowdown.com/sprites/gen5ani/spinda.gif")));
					} catch (HeadlessException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		lblBuscarPoke.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblBuscarPoke.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarPoke.setBounds(95, 463, 153, 26);
		frame.getContentPane().add(lblBuscarPoke);
		
		lblpokeimg = new JLabel();
		lblpokeimg.setHorizontalAlignment(SwingConstants.CENTER);
		lblpokeimg.setBounds(196, 333, 144, 119);
		frame.getContentPane().add(lblpokeimg);
		
		lblHabilidadPokemon = new JLabel("Habilidad: ");
		lblHabilidadPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHabilidadPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblHabilidadPokemon.setBounds(447, 320, 121, 26);
		frame.getContentPane().add(lblHabilidadPokemon);
		
		lblHabilidad = new JLabel();
		lblHabilidad.setText((String) null);
		lblHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabilidad.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblHabilidad.setBounds(578, 321, 144, 25);
		frame.getContentPane().add(lblHabilidad);
		

		textAreaDescrp = new JTextArea();
		textAreaDescrp.setWrapStyleWord(true);
		textAreaDescrp.setEditable(false);
		textAreaDescrp.setBackground(Color.GREEN);
		textAreaDescrp.setBounds(447, 411, 268, 73);
		textAreaDescrp.setLineWrap(true);
		frame.getContentPane().add(textAreaDescrp);

		lblTipo = new JLabel();
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTipo.setBounds(575, 351, 144, 19);
		frame.getContentPane().add(lblTipo);

		lblCategoria = new JLabel();
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblCategoria.setBounds(578, 298, 144, 19);
		frame.getContentPane().add(lblCategoria);

		lblPeso = new JLabel();
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblPeso.setBounds(604, 268, 118, 19);
		frame.getContentPane().add(lblPeso);

		lblAltura = new JLabel();
		lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblAltura.setBounds(604, 238, 118, 19);
		frame.getContentPane().add(lblAltura);

		lblNombre = new JLabel();
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNombre.setBounds(604, 208, 118, 19);
		frame.getContentPane().add(lblNombre);

		lblNumero = new JLabel();
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNumero.setBounds(604, 178, 118, 19);
		frame.getContentPane().add(lblNumero);

		lblDescripcionPokemon = new JLabel("Descripcion:");
		lblDescripcionPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcionPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblDescripcionPokemon.setBounds(447, 381, 105, 19);
		frame.getContentPane().add(lblDescripcionPokemon);

		lblTipoPokemon = new JLabel("Tipo: ");
		lblTipoPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTipoPokemon.setBounds(447, 351, 118, 19);
		frame.getContentPane().add(lblTipoPokemon);

		lblCategoriaPokemon = new JLabel("Categoria: ");
		lblCategoriaPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoriaPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblCategoriaPokemon.setBounds(450, 297, 121, 19);
		frame.getContentPane().add(lblCategoriaPokemon);

		lblPesoPokemon = new JLabel("Peso: ");
		lblPesoPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesoPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblPesoPokemon.setBounds(450, 267, 144, 19);
		frame.getContentPane().add(lblPesoPokemon);

		lblAlturaPokemon = new JLabel("Altura: ");
		lblAlturaPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlturaPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblAlturaPokemon.setBounds(450, 237, 144, 19);
		frame.getContentPane().add(lblAlturaPokemon);

		lblNombrePokemon = new JLabel("Nombre: ");
		lblNombrePokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombrePokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNombrePokemon.setBounds(450, 207, 144, 19);
		frame.getContentPane().add(lblNombrePokemon);

		lblNumeroPokemon = new JLabel("Numero: ");
		lblNumeroPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNumeroPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPokemon.setBounds(450, 177, 144, 19);
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
		lblImgPokemon.setBounds(27, 137, 313, 315);
		frame.getContentPane().add(lblImgPokemon);

		lblDatosPokemon = new JLabel("Datos Pokemon:");
		lblDatosPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblDatosPokemon.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosPokemon.setBounds(440, 140, 284, 26);
		frame.getContentPane().add(lblDatosPokemon);

	}
}
