package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Metodos.Bs_Empleados;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Borrar {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public  void newScreen(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Borrar window = new Borrar();
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
	public Borrar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 112);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Bs_Empleados emp = new Bs_Empleados();
		
		textField = new JTextField();
		textField.setBounds(10, 26, 126, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id a borrar");
		lblNewLabel.setBounds(145, 29, 72, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Borrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idq = Integer.parseInt(textField.getText());
				emp.deleteData(idq);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(335, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atr\u00E1s");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(335, 45, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
