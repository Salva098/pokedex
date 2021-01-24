package View;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.PokemonDAO;
import Models.Pokemon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BuscarPokimon {

	private JFrame frame;
	private JTextField textField;
	private JRadioButton rdbtnNombrePokemon;
	private JLabel lblBuscar;
	private JButton btnBuscar;
	private JRadioButton rdbtnIdPokemon;
	private JRadioButton rdbtnTipos;
	private JFrame fparent;
	private ButtonGroup grupo;
	private JList<String> list;
	private String usuario;
	private PokemonDAO BBDD;
	private ScrollPane scroll;

	/**
	 * Constructor de la pestaña buscar
	 * 
	 * @param fparent frame de donde viene para consegui los ejes del frame
	 * @param usuario nombre del usuario
	 */
	public BuscarPokimon(JFrame fparent, String usuario) {
		this.fparent = fparent;
		this.usuario = usuario;
		BBDD = new PokemonDAO();
		initialize();
		frame.setBounds(fparent.getX(), fparent.getY(), 477, 300);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	/**
	 * inicio del los componentes en el frame
	 */

	private void initialize() {
		loadFrame();
		setComponents();
		setLiseners();
	}

	
	/*
	 * carga los liseners
	 */
	private void setLiseners() {
		rdbtnNombrePokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonesRadios();
			}
		});
		
		rdbtnIdPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonesRadios();
			}
		});
		
		rdbtnTipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonesRadios();
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNombrePokemon.isSelected()) {
					ArrayList<Pokemon> Busqueda = BBDD.buscarPorNombre(textField.getText());
					if (!(Busqueda.size() < 1) && !(textField.getText().isBlank())) {
						new RBusqueda(fparent.getX(), fparent.getY(), usuario, Busqueda);
						frame.dispose();
						fparent.dispose();
					} else {
						JOptionPane.showMessageDialog(frame, "ERROR, no se encuentran pokemons con ese nombre", "ERROR",
								JOptionPane.ERROR_MESSAGE);

					}
				} else if (rdbtnIdPokemon.isSelected()) {
					ArrayList<Pokemon> Pokemon = new ArrayList<Pokemon>();
					if (!textField.getText().isBlank()) {
						int id = Integer.parseInt(textField.getText());
						if (BBDD.hayPokemon(id)) {
							Pokemon.add(BBDD.getPokemonDAO(id));
								new RBusqueda(fparent.getX(), fparent.getY(), usuario, Pokemon);
								frame.dispose();
								fparent.dispose();
							} else {
								JOptionPane.showMessageDialog(frame, "ERROR, no se encuentran pokemons con esa id",
										"ERROR", JOptionPane.ERROR_MESSAGE);
							}
					}else {
						JOptionPane.showMessageDialog(frame, "ERROR, no ha rellenado los espacios",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} else if (rdbtnTipos.isSelected()) {
					if (list.getSelectedValuesList().size() > 0) {

						ArrayList<String> tiposSeleccionado = (ArrayList<String>) list.getSelectedValuesList();
						System.out.println(tiposSeleccionado);
						if (!(tiposSeleccionado.size() < 1)) {
							new RBusqueda(fparent.getX(), fparent.getY(), usuario,
									BBDD.buscarPorTipo(tiposSeleccionado));
							frame.dispose();
							fparent.dispose();
						} else {
							JOptionPane.showMessageDialog(frame, "ERROR, no se encuentran pokemons con ese tipo",
									"ERROR", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(frame, "ERROR, no has seleccionado ningun tipo", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (rdbtnNombrePokemon.isSelected()) {
					char c = e.getKeyChar();
					if (!(c < '0' || c > '9')) {
						e.consume();
					}
				} else if (rdbtnIdPokemon.isSelected()) {
					char c = e.getKeyChar();
					if ((c < '0' || c > '9')) {
						e.consume();
					}
				}
			}
		});

	}

	/**
	 * carga las acciones de los RadiusButtons
	 */
	private void accionBotonesRadios() {
		if (rdbtnNombrePokemon.isSelected()) {
			scroll.setVisible(false);
			textField.setVisible(true);
			list.setVisible(false);
			rdbtnNombrePokemon.setBounds(28, 133, 127, 23);
			rdbtnIdPokemon.setBounds(164, 133, 127, 23);
			rdbtnTipos.setBounds(293, 133, 109, 23);
			textField.setText("");

		} else if (rdbtnIdPokemon.isSelected()) {
			textField.setText("");
			scroll.setVisible(false);
			list.setVisible(false);
			textField.setVisible(true);
			rdbtnNombrePokemon.setBounds(28, 133, 127, 23);
			rdbtnIdPokemon.setBounds(164, 133, 127, 23);
			rdbtnTipos.setBounds(293, 133, 109, 23);

		} else if (rdbtnTipos.isSelected()) {
			scroll.setVisible(true);
			list.setVisible(true);
			textField.setVisible(false);
			rdbtnTipos.setBounds(293, 212, 109, 23);
			rdbtnIdPokemon.setBounds(164, 212, 109, 23);
			rdbtnNombrePokemon.setBounds(28, 212, 127, 23);
		}
	}

	/**
	 * carga los componentes
	 */
	private void setComponents() {

		lblBuscar = new JLabel("Buscar:");
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setBounds(10, 83, 75, 34);
		frame.getContentPane().add(lblBuscar);

		textField = new JTextField();
		textField.setBounds(95, 90, 228, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(362, 89, 89, 23);
		frame.getContentPane().add(btnBuscar);

		rdbtnNombrePokemon = new JRadioButton("Nombre Pokemon");
		rdbtnNombrePokemon.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNombrePokemon.setBounds(28, 133, 127, 23);
		rdbtnNombrePokemon.setSelected(true);
		frame.getContentPane().add(rdbtnNombrePokemon);

		rdbtnIdPokemon = new JRadioButton("Id Pokemon");
		rdbtnIdPokemon.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnIdPokemon.setBounds(164, 133, 127, 23);
		frame.getContentPane().add(rdbtnIdPokemon);

		rdbtnTipos = new JRadioButton("Tipos");
		rdbtnTipos.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnTipos.setBounds(293, 133, 109, 23);
		frame.getContentPane().add(rdbtnTipos);

		grupo = new ButtonGroup();
		grupo.add(rdbtnIdPokemon);
		grupo.add(rdbtnNombrePokemon);
		grupo.add(rdbtnTipos);

		list = new JList<String>(BBDD.arrTipos());
		list.setVisible(false);
		list.setBounds(95, 92, 159, 107);

		scroll = new ScrollPane();
		scroll.setBounds(95, 92, 159, 107);
		scroll.add(list);
		scroll.setVisible(false);
		frame.getContentPane().add(scroll);

	}

	/**
	 * cargar el frame
	 */
	private void loadFrame() {
		frame = new JFrame();
		frame.setTitle("Buscador de Pokemon");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

	}
}
