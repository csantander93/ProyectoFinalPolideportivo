package SistemaClub;

import java.util.Objects;

public class Actividad {
	
	private int idActividad;
	private String nombre;
	private Profesor profesorACargo;
	private int limiteDeJugadores;
	
	public Actividad(int idActividad, String nombre, Profesor profesorACargo, int limiteDeJugadores) {
		super();
		this.idActividad = idActividad;
		this.nombre = nombre;
		this.profesorACargo = profesorACargo;
		this.limiteDeJugadores = limiteDeJugadores;
		System.out.println("se agrego actividad");
	}

	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Profesor getProfesorACargo() {
		return profesorACargo;
	}

	public void setProfesorACargo(Profesor profesorACargo) {
		this.profesorACargo = profesorACargo;
	}

	public int getLimiteDeJugadores() {
		return limiteDeJugadores;
	}

	public void setLimiteDeJugadores(int limiteDeJugadores) {
		this.limiteDeJugadores = limiteDeJugadores;
	}
	public void setActividadCompleto(String nombre, Profesor profesorACargo, int limiteDeJugadores) {
		this.nombre = nombre;
		this.profesorACargo = profesorACargo;
		this.limiteDeJugadores = limiteDeJugadores;
		System.out.println("\nSE MODIFICO ACTIVIDAD\n");
	}

	@Override
	public int hashCode() {
		return Objects.hash(idActividad, limiteDeJugadores, nombre, profesorACargo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actividad other = (Actividad) obj;
		return idActividad == other.idActividad && limiteDeJugadores == other.limiteDeJugadores
				&& Objects.equals(nombre, other.nombre) && Objects.equals(profesorACargo, other.profesorACargo);
	}

	@Override
	public String toString() {
		return "Actividad\nidActividad = " + idActividad + "\nNombre = " + nombre + profesorACargo
				+ "Limite de Jugadores = " + limiteDeJugadores + "\n";
	}

}
