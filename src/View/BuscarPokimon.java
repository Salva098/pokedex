package View;

import java.awt.Font;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;

/**
 * @author Salva
 *
 */
public class BuscarPokimon {

	private JFrame frame;
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
		frame = new JFrame();
		setComponents();
		setButtons();
		setLiseners();
		setFrame();
		frame.setVisible(true);
		
	}
	
	private void setButtons() {
		ButtonGroup grupo1 = new ButtonGroup();
			rdbtnNewRadioButton = new JRadioButton("Id Pokemon");
			rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnNewRadioButton.setBounds(160, 144, 112, 23);
			frame.getContentPane().add(rdbtnNewRadioButton);

			rdbtnNewRadioButton_1 = new JRadioButton("Pokemon");
			rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnNewRadioButton_1.setBounds(274, 144, 105, 23);
			frame.getContentPane().add(rdbtnNewRadioButton_1);

			rdbtnNewRadioButton_2 = new JRadioButton("Tipo");
			rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnNewRadioButton_2.setBounds(381, 144, 87, 23);
			frame.getContentPane().add(rdbtnNewRadioButton_2);
			
			grupo1.add(rdbtnNewRadioButton);
			grupo1.add(rdbtnNewRadioButton_1);
			grupo1.add(rdbtnNewRadioButton_2);
	}
	
	private void setLiseners() {
		
	}
	
	private void setFrame() {
		frame.setBounds(100, 100, 600, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(172, 107, 296, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar Pokemon");
		btnBuscar.setBounds(381, 270, 125, 30);
		frame.getContentPane().add(btnBuscar);
		frame.setResizable(false);
	}
	
	private void setComponents() {
		try {
			lblBuscarPokemonImg = new JLabel(new ImageIcon(new URL("https://fontmeme.com/permalink/210112/88819101259343211d7472c07bf2cd3d.png")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblBuscarPokemonImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarPokemonImg.setBounds(10, 11, 564, 80);
		frame.getContentPane().add(lblBuscarPokemonImg);
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setBounds(50, 100, 112, 30);
		frame.getContentPane().add(lblBuscar);
		
	}
}
