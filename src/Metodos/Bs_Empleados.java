package Metodos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.TypedQuery;

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
    	
    	TypedQuery q= s.createQuery("from Vuelo order by id");
    	List<Empleado> results = q.getResultList();
    	Close();
        Iterator<Empleado> iterador = results.iterator();
        Empleado v = null;
        while (iterador.hasNext()){
            v = iterador.next();

        	hm.put(v.getId(), v);
        }
        return hm;
	}

	@Override
	public void deleteData(int id) {
		// TODO Auto-generated method stub
		hibernateAcces();
		Transaction tx = s.beginTransaction();
		s.createQuery("delete from Vuelo where id = :id").setParameter("id", id).executeUpdate();
		tx.commit();
		Close();
	}

	@Override
	public void insertData(Vuelo vuelos) {
		// TODO Auto-generated method stub
		hibernateAcces();
		s.beginTransaction();
		s.save(vuelo);
		s.getTransaction().commit();
		Close();
	}

	@Override
	public void updateData(int id, Vuelo vuelos) {
		// TODO Auto-generated method stub
		hibernateAcces();
		s.beginTransaction();
		Query q = s.createQuery("update Vuelo set codigo_vuelo = :codigo, destino = :destino, origen = :origen, fecha = :fecha, hora = :hora, plazas_totales = :plazasTot, plazas_disponibles = :plazasDis where id = :id");
		q.setParameter("codigo", vuelos.getCodigo());
		q.setParameter("destino", vuelos.getDestino());
		q.setParameter("origen", vuelos.getOrigen());
		q.setParameter("fecha", vuelos.getFecha());
		q.setParameter("hora", vuelos.getHora());
		q.setParameter("plazasTot", vuelos.getAsitentosTot());
		q.setParameter("plazasDis", vuelos.getAsientosDis());
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
		TypedQuery q = s.createQuery("from Vuelo where id = :id").setParameter("id", id);
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
	public void saveData(HashMap<Integer, Empleados> datos) {
		// TODO Auto-generated method stub
		hibernateAcces();
		for (Map.Entry<Integer, Empleado> entry : datos.entrySet()) {
			Empleado v = new Empleado();
			v = entry.getValue();
			s.beginTransaction();
			s.save(v);
			s.getTransaction().commit();
		}
		
		Close();
	}
	public void Close() {
		s.close();
	}

}
