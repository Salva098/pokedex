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
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.PokemonDAO;
import Models.Pokemon;
import Util.TextHelp;

public class NewPokemon {

	private JFrame frame;
	private JLabel lblfondo;
	private JLabel lblHowIsThisPokimon;
	private JLabel lblDatosPokemon;
	private JLabel lblNumeroPokemon;
	private JLabel lblNombrePokemon;
	private JLabel lblAlturaPokemon;
	private JLabel lblPesoPokemon;
	private JLabel lblCategoriaPokemon;
	private JLabel lblTipoPokemon;
	private JLabel lblNumero;
	private JLabel lblDescripcionPokemon;
	private JButton btnCrear;
	private JTextArea textAreaDescrp;
	private JLabel lblHabilidadPokemon;
	private JButton btnatras;
	private Pokemon pokimon;
	private JTextField txtNombre;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtCategoria;
	private JTextField txtHabilidad;
	private JButton btnedit;
	private DecimalFormat pkimg;
	private TextHelp text;
	private PokemonDAO BBDD;
	private JList<String> listaTipos;
	private JScrollPane scrollPane;
	private String Usuario;
	private JComboBox<Integer> comboBox;
	private boolean edit;

	/**
	 * Constructor para editar un pokemon
	 * @param x coordenadas de la posicion en el eje X
	 * @param y coordenadas de la posicion en el eje Y
	 * @param poke pokemon que se va a editar
	 * @param Usuario nombre del usuario
	 */
	public NewPokemon(int x, int y, Pokemon poke, String Usuario) {
		BBDD = new PokemonDAO();
		text = new TextHelp();
		this.Usuario = Usuario;
		edit = true;
		initialize();
		pokimon = poke;
		loadPokemon(poke);
		frame.setBounds(x, y, 812, 643);
		frame.setResizable(false);
		btnedit.setVisible(true);
		lblNumero.setVisible(true);
		btnCrear.setVisible(false);
		comboBox.setVisible(false);

	}

	/**
	 * Constructor para anyadir un pokemon
	 * @param x coordenadas de la posicion en el eje X
	 * @param y coordenadas de la posicion en el eje Y
	 * @param Usuario nombre del usuario
	 */

	public NewPokemon(int x, int y, String Usuario) {
		BBDD = new PokemonDAO();
		text = new TextHelp();
		this.Usuario = Usuario;
		edit = false;
		initialize();
		frame.setBounds(x, y, 812, 643);
		btnedit.setVisible(false);
		lblNumero.setVisible(false);
		btnCrear.setVisible(true);
		comboBox.setVisible(true);

	}

	/**
	 * Inicializa los componentes en el frame
	 */
	private void initialize() {
		frame = new JFrame();
		loadcontent();
		setLiseners();
		loadFrame();

	}

	/**
	 * carga un pokemon en los campos para editar
	 * @param poke pokemon que se va a editar
	 */
	private void loadPokemon(Pokemon poke) {
		lblNumero.setText(String.valueOf(poke.getId_pokemon()));
		txtNombre.setText(poke.getNombre());
		txtAltura.setText(String.valueOf(poke.getAltura()));
		txtPeso.setText(String.valueOf(poke.getPeso()));
		txtCategoria.setText(poke.getCategoria());

		txtHabilidad.setText(poke.getHabilidad());
		listaTipos.setSelectedIndices(BBDD.arrTipoSelecionado(poke));
		textAreaDescrp.setText(poke.getDescripcion());
		pkimg = new DecimalFormat("000");
		try {
			lblHowIsThisPokimon
					.setIcon(new ImageIcon(new URL("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/"
							+ pkimg.format(poke.getId_pokemon()) + ".png")));
			lblHowIsThisPokimon.setVerticalAlignment(SwingConstants.CENTER);
			lblHowIsThisPokimon.setHorizontalAlignment(SwingConstants.CENTER);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO

	}

	/**
	 * accion del boton nuevo pokemon
	 */
	private void newPokemonBD() {
		int[] arrTipos = listaTipos.getSelectedIndices();
		String Sonido = "", gif = "", imagen = "";
		int eleccion = 0;
		if (!txtNombre.getText().isBlank() && !txtAltura.getText().isBlank() && !txtPeso.getText().isBlank()
				&& !txtCategoria.getText().isBlank() && !txtHabilidad.getText().isBlank() && !(arrTipos.length == 0)
				&& !textAreaDescrp.getText().isBlank()) {
			if (!(arrTipos.length > 2)) {

				int ntipos = 0;
				String tipos = "";
				for (int i = 0; i < listaTipos.getSelectedIndices().length; i++) {
					ntipos++;
					if (ntipos == 1) {
						tipos = (String) listaTipos.getModel().getElementAt(arrTipos[i]);
					} else {
						tipos = (String) listaTipos.getModel().getElementAt(arrTipos[i]) + ", " + tipos;
					}
				}

				pkimg = new DecimalFormat("000");
				if (text.validadorUrl("https://play.pokemonshowdown.com/sprites/gen5/"
						+ txtNombre.getText().toLowerCase() + ".png")
						&& text.validadorUrl("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/"
								+ pkimg.format(comboBox.getSelectedItem()) + ".png")) {
					imagen = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/"
							+ pkimg.format(comboBox.getSelectedItem()) + ".png";
				} else {
					imagen = "https://i.imgur.com/jHA61su.gif";
				}
				
				if (text.validadorUrl(
						"https://play.pokemonshowdown.com/sprites/ani/" + txtNombre.getText().toLowerCase() + ".gif")) {

					gif = "https://play.pokemonshowdown.com/sprites/ani/" + txtNombre.getText().toLowerCase() + ".gif";


				} else {
					gif = "https://i.imgur.com/4wGvsX7.gif";
				}

				if (text.validadorUrl(
						"https://play.pokemonshowdown.com/audio/cries/" + txtNombre.getText().toLowerCase() + ".mp3")) {

					Sonido = "https://play.pokemonshowdown.com/audio/cries/" + txtNombre.getText().toLowerCase()
							+ ".mp3";

				} else {
					Sonido = "https://play.pokemonshowdown.com/audio/notification.wav";
				}

				pokimon = new Pokemon((Integer) comboBox.getSelectedItem(), text.quitarTildes(txtNombre.getText()),
						Float.valueOf(txtAltura.getText()), text.quitarTildes(txtCategoria.getText()),
						Float.valueOf(txtPeso.getText()), text.quitarTildes(textAreaDescrp.getText()),
						text.quitarTildes(txtHabilidad.getText()), text.quitarTildes(tipos), imagen, gif, Sonido);
				try {
					eleccion = JOptionPane.showConfirmDialog(frame, "Quieres Añadir este pokemon", "Nuevo pokemon",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
							new ImageIcon(new URL("https://play.pokemonshowdown.com/sprites/gen5/unown-qm.png")));
				} catch (HeadlessException | MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (eleccion == 0) {
					BBDD.NewPokimon(pokimon);
					try {
						eleccion = JOptionPane.showConfirmDialog(frame, "Quieres Añadir otro Pokemon?",
								"Añadir otro Pokemon", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
								new ImageIcon(
										new URL("https://play.pokemonshowdown.com/sprites/gen5/pikachu-hoenn.png")));
					} catch (HeadlessException | MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (eleccion == 0) {
						rellenarCombobox();
						comboBox.setSelectedItem(1);
						txtNombre.setText("");
						txtAltura.setText("");
						txtCategoria.setText("");
						txtPeso.setText("");
						txtCategoria.setText("");
						txtPeso.setText("");
						textAreaDescrp.setText("");
						txtHabilidad.setText("");
						listaTipos.clearSelection();
					} else if (eleccion == 1) {
						new Pokedex(frame.getX(), frame.getY(), pokimon.getId_pokemon(), Usuario);
						frame.dispose();
					}

				} else if (eleccion == 1) {
					try {
						JOptionPane.showMessageDialog(frame, "El pokemon no se ha añadido", "No se ha añadido",
								JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
										new URL("https://play.pokemonshowdown.com/sprites/gen5/mimikyu-busted.png")));
					} catch (HeadlessException | MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				try {
					JOptionPane.showMessageDialog(frame, "Has seleccionado mas de dos tipos",
							"ERROR en el tipo del pokemon", JOptionPane.ERROR_MESSAGE, new ImageIcon(
									new URL("https://img.pokemondb.net/sprites/black-white/anim/normal/squirtle.gif")));
				} catch (HeadlessException | MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			try {
				JOptionPane.showMessageDialog(frame, "No has rellenado los campos", "Has invocado un grimer", 0,
						new ImageIcon(new URL("https://play.pokemonshowdown.com/sprites/gen5ani/grimer.gif")));
			} catch (HeadlessException | MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	
	/**
	 * accion del boton editar pokemon
	 */
	private void editPokemonBD() {
		String Sonido = "", gif = "", imagen = "";
		int[] arrTipos = listaTipos.getSelectedIndices();
		if (!txtNombre.getText().isBlank() && !txtAltura.getText().isBlank() && !txtPeso.getText().isBlank()
				&& !txtCategoria.getText().isBlank() && !txtHabilidad.getText().isBlank() && !(arrTipos.length == 0)
				&& !textAreaDescrp.getText().isBlank()) {
			if (!(arrTipos.length > 2)) {
				int ntipos = 0;
				String tipos = "";
				for (int i = 0; i < listaTipos.getSelectedIndices().length; i++) {
					ntipos++;
					if (ntipos == 1) {
						tipos = (String) listaTipos.getModel().getElementAt(arrTipos[i]);
					} else {
						tipos = (String) listaTipos.getModel().getElementAt(arrTipos[i]) + ", " + tipos;
					}
				}

				pkimg = new DecimalFormat("000");
				if (text.validadorUrl(
						"https://play.pokemonshowdown.com/sprites/ani/" + txtNombre.getText().toLowerCase() + ".gif")) {

					gif = "https://play.pokemonshowdown.com/sprites/ani/" + txtNombre.getText().toLowerCase() + ".gif";

					if (text.validadorUrl("https://play.pokemonshowdown.com/sprites/gen5/"
							+ txtNombre.getText().toLowerCase() + ".png")
							|| text.validadorUrl("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/"
									+ pkimg.format(comboBox.getSelectedItem()) + ".png")) {
						imagen = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/"
								+ pkimg.format(comboBox.getSelectedItem()) + ".png";
					} else {
						imagen = "https://i.imgur.com/jHA61su.gif";
					}

				} else {
					gif = "https://i.imgur.com/4wGvsX7.gif";
				}

				if (text.validadorUrl(
						"https://play.pokemonshowdown.com/audio/cries/" + txtNombre.getText().toLowerCase() + ".mp3")) {

					Sonido = "https://play.pokemonshowdown.com/audio/cries/" + txtNombre.getText().toLowerCase()
							+ ".mp3";

				} else {
					Sonido = "https://play.pokemonshowdown.com/audio/notification.wav";
				}

				pokimon = new Pokemon(Integer.parseInt(lblNumero.getText()), text.quitarTildes(txtNombre.getText()),
						Float.valueOf(txtAltura.getText()), text.quitarTildes(txtCategoria.getText()),
						Float.valueOf(txtPeso.getText()), text.quitarTildes(textAreaDescrp.getText()),
						text.quitarTildes(txtHabilidad.getText()), text.quitarTildes(tipos), imagen, gif, Sonido);

				int eleccion = 0;
				try {
					eleccion = JOptionPane.showConfirmDialog(frame, "Quieres editar este pokemon", "Editar pokemon",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
							new ImageIcon(new URL("https://play.pokemonshowdown.com/sprites/gen5/melmetal.png")));
				} catch (HeadlessException | MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (eleccion == 0) {

					BBDD.editPokemon(pokimon);
					new Pokedex(frame.getX(), frame.getY(), pokimon.getId_pokemon(), Usuario);
					frame.dispose();

				} else if (eleccion == 1) {
					try {
						JOptionPane.showMessageDialog(frame, "El pokemon no se ha editado", "No se ha editado",
								JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
										new URL("https://play.pokemonshowdown.com/sprites/gen5/mimikyu-busted.png")));
					} catch (HeadlessException | MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			} else {

				try {
					JOptionPane.showMessageDialog(frame, "Has seleccionado mas de un tipo", "ERROR en el tipo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon(
									new URL("https://img.pokemondb.net/sprites/black-white/anim/normal/squirtle.gif")));
				} catch (HeadlessException | MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			try {
				JOptionPane.showMessageDialog(frame, "No has rellenado los campos", "Has invocado un grimer", 0,
						new ImageIcon(new URL("https://play.pokemonshowdown.com/sprites/gen5ani/grimer.gif")));
			} catch (HeadlessException | MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	
	/**
	 * cargar los liseners
	 */
	private void setLiseners() {
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPokemonBD();
			}
		});
		btnatras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!edit) {
					new Pokedex(frame.getX(), frame.getY(), Usuario);
					frame.dispose();
				} else {
					new Pokedex(frame.getX(), frame.getY(), pokimon.getId_pokemon(), Usuario);
					frame.dispose();
				}
			}
		});

		btnedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editPokemonBD();
			}
		});

		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				teclasPermitidas(e);
			}
		});

		txtAltura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ((c < '0' || c > '9') && !(c == '.')) {
					e.consume();
				}
			}
		});

		txtPeso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ((c < '0' || c > '9') && !(c == '.')) {
					e.consume();
				}
			}
		});

		txtCategoria.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				teclasPermitidas(e);
			}
		});

		txtHabilidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				teclasPermitidas(e);
			}
		});

	}

	/**
	 * teclas las cuales solo se pueden pulsar bloqueando los las letras
	 * @param e
	 */
	private void teclasPermitidas(KeyEvent e) {
		char c = e.getKeyChar();
		if (!(c < '0' || c > '9')) {
			e.consume();
		}
	}
	
	/**
	 * carga el frame
	 */
	private void loadFrame() {
		// foto del fondo la cargo cuando el panel
		try {
			lblfondo = new JLabel(new ImageIcon(new URL("https://gran4u.xtgem.com/Pokedex.png")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		lblfondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblfondo.setBounds(0, 0, 796, 608);
		frame.getContentPane().add(lblfondo);

		try {
			frame.setIconImage(ImageIO.read(new URL(
					"https://raw.githubusercontent.com/apavlinovic/pokemon-go-imagery/a75439329bb298ffc0b9f8926543b57999d03cbd/images/Badge_PokedexHoenn_GOLD_01.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.setTitle("Nuevo Pokemon");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setResizable(false); // false
		frame.setVisible(true);// true

	}

	/**
	 * cargar contenido
	 */
	private void loadcontent() {

		comboBox = new JComboBox<Integer>();
		comboBox.setBounds(604, 192, 111, 20);
		frame.getContentPane().add(comboBox);
		rellenarCombobox();

		listaTipos = new JList<String>(BBDD.arrTipos());
		listaTipos.setVisibleRowCount(4);
		listaTipos.setBounds(604, 380, 96, 288);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(604, 380, 96, 57);
		scrollPane.setViewportView(listaTipos);
		frame.getContentPane().add(scrollPane);

		btnedit = new JButton("Editar");
		btnedit.setBounds(467, 547, 89, 23);
		frame.getContentPane().add(btnedit);

		btnatras = new JButton("Atras");
		btnatras.setBounds(669, 547, 89, 23);
		frame.getContentPane().add(btnatras);

		btnCrear = new JButton("Crear");
		btnCrear.setBounds(467, 547, 89, 23);
		frame.getContentPane().add(btnCrear);

		txtHabilidad = new JTextField();
		txtHabilidad.setBounds(604, 349, 111, 20);
		frame.getContentPane().add(txtHabilidad);
		txtHabilidad.setColumns(10);

		txtCategoria = new JTextField();
		txtCategoria.setBounds(604, 318, 111, 20);
		frame.getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);

		txtPeso = new JTextField();
		txtPeso.setBounds(604, 287, 111, 20);
		frame.getContentPane().add(txtPeso);
		txtPeso.setColumns(10);

		txtAltura = new JTextField();
		txtAltura.setBounds(604, 256, 111, 20);
		frame.getContentPane().add(txtAltura);
		txtAltura.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(604, 225, 111, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		lblHabilidadPokemon = new JLabel("Habilidad: ");
		lblHabilidadPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHabilidadPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblHabilidadPokemon.setBounds(467, 349, 121, 23);
		frame.getContentPane().add(lblHabilidadPokemon);

		textAreaDescrp = new JTextArea();
		textAreaDescrp.setWrapStyleWord(true);
		textAreaDescrp.setBackground(Color.WHITE);
		textAreaDescrp.setBounds(467, 448, 291, 80);
		textAreaDescrp.setLineWrap(true);
		frame.getContentPane().add(textAreaDescrp);

		lblNumero = new JLabel(String.valueOf(BBDD.ultimoPokemon() + 1));
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNumero.setBounds(604, 195, 111, 19);
		frame.getContentPane().add(lblNumero);

		lblDescripcionPokemon = new JLabel("Descripcion:");
		lblDescripcionPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcionPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblDescripcionPokemon.setBounds(466, 418, 105, 19);
		frame.getContentPane().add(lblDescripcionPokemon);

		lblTipoPokemon = new JLabel("Tipo: ");
		lblTipoPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTipoPokemon.setBounds(467, 376, 118, 31);
		frame.getContentPane().add(lblTipoPokemon);

		lblCategoriaPokemon = new JLabel("Categoria: ");
		lblCategoriaPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoriaPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblCategoriaPokemon.setBounds(467, 319, 121, 19);
		frame.getContentPane().add(lblCategoriaPokemon);

		lblPesoPokemon = new JLabel("Peso: ");
		lblPesoPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesoPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblPesoPokemon.setBounds(467, 289, 121, 19);
		frame.getContentPane().add(lblPesoPokemon);

		lblAlturaPokemon = new JLabel("Altura: ");
		lblAlturaPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlturaPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblAlturaPokemon.setBounds(467, 258, 121, 19);
		frame.getContentPane().add(lblAlturaPokemon);

		lblNombrePokemon = new JLabel("Nombre: ");
		lblNombrePokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombrePokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNombrePokemon.setBounds(467, 226, 121, 19);
		frame.getContentPane().add(lblNombrePokemon);

		lblNumeroPokemon = new JLabel("Numero: ");
		lblNumeroPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNumeroPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPokemon.setBounds(467, 195, 121, 19);
		frame.getContentPane().add(lblNumeroPokemon);

		try {
			lblHowIsThisPokimon = new JLabel(new ImageIcon(new URL("https://i.imgur.com/qiPqGtS.gif")));
			lblHowIsThisPokimon.setVerticalAlignment(SwingConstants.TOP);
			lblHowIsThisPokimon.setHorizontalAlignment(SwingConstants.LEFT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblHowIsThisPokimon.setBounds(28, 158, 330, 335);
		frame.getContentPane().add(lblHowIsThisPokimon);

		lblDatosPokemon = new JLabel("Datos Pokemon:");
		lblDatosPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblDatosPokemon.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosPokemon.setBounds(467, 170, 291, 26);
		frame.getContentPane().add(lblDatosPokemon);

	}

	/**
	 * rellena el combobox con los las id de los pokemon que no existen
	 */
	private void rellenarCombobox() {
		comboBox.removeAllItems();
		for (int i = 0; i < BBDD.pokemonNoExisten().size(); i++) {
			comboBox.addItem(BBDD.pokemonNoExisten().get(i));
		}
	}
}
