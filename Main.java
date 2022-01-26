package hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.entities.Persona;
public class Main {
private static void guardarPersona(Persona p) {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session session=sf.openSession();
	
	Transaction t=session.beginTransaction();
    session.save(p);
    t.commit();
}
	private static void crearYGuardarPersona(String nombre) {
		Persona p=new Persona(nombre);
		guardarPersona(p);
		
		System.out.println(p+" ha sido guarado en la BD");
	}
public static void main(String args[]) {
	crearYGuardarPersona("Pepe");
	crearYGuardarPersona("Juan");
}

}