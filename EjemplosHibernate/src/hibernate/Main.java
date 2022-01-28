package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.entities.Aficion;
import hibernate.entities.Pais;
import hibernate.entities.Persona;

public class Main {

	private static Session obtenerSesion() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		return sf.openSession();
	}

	private static void guardarPersona(Persona persona) {
		Session s = obtenerSesion();
		Transaction t = s.beginTransaction();
		s.save(persona);
		t.commit();
	}

	private static void guardarPais(Pais p) {
		Session s = obtenerSesion();
		Transaction t = s.beginTransaction();
		s.save(p);
		t.commit();
	}
	
	private static void guardarAficion(Aficion a) {
		Session s = obtenerSesion();
		Transaction t = s.beginTransaction();
		s.save(a);
		t.commit();
	}

	private static void actualizarPersona(Persona p) {
		Session s = obtenerSesion();
		Transaction t = s.beginTransaction();
		s.merge(p);
		t.commit();
	}

	private static void borrarPersona(Persona p) {
		Session s = obtenerSesion();
		Transaction t = s.beginTransaction();
		s.delete(p);
		t.commit();
	}

	private static void crearYGuardarPersona(String nombre, String nif, Pais pais) {
		Persona persona = new Persona(nombre, nif, pais);
		guardarPersona(persona);
		System.out.println(persona + " ha sido guardado en la BD");
	}

	private static Persona recuperarPersonaPorId(Long id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		return session.get(Persona.class, id);

	}


	private static Aficion recuperarAficionPorId(Long id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		return session.get(Aficion.class, id);

	}
	private static Pais recuperarPaisPorId(Long id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		return session.get(Pais.class, id);

	}

	private static List<Persona> recuperarTodasLasPersonas() {
		Session session = obtenerSesion();
		return session.createQuery("from Persona").list();
	}

	private static List<Persona> recuperarPersonasPorNombre(String nombre) {
		Session session = obtenerSesion();
		return session.createQuery("from Persona where nombre = :x").setParameter("x", nombre).list();
	}

	public static void main(String[] args) {
		Aficion a1 = recuperarAficionPorId(2L);
		Aficion a2 = recuperarAficionPorId(3L);
		Persona p = recuperarPersonaPorId(2L);
		
		p.setAficionesGusta(List.of(a1,a2));
		actualizarPersona(p);
	}
}
