package SistemaClub;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Servicio {
	
	private int codigoSevicio;
	private Actividad nombreServicio;
	private float precioSerPorHora;
	private LocalDate fechaAlquiler;
	private LocalTime horaDesde;
	private LocalTime horaHasta;
	private Socio cliente;
	private int cantPersonas;
	
	public Servicio(int codigoSevicio, Actividad nombreServicio, float precioSerPorHora,
			LocalDate fechaAlquiler, LocalTime horaDesde, LocalTime horaHasta, Socio cliente, int cantPersonas) throws Exception {
		super();
		this.codigoSevicio = codigoSevicio;
		this.nombreServicio = nombreServicio;
		this.precioSerPorHora = precioSerPorHora;
		this.fechaAlquiler = fechaAlquiler;
		this.setHoraDesde(horaDesde);
		this.setHoraHasta(horaHasta);
		this.cliente = cliente;
		this.setCantPersonas(cantPersonas);
		System.out.println("se reservo servicio");
	}

	public int getCodigoSevicio() {
		return codigoSevicio;
	}

	public void setCodigoSevicio(int codigoSevicio) {
		this.codigoSevicio = codigoSevicio;
	}

	public Actividad getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(Actividad nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public float getPrecioSerPorHora() {
		return precioSerPorHora;
	}

	public void setPrecioSerPorHora(float precioSerPorHora) {
		this.precioSerPorHora = precioSerPorHora;
	}

	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(LocalDate fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	public LocalTime getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(LocalTime horaDesde) throws Exception {
		if(horaDesde.isBefore(LocalTime.of(8, 00))) {
			throw new Exception("El horario de reserva es incorrecto\nHorarios de reserva son de 8:00am a 23:00pm");
		}
		this.horaDesde = horaDesde;
	}

	public LocalTime getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(LocalTime horaHasta)throws Exception {
		if(horaHasta.isAfter(LocalTime.of(23, 00)) || horaHasta.isBefore(horaDesde)) {
			throw new Exception("El horario de reserva es incorrecto\nLa hora debe estar despues del horario de reserva\nRECUERDE: Horarios de reserva son de 8:00am a 23:00pm\n");
		}else {
			this.horaHasta = horaHasta;
		}
	}

	@Override
	public String toString() {
		return "Servicio codigoSevicio = " + codigoSevicio + ", nombreServicio = " + nombreServicio + "precioSerPorHora = "
				+ precioSerPorHora + ", fechaAlquiler=" + fechaAlquiler + ", horaDesde=" + horaDesde + ", horaHasta="
				+ horaHasta + "\ncliente = " + cliente + ", cantPersonas=" + cantPersonas + "]";
	}

	public Socio getCliente() {
		return cliente;
	}

	public void setCliente(Socio cliente) {
		this.cliente = cliente;
	}
	
	public int getCantPersonas() {
		return cantPersonas;
	}
	
	public void setCantPersonas(int cantPersonas)throws Exception {
		if(cantPersonas <= nombreServicio.getLimiteDeJugadores()) {
			this.cantPersonas = cantPersonas;
		}else {
			throw new Exception("La cantidad de personas supera el limite permitido por la actividad\n");
		}
	}
	
	public void setServicioCompleto(Actividad nombreServicio, float precioSerPorHora,
			LocalDate fechaAlquiler, LocalTime horaDesde, LocalTime horaHasta, Socio cliente, int cantPersonas) throws Exception {
		this.nombreServicio = nombreServicio;
		this.precioSerPorHora = precioSerPorHora;
		this.fechaAlquiler = fechaAlquiler;
		this.setHoraDesde(horaDesde);
		this.setHoraHasta(horaHasta);
		this.cliente = cliente;
		this.setCantPersonas(cantPersonas);
		System.out.println("\nSe modifico el servicio correctamente\n");
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, codigoSevicio, fechaAlquiler, horaDesde, horaHasta, nombreServicio,
				precioSerPorHora);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		return Objects.equals(cliente, other.cliente) && codigoSevicio == other.codigoSevicio
				&& Objects.equals(fechaAlquiler, other.fechaAlquiler) && Objects.equals(horaDesde, other.horaDesde)
				&& Objects.equals(horaHasta, other.horaHasta) && Objects.equals(nombreServicio, other.nombreServicio)
				&& Float.floatToIntBits(precioSerPorHora) == Float.floatToIntBits(other.precioSerPorHora);
	}
	
	public int horasAlquiladas() {
		return horaHasta.getHour()-horaDesde.getHour();
	}
	
	public float costoFinal() {
		return horasAlquiladas()*precioSerPorHora;
	}
	
}
