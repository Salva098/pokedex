package View;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class Pokedex {

	private JFrame frame;
	private JLabel lblfondo;
	private JLabel lblImgPokemon;
	private JLabel lblImgIco;
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
	private JLabel lblDescrp;
	private JButton btnanterior;
	private JButton btnSiguiente;

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
		loadcontent();
		loadbuttons();
		setListener();
		loadFrame();

	}

	private void loadFrame() {
		// foto del fondo la cargo cuando el panel
		try {
			lblfondo = new JLabel(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/k7EDxUM.png"))));
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

		frame.setTitle("Pokedex");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setResizable(false); // false
		frame.setVisible(true);// true

	}

	private void setListener() {
		// TODO Auto-generated method stub

	}

	private void loadbuttons() {
		btnanterior = new JButton("<=");
		btnanterior.setBounds(450, 504, 89, 23);
		frame.getContentPane().add(btnanterior);
		
		btnSiguiente = new JButton("=>");
		btnSiguiente.setBounds(635, 504, 89, 23);
		frame.getContentPane().add(btnSiguiente);
	}

	private void loadcontent() {
		
		lblDescrp = new JLabel("Este Pok\u00E9mon nace con una semilla en el lomo,\r\n que brota con el paso del tiempo.");
		lblDescrp.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrp.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblDescrp.setBounds(440, 403, 284, 90);
		frame.getContentPane().add(lblDescrp);

		lblTipo = new JLabel("Planta, Veneno");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTipo.setBounds(578, 328, 144, 19);
		frame.getContentPane().add(lblTipo);

		lblCategoria = new JLabel("Semilla");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblCategoria.setBounds(604, 298, 118, 19);
		frame.getContentPane().add(lblCategoria);

		lblPeso = new JLabel("6,9 kg");
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblPeso.setBounds(604, 268, 118, 19);
		frame.getContentPane().add(lblPeso);

		lblAltura = new JLabel("Altura");
		lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblAltura.setBounds(604, 238, 118, 19);
		frame.getContentPane().add(lblAltura);

		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNombre.setBounds(604, 208, 118, 19);
		frame.getContentPane().add(lblNombre);

		lblNumero = new JLabel("1");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNumero.setBounds(604, 178, 118, 19);
		frame.getContentPane().add(lblNumero);

		lblDescripcionPokemon = new JLabel("Descripcion:");
		lblDescripcionPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcionPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblDescripcionPokemon.setBounds(450, 357, 118, 19);
		frame.getContentPane().add(lblDescripcionPokemon);

		lblTipoPokemon = new JLabel("Tipo: ");
		lblTipoPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTipoPokemon.setBounds(450, 327, 118, 19);
		frame.getContentPane().add(lblTipoPokemon);

		lblCategoriaPokemon = new JLabel("Categoria: ");
		lblCategoriaPokemon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoriaPokemon.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblCategoriaPokemon.setBounds(450, 297, 144, 19);
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

		try {
			lblImgIco = new JLabel(
					new ImageIcon(ImageIO.read(new URL("https://images.alexonsager.net/pokemon/1.png"))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		lblImgIco.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgIco.setBounds(20, 11, 68, 57);
		frame.getContentPane().add(lblImgIco);

		try {
			lblImgPokemon = new JLabel(
					new ImageIcon(ImageIO.read(new URL("https://www.pkparaiso.com/imagenes/pokedex/pokemon/001.png"))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
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
