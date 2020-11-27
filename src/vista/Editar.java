package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Clases_POJO.Empleado;
import Metodos.Bs_Empleados;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Editar {

	private JFrame frame;
	private JTextField id_empleado;
	private JTextField tlf;
	private JTextField n_ss;
	private JTextField direccion;
	private JTextField apellido;
	private JTextField nombre;
	private JTextField seccion;
	private JTextField puesto;
	private JTextField dni;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public  void newScreen(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editar window = new Editar();
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
	public Editar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 326, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Bs_Empleados emp = new Bs_Empleados();
		
		id_empleado = new JTextField();
		id_empleado.setBounds(10, 11, 137, 20);
		frame.getContentPane().add(id_empleado);
		id_empleado.setColumns(10);
		
		tlf = new JTextField();
		tlf.setBounds(10, 42, 137, 20);
		frame.getContentPane().add(tlf);
		tlf.setColumns(10);
		
		n_ss = new JTextField();
		n_ss.setBounds(10, 73, 137, 20);
		frame.getContentPane().add(n_ss);
		n_ss.setColumns(10);
		
		direccion = new JTextField();
		direccion.setBounds(10, 104, 137, 20);
		frame.getContentPane().add(direccion);
		direccion.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(10, 135, 137, 20);
		frame.getContentPane().add(apellido);
		apellido.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(10, 166, 137, 20);
		frame.getContentPane().add(nombre);
		nombre.setColumns(10);
		
		seccion = new JTextField();
		seccion.setBounds(10, 197, 137, 20);
		frame.getContentPane().add(seccion);
		seccion.setColumns(10);
		
		puesto = new JTextField();
		puesto.setBounds(10, 228, 137, 20);
		frame.getContentPane().add(puesto);
		puesto.setColumns(10);
		
		dni = new JTextField();
		dni.setBounds(10, 259, 137, 20);
		frame.getContentPane().add(dni);
		dni.setColumns(10);
		
		email = new JTextField();
		email.setBounds(10, 290, 137, 20);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idq = Integer.parseInt(id_empleado.getText());
				int tlfn = Integer.parseInt(tlf.getText());
				int n_ss1 = Integer.parseInt(n_ss.getText());
				String di = direccion.getText();
				String app = apellido.getText();
				String nom = nombre.getText();
				String sec = seccion.getText();
				String pu = puesto.getText();
				String d = dni.getText();
				String e = email.getText();
				Empleado emple = new Empleado(idq, tlfn, n_ss1, di, app, sec, nom, pu, e, d);
				emp.updateData(idq, emple);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(211, 317, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atr\u00E1s");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(211, 351, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Id empleado");
		lblNewLabel.setBounds(157, 14, 64, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1.setBounds(157, 45, 64, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("n ss");
		lblNewLabel_2.setBounds(157, 76, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Direccion");
		lblNewLabel_3.setBounds(157, 107, 64, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Apellido");
		lblNewLabel_4.setBounds(157, 138, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre");
		lblNewLabel_5.setBounds(157, 169, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Seccion");
		lblNewLabel_6.setBounds(157, 200, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Puesto");
		lblNewLabel_7.setBounds(157, 231, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Dni");
		lblNewLabel_8.setBounds(157, 262, 46, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Email");
		lblNewLabel_9.setBounds(157, 293, 46, 14);
		frame.getContentPane().add(lblNewLabel_9);
	}
}