package Metodos;

import java.util.HashMap;

public interface Funciones {
	public HashMap getData();

	public void deleteData(int id);

	public void insertData(Vuelo vuelos);

	public void updateData(int id, Vuelo vuelos);

	public HashMap searchdata(int id);

	public void saveData(HashMap datos);
}
