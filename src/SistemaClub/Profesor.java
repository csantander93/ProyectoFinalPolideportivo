package SistemaClub;

import java.time.LocalDate;
import java.util.Objects;

public class Profesor extends Persona {
	
	private LocalDate fechaIngreso;
	private String deporte;
	private String nroLegajo;
	
	public Profesor(long dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			String deporte, String nroLegajo) {
		super(dni, nombre, apellido, fechaNacimiento);
		this.fechaIngreso = fechaIngreso;
		this.deporte = deporte;
		this.nroLegajo = nroLegajo;
		System.out.println("\nse agrego profesor/a");
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public String getNroLegajo() {
		return nroLegajo;
	}

	public void setNroLegajo(String nroLegajo) {
		this.nroLegajo = nroLegajo;
	}
	public void setProfesorCompleto(long dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			String deporte) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.deporte = deporte;
		this.nroLegajo = nroLegajo;
		System.out.println("\nSE MODIFICO PROFESOR\n");
	}

	@Override
	public String toString() {
		return "\nProfesor: \nfechaIngreso = " + fechaIngreso + "\ndeporte = " + deporte + "\nnroLegajo = " + nroLegajo + super.toString()+"\n\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(deporte, fechaIngreso, nroLegajo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(deporte, other.deporte) && Objects.equals(fechaIngreso, other.fechaIngreso)
				&& Objects.equals(nroLegajo, other.nroLegajo);
	}


}
