package hibernate.entities;

import javax.persistence.Entity;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
private String nombre;

public Persona() {
	this.nombre="Andrei";
}
public Persona(String nombre) {
	this.nombre=nombre;
}

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

@Override
public String toString() {
	return this.nombre;
}

}
