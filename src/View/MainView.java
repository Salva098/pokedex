package View;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainView extends JFrame {

	

	/**
	 * Esto es un frame en el cual se muestra solo 2 paneles el panel del login y el panel del register
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Inicia los componentes del frame.
	 */
	private void initialize() {
		setContentPane(new Login(this));
		setBounds(100, 100, 646, 436);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		try {
			setIconImage(ImageIO.read(new URL("https://leonidasesteban.com/icons/icon-50x50.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setVisible(true);

	}
}
