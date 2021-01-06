package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Normalizer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.PokemonDAO;
import Models.Pokemon;

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
	private JTextField txtTipo;

	/**
	 * Create the application.
	 */
	public NewPokemon(int x, int y) {
		initialize();
		frame.setBounds(x, y, 775, 597);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		loadcontent();
		setLiseners();
		loadFrame();
	}

	private void setLiseners() {
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtNombre.getText().isBlank() && !txtAltura.getText().isBlank() && !txtPeso.getText().isBlank()
						&& !txtCategoria.getText().isBlank() && !txtHabilidad.getText().isBlank()
						&& !txtTipo.getText().isBlank() || !textAreaDescrp.getText().isBlank()) {
					pokimon = new Pokemon(Integer.parseInt(lblNumero.getText()), quitarTildes(txtNombre.getText()),
							Float.valueOf(txtAltura.getText()), quitarTildes(txtCategoria.getText()),
							Float.valueOf(txtPeso.getText()), quitarTildes(textAreaDescrp.getText()),
							quitarTildes(txtHabilidad.getText()), quitarTildes(txtTipo.getText()));

					if (PokemonDAO.NewPokimon(pokimon)) {

						lblNumero.setText(String.valueOf(PokemonDAO.cuantosPokemonHay() + 1));
						txtNombre.setText("");
						txtAltura.setText("");
						txtCategoria.setText("");
						txtPeso.setText("");
						txtCategoria.setText("");
						txtPeso.setText("");
						textAreaDescrp.setText("");
						txtHabilidad.setText("");
						txtTipo.setText("");

					} else {
						try {
							JOptionPane.showMessageDialog(frame, "Los tipos que estas poniendo no existe", "Los tipos no coincide", 0,
									new ImageIcon(new URL("https://play.pokemonshowdown.com/sprites/gen5ani/grimer.gif")));
						} catch (HeadlessException | MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
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
		});
		btnatras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Pokedex(frame.getX(), frame.getY());
				frame.dispose();

			}
		});
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
		frame.setBackground(Color.WHITE);
		frame.setResizable(false); // false
		frame.setVisible(true);// true

	}

	private void loadcontent() {

		btnatras = new JButton("Atras");
		btnatras.setBounds(626, 505, 89, 23);
		frame.getContentPane().add(btnatras);

		btnCrear = new JButton("Crear");
		btnCrear.setBounds(443, 505, 89, 23);
		frame.getContentPane().add(btnCrear);

		txtTipo = new JTextField();
		txtTipo.setBounds(604, 353, 111, 20);
		frame.getContentPane().add(txtTipo);
		txtTipo.setColumns(10);

		txtHabilidad = new JTextField();
		txtHabilidad.setBounds(604, 327, 111, 20);
		frame.getContentPane().add(txtHabilidad);
		txtHabilidad.setColumns(10);

		txtCategoria = new JTextField();
		txtCategoria.setBounds(604, 295, 111, 20);
		frame.getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);

		txtPeso = new JTextField();
		txtPeso.setBounds(604, 265, 111, 20);
		frame.getContentPane().add(txtPeso);
		txtPeso.setColumns(10);

		txtAltura = new JTextField();
		txtAltura.setBounds(604, 235, 111, 20);
		frame.getContentPane().add(txtAltura);
		txtAltura.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(604, 205, 111, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		lblHabilidadPokemon = new JLabel("Habilidad: ");
		lblHabilidadPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHabilidadPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblHabilidadPokemon.setBounds(444, 327, 121, 23);
		frame.getContentPane().add(lblHabilidadPokemon);

		textAreaDescrp = new JTextArea();
		textAreaDescrp.setWrapStyleWord(true);
		textAreaDescrp.setBackground(Color.WHITE);
		textAreaDescrp.setBounds(447, 411, 268, 73);
		textAreaDescrp.setLineWrap(true);
		frame.getContentPane().add(textAreaDescrp);

		lblNumero = new JLabel(String.valueOf(PokemonDAO.cuantosPokemonHay() + 1));
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
		lblTipoPokemon.setBounds(444, 349, 118, 31);
		frame.getContentPane().add(lblTipoPokemon);

		lblCategoriaPokemon = new JLabel("Categoria: ");
		lblCategoriaPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoriaPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblCategoriaPokemon.setBounds(450, 297, 121, 19);
		frame.getContentPane().add(lblCategoriaPokemon);

		lblPesoPokemon = new JLabel("Peso: ");
		lblPesoPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesoPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblPesoPokemon.setBounds(450, 267, 121, 19);
		frame.getContentPane().add(lblPesoPokemon);

		lblAlturaPokemon = new JLabel("Altura: ");
		lblAlturaPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlturaPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblAlturaPokemon.setBounds(450, 237, 121, 19);
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

		try {
			lblHowIsThisPokimon = new JLabel(
					new ImageIcon(new URL("https://elvortex.com/wp-content/uploads/2018/03/HddtBOT-e1520478229723.png")));
			lblHowIsThisPokimon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblHowIsThisPokimon.setBounds(29, 137, 311, 316);
		frame.getContentPane().add(lblHowIsThisPokimon);

		lblDatosPokemon = new JLabel("Datos Pokemon:");
		lblDatosPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblDatosPokemon.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosPokemon.setBounds(440, 140, 284, 26);
		frame.getContentPane().add(lblDatosPokemon);

	}

	public String quitarTildes(String texto) {
		texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
		texto = texto.replaceAll("\\p{M}", "");
		return texto;
	}
}
