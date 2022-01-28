package hibernate.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@Column(unique = true)
	private String nif;

	@ManyToOne
	private Pais paisNace;
	
	@ManyToMany
	private Collection<Aficion> aficionesGusta;
	
	//=========================
	public Persona() {
		this.nombre="John Doe";
		this.nif="000000A";
		this.aficionesGusta = new ArrayList<Aficion>();
	}
	public Persona(String nombre, String nif, Pais paisNace) {
		this.nombre = nombre;
		this.nif = nif;
		this.paisNace = paisNace;
		paisNace.getPersonasNacidas().add(this);
		this.aficionesGusta = new ArrayList<Aficion>();
	}
	
	//=========================
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Pais getPaisNace() {
		return paisNace;
	}
	public void setPaisNace(Pais paisNace) {
		this.paisNace = paisNace;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	
	public Collection<Aficion> getAficionesGusta() {
		return aficionesGusta;
	}
	public void setAficionesGusta(Collection<Aficion> aficionesGusta) {
		for (Aficion aficion : aficionesGusta) {
			aficion.getPersonasQueGustan().add(this);
			this.aficionesGusta.add(aficion);
		}
		//this.aficionesGusta = aficionesGusta;
	}
	
	
	//=========================
	@Override
	public String toString() {
		return "{"+this.nombre+"/"+nif+"}";
	}
	public void cantar() {
		System.out.println("LALALA - "+this.nif);
	}
	
}
