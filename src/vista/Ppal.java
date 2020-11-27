package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Clases_POJO.Empleado;
import Metodos.Bs_Empleados;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Ppal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ppal window = new Ppal();
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
	public Ppal() {
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
		
		JButton btnNewButton = new JButton("Tablas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashMap<Integer, Empleado> hm = new HashMap<Integer, Empleado>();
				Bs_Empleados emp = new Bs_Empleados();
				hm = emp.getData();
				System.out.println(hm);
			Empleados vista= new Empleados(hm);
			vista.newScreen();
			frame.dispose();
			}
		});
		btnNewButton.setBounds(168, 111, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
