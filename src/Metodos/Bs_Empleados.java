package Metodos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.TypedQuery;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Clases_POJO.Empleado;

public class Bs_Empleados implements Funciones{
	Session s;
	public void hibernateAcces() {

    	Logger.getLogger("org.hibernate").setLevel(Level.OFF);		

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        s=sf.openSession();
	}

	@Override
	public HashMap getData() {
		// TODO Auto-generated method stub
		hibernateAcces();
		
		HashMap<Integer, Empleado> hm = new HashMap<Integer, Empleado>();
    	
    	TypedQuery q= s.createQuery("from Empleado");
    	List<Empleado> results = q.getResultList();
    	Close();
        Iterator<Empleado> iterador = results.iterator();
        Empleado emp = null;
        while (iterador.hasNext()){
            emp = iterador.next();

        	hm.put(emp.getId(), emp);
        }
        return hm;
	}

	@Override
	public void deleteData(int id) {
		// TODO Auto-generated method stub
		hibernateAcces();
		Transaction tx = s.beginTransaction();
		s.createQuery("delete from Empleado where id = :id").setParameter("id", id).executeUpdate();
		tx.commit();
		Close();
	}

	@Override
	public void insertData(Empleado emp) {
		// TODO Auto-generated method stub
		hibernateAcces();
		s.beginTransaction();
		s.save(emp);
		s.getTransaction().commit();
		Close();
	}

	@Override
	public void updateData(int id, Empleado emp) {
		// TODO Auto-generated method stub
		hibernateAcces();
		s.beginTransaction();
		Query q = s.createQuery("update Empleado set tlf = :tlf, n_ss = :n_ss, direccion = :direccion, apellido = :apellido, seccion = :seccion, nombre = :nombre, puesto = :puesto, dni = :dni, email = :email where id = :id");
		q.setParameter("tlf", emp.getTlf());
		q.setParameter("n_ss", emp.getN_ss());
		q.setParameter("direccion", emp.getDireccion());
		q.setParameter("apellido", emp.getApellido());
		q.setParameter("seccion", emp.getSeccion());
		q.setParameter("nombre", emp.getNombre());
		q.setParameter("puesto", emp.getPuesto());
		q.setParameter("dni", emp.getDni());
		q.setParameter("email", emp.getEmail());
		q.setParameter("id", id);
		q.executeUpdate();
		s.getTransaction().commit();
		Close();
	}

	@Override
	public HashMap searchdata(int id) {
		// TODO Auto-generated method stub
		hibernateAcces();
		HashMap<Integer, Empleado> hm = new HashMap<Integer, Empleado>();
		TypedQuery q = s.createQuery("from Empleado where id = :id").setParameter("id", id);
		List<Empleado> results = q.getResultList();
    	Close();
        Iterator<Empleado> iterador = results.iterator();
        Empleado emp = null;
        while (iterador.hasNext()){
            emp = iterador.next();

        	hm.put(emp.getId(), emp);
        }
		Close();
		return hm;
	}

	@Override
	public void saveData(HashMap<Integer, Empleado> datos) {
		// TODO Auto-generated method stub
		hibernateAcces();
		for (Map.Entry<Integer, Empleado> entry : datos.entrySet()) {
			Empleado emp = new Empleado();
			emp = entry.getValue();
			s.beginTransaction();
			s.save(emp);
			s.getTransaction().commit();
		}
		
		Close();
	}
	public void Close() {
		s.close();
	}

	public DefaultTableModel createTableModel() {
		HashMap<Integer, Empleado> hm = new HashMap<Integer, Empleado>();
		hm = getData();
		DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Datos"}, 0);
		
		for (Entry<Integer, Empleado> entry : hm.entrySet()) {
	        model.addRow(new Object[] { entry.getKey(), entry.getValue() });
	        System.out.println(entry.getValue());
	    }
		return model;
	}
	}


