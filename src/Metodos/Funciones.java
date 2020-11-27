package Metodos;

import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

import Clases_POJO.Empleado;

public interface Funciones {
	public HashMap getData();

	public void deleteData(int id);

	public void insertData(Empleado dato);

	public void updateData(int id, Empleado dato);

	public HashMap searchdata(int id);
	
	public DefaultTableModel createTableModel();
}
