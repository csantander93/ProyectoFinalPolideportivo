package SistemaClub;

import java.time.LocalDate;
import java.util.Objects;

public class Socio extends Persona {
	
	private int credencial;
	private LocalDate fechaAlta;
	private String mail;
	
	public Socio(long dni, String nombre, String apellido, LocalDate fechaNacimiento, int credencial,
			LocalDate fechaAlta,String mail) {
		super(dni, nombre, apellido, fechaNacimiento);
		this.credencial = credencial;
		this.fechaAlta = fechaAlta;
		this.mail = mail;
		System.out.println("se agrego socio");
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getCredencial() {
		return credencial;
	}

	public void setCredencial(int credencial) {
		this.credencial = credencial;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public void setSocioCompleto(long dni, String nombre, String apellido, LocalDate fechaNacimiento,
			LocalDate fechaAlta,String mail) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaAlta = fechaAlta;
		this.mail = mail;
		System.out.println("\nSE MODIFICO SOCIO\n");
	}

	@Override
	public String toString() {
		return "Socio: \ncredencial = " + credencial + "\nfechaAlta = " + fechaAlta + "\nmail = "+ mail + super.toString()+"\n\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(credencial, fechaAlta, mail);
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
		Socio other = (Socio) obj;
		return credencial == other.credencial && Objects.equals(fechaAlta, other.fechaAlta)
				&& Objects.equals(mail, other.mail);
	}

}
