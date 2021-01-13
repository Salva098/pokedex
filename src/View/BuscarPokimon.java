package View;

import java.awt.Font;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author Salva
 *
 */
public class BuscarPokimon extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblBuscarPokemonImg;
	private JTextField textField;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;


	/**
	 * Create the application.
	 */
	public BuscarPokimon() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setComponents();
		setButtons();
		setLiseners();
		setFrame();
		
	}
	
	private void setButtons() {
		ButtonGroup grupo1 = new ButtonGroup();
			rdbtnNewRadioButton = new JRadioButton("Id Pokemon");
			rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnNewRadioButton.setBounds(120, 140, 112, 23);
			add(rdbtnNewRadioButton);

			rdbtnNewRadioButton_1 = new JRadioButton("Pokemon");
			rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnNewRadioButton_1.setBounds(234, 140, 105, 23);
			add(rdbtnNewRadioButton_1);

			rdbtnNewRadioButton_2 = new JRadioButton("Tipo");
			rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnNewRadioButton_2.setBounds(341, 140, 87, 23);
			add(rdbtnNewRadioButton_2);
			
			grupo1.add(rdbtnNewRadioButton);
			grupo1.add(rdbtnNewRadioButton_1);
			grupo1.add(rdbtnNewRadioButton_2);
	}
	
	private void setLiseners() {
		
	}
	
	private void setFrame() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(132, 103, 296, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar Pokemon");
		btnBuscar.setBounds(381, 270, 125, 30);
		add(btnBuscar);
	}
	
	private void setComponents() {
		try {
			lblBuscarPokemonImg = new JLabel(new ImageIcon(new URL("https://fontmeme.com/permalink/210112/88819101259343211d7472c07bf2cd3d.png")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblBuscarPokemonImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarPokemonImg.setBounds(0, 11, 440, 80);
		add(lblBuscarPokemonImg);
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setBounds(10, 96, 112, 30);
		add(lblBuscar);
		
	}
}
