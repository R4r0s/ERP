package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void newScreen(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
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
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 635, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id_empleado", "tlf", "n_ss", "direccion", "apellido", "seccion", "nombre", "puesto", "dni", "email"
			}
		));
		table.setBounds(10, 15, 506, 289);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.setBounds(526, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Borrar");
		btnNewButton_1.setBounds(526, 45, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Editar");
		btnNewButton_2.setBounds(526, 79, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Atr\u00E1s");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ppal vista= new Ppal();
				vista.newScreen();
				frame.dispose();
			}
		});
		btnNewButton_3.setBounds(526, 392, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
	}
}