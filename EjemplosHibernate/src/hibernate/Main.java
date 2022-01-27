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
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		return sf.openSession();
	}
private static void guardarPersona(Persona p) {
	Session session=obtenerSesion();
	Transaction t=session.beginTransaction();
    session.save(p);
    t.commit();
}
private static void guardarPais(Pais pais) {
	Session session=obtenerSesion();
	Transaction t=session.beginTransaction();
    session.save(pais);
    t.commit();
}
private static void guardarAficion(Aficion aficionGusta) {
	Session session=obtenerSesion();
	Transaction t=session.beginTransaction();
    session.save(aficionGusta);
    t.commit();
}
private static void actualizarPersona(Persona p) {
	Session session=obtenerSesion();
	Transaction t=session.beginTransaction();
    session.merge(p);
    t.commit();
}
private static void borrarPersona(Persona p) {
	Session session=obtenerSesion();
	Transaction t=session.beginTransaction();
    session.delete(p);
    t.commit();
}
	private static void crearYGuardarPersona(String nombre,String nif,Pais paisNace) {
		Persona p=new Persona(nombre,nif,paisNace);
		guardarPersona(p);
		System.out.println(p+" ha sido guarado en la BD");
	}
	private static Persona recuperarPersonaPorId(Long id) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		return session.get(Persona.class,id);
	}
	private static Pais recuperarPaisPorId(Long id) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		return session.get(Pais.class,id);
	}
	private static List<Persona> recuperarTodasLasPersonas(String nombre){
		Session session=obtenerSesion();
		return session.createQuery("from Persona").list();
	}
	private static List<Persona> recuperarPersonaPorNombre(String nombre){
		Session session=obtenerSesion();
		return session.createQuery("from Persona where nombre = :x").setParameter("x",nombre).list();
	}
	
public static void main(String args[]) {
		
	for(long id=1;id<5;id++) {
	System.out.println(recuperarPersonaPorId(id)+"\n");
	}
	
	List<Persona> personas=recuperarPersonaPorNombre("Pepe");
	for(Persona p:personas) {
		System.out.println(p);
	}
	
	Persona p=recuperarPersonaPorId(1L);
	System.out.println(p);
	System.out.println("=====Actualizado a...======");
	p.setNombre("Jose");
	actualizarPersona(p);
	System.out.println(p);
	
	borrarPersona(p);
	
	Pais pais=new Pais("España");
	guardarPais(pais);
	
	Pais pais2=recuperarPaisPorId(2L);
    crearYGuardarPersona("Fransua","113298A",pais2);
for(Persona p2 :pais.getPersonasNacidas()) {
	System.out.println(p);
}
}

}