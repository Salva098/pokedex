package Main;

import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class xd {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					xd window = new xd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public xd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String tipos [] = {"Acero","Agua","Bicho","Dragon","Electrico","Fuego","Hada","Hielo","Lucha","Normal","Planta","Psiquico","Roca","Siniestro","Tierra","Veneno","Volador","Fantasma"};
		
		list = new JList(tipos);
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setBounds(210, 62, 100, 100);
				int [] selecionao = {3,5,8};
				list.setSelectedIndices(selecionao);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(210, 67, 98, 110);
		scrollPane.setViewportView(list);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(67, 156, 210, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selectedIx = list.getSelectedIndices();
				for (int i = 0; i < selectedIx.length; i++) {
					System.out.println(selectedIx[i]);
				}
				String selected = "";
				for (int i = 0; i < selectedIx.length; i++) {
					selected += ", " + (String) list.getModel().getElementAt(selectedIx[i]);
			    }
				lblNewLabel.setText(selected);
			}
		});
		btnNewButton.setBounds(24, 37, 89, 23);
		frame.getContentPane().add(btnNewButton);
		

	}
}
