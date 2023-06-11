package SistemaClub;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ClubSantander {
	
	private String cuit;
	private String nombre;
	private String direccion;
	private List<Actividad> lstActividades;
	private List<Servicio> lstServicios;
	private List<Socio> lstSocios;
	private List<Profesor> lstProfesores;
	
	public ClubSantander(String cuit, String nombre, String direccion) {
		super();
		this.cuit = cuit;
		this.nombre = nombre;
		this.direccion = direccion;
		this.lstActividades = new ArrayList<Actividad>();
		this.lstServicios = new ArrayList<Servicio>();
		this.lstSocios = new ArrayList<Socio>();
		this.lstProfesores = new ArrayList<Profesor>();
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Actividad> getLstActividades() {
		return lstActividades;
	}
	public List<Servicio> getLstServicios() {
		return lstServicios;
	}
	public List<Socio> getLstSocios() {
		return lstSocios;
	}
	public List<Profesor> getLstProfesores() {
		return lstProfesores;
	}
	
	public boolean agregarServicio(Actividad nombreServicio, float precioSerPorHora,
			LocalDate fechaAlquiler, LocalTime horaDesde, LocalTime horaHasta, Socio cliente, int cantPersonas) throws Exception {
		
		int id = 1;
		if(lstServicios.size()>0) {
			id = lstServicios.get(lstServicios.size()-1).getCodigoSevicio()+1;
		}
		if(verificarDisponibilidad(nombreServicio, fechaAlquiler, horaDesde, horaHasta)) {
			throw new Exception ("El servicio se encuentra ocupado en ese horario");
		}
		return lstServicios.add(new Servicio(id, nombreServicio, precioSerPorHora, fechaAlquiler, horaDesde, horaHasta, cliente, cantPersonas));
		
	}
	
	public boolean agregarServicio() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nIngrese algun nombre de la lista de actividades: \n");
		Actividad nombreServicio = traerActividad(sc.next());
		System.out.println("\nIngrese fecha de alquiler: AAAA/MM/DD");
		System.out.println("Ingrese anio:");
		int anio = sc.nextInt();
		System.out.println("Ingrese mes:");
		int mes = sc.nextInt();
		System.out.println("Ingrese dia:");
		int dia = sc.nextInt();
		LocalDate fechaAlquiler = LocalDate.of(anio, mes, dia);
		System.out.println("\nIngrese hora desde: \n");
		int hora = sc.nextInt();
		int minutos = 0;
		LocalTime horaDesde = LocalTime.of(hora, minutos);
		System.out.println("\nIngrese hora hasta: \n");
		hora = sc.nextInt();
		LocalTime horaHasta = LocalTime.of(hora, minutos);
		System.out.println("\nIngrese costo del servicio por hora: \n");
		float precioSerPorHora = sc.nextFloat();
		System.out.println("\nIngrese DNI del socio que solicita el servicio: \n");
		Socio cliente = traerSocioPorDni(sc.nextInt());
		System.out.println("\nIngrese cantidad de personas que van a jugar: ");
		int cantPersonas = sc.nextInt();
		
		int id = 1;
		if(lstServicios.size()>0) {
			id = lstServicios.get(lstServicios.size()-1).getCodigoSevicio()+1;
		}
		if(verificarDisponibilidad(nombreServicio, fechaAlquiler, horaDesde, horaHasta)) {
			throw new Exception ("El servicio se encuentra ocupado en ese horario");
		}
		return lstServicios.add(new Servicio(id, nombreServicio, precioSerPorHora, fechaAlquiler, horaDesde, horaHasta, cliente, cantPersonas));
		
	}
	
	public boolean verificarDisponibilidad(Actividad nombreServicio, LocalDate fechaAlquiler, LocalTime horaDesde, LocalTime horaHasta) throws Exception {
		
		boolean ocupado = false;
		
		for(Servicio s : lstServicios) {
			
			if((nombreServicio.equals(s.getNombreServicio()) && fechaAlquiler.equals(s.getFechaAlquiler())) &&
					(horaDesde.equals(s.getHoraDesde()) || horaHasta.equals(s.getHoraHasta()) || horaDesde.isAfter(s.getHoraDesde())
					&& horaHasta.isBefore(s.getHoraHasta()))) {
				ocupado = true;
			}
		}
		return ocupado;
	}
	
	public boolean agregarSocio(long dni, String nombre, String apellido, LocalDate fechaNacimiento,
			LocalDate fechaAlta, String mail)throws Exception {
		
		Socio socioAux = traerSocioPorDni(dni);
		if(socioAux != null) {
			throw new Exception("El/La cliente que desea asociar ya existe\n");
		}
		int id=1;
		if(lstSocios.size()>0) {
			id = lstSocios.get(lstSocios.size()-1).getCredencial()+1;
		}
		return lstSocios.add(new Socio(dni, nombre, apellido, fechaNacimiento, id, fechaAlta, mail));
		
	}
	
	public boolean agregarSocio()throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nIngrese nombre: \n");
		String nombre = sc.next();
		System.out.println("\nIngrese apellido: \n");
		String apellido = sc.next();
		System.out.println("\nIngrese dni: \n");
		long dni = sc.nextLong();
		int anio,mes,dia;
		System.out.println("\nIngrese fecha de nacimiento AAAA/MM/DD: \n");
		System.out.println("Ingrese anio:");
		anio = sc.nextInt();
		System.out.println("Ingrese mes:");
		mes = sc.nextInt();
		System.out.println("Ingrese dia:");
		dia = sc.nextInt();
		LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
		LocalDate fechaAlta = LocalDate.now();
		System.out.println("\nIngrese mail");
		String mail = sc.next();
		
		Socio socioAux = traerSocioPorDni(dni);
		if(socioAux != null) {
			throw new Exception("El/La cliente que desea asociar ya existe\n");
		}
		int id=1;
		if(lstSocios.size()>0) {
			id = lstSocios.get(lstSocios.size()-1).getCredencial()+1;
		}
		return lstSocios.add(new Socio(dni, nombre, apellido, fechaNacimiento, id, fechaAlta, mail));
		
	}
	
	public boolean eliminarSocio(int credencial)throws Exception {
		Socio socEliminar = traerSocio(credencial);
		if(socEliminar == null) {
			throw new Exception("El/La socio/a que desea eliminar no existe");
		}
		System.out.println("Se elimino el/la socio/a: "+traerSocio(credencial).nombre+" "+traerSocio(credencial).apellido);
		return lstSocios.remove(socEliminar);
	}
	
	public boolean agregarProfesor(long dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			String deporte, String nroLegajo)throws Exception{
		
		Profesor profAux = traerProfesor(nroLegajo);
		if(profAux != null) {
			throw new Exception("El/La profesor/a ya se encuentra registrado/a\n");
		}
		return lstProfesores.add(new Profesor(dni, nombre, apellido, fechaNacimiento, fechaIngreso, deporte, nroLegajo));
	}
	
	public boolean agregarProfesor()throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nIngrese nombre: \n");
		String nombre = sc.next();
		System.out.println("\nIngrese apellido: \n");
		String apellido = sc.next();
		System.out.println("\nIngrese dni: \n");
		long dni = sc.nextLong();
		int anio,mes,dia;
		System.out.println("\nIngrese fecha de nacimiento AAAA/MM/DD: \n");
		System.out.println("Ingrese año:");
		anio = sc.nextInt();
		System.out.println("Ingrese mes:");
		mes = sc.nextInt();
		System.out.println("Ingrese dia:");
		dia = sc.nextInt();
		LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
		LocalDate fechaIngreso = LocalDate.now();
		System.out.println("\nIngrese deporte que imparte: \n");
		String deporte = sc.next();
		System.out.println("\nIngrese nro de legajo: \n");
		String nroLegajo = sc.next();
		
		
		Profesor profAux = traerProfesor(nroLegajo);
		if(profAux != null) {
			throw new Exception("El profesor/a ya se encuentra registrado\n");
		}
		return lstProfesores.add(new Profesor(dni, nombre, apellido, fechaNacimiento, fechaIngreso, deporte, nroLegajo));
	}
	
	public boolean eliminarProfesor(String nroLegajo)throws Exception {
		Profesor profEliminar = traerProfesor(nroLegajo);
		if(profEliminar == null) {
			throw new Exception("El profesor/a que desea eliminar no existe");
		}
		System.out.println("Se elimino el profesor/a: "+traerProfesor(nroLegajo).nombre+" "+traerProfesor(nroLegajo).apellido);
		return lstProfesores.remove(profEliminar);
	}
	
	public boolean eliminarActividad(String nombre) throws Exception{
		Actividad actEliminar = traerActividad(nombre);
		if(actEliminar == null) {
			throw new Exception("La actividad que desea eliminar no esta cargada en el club");
		}
		System.out.println("Se elimino la actividad: "+nombre+" de la lista de actividades");
		return lstActividades.remove(actEliminar);
	}
	
	public boolean agregarActividad(String nombre, Profesor profesorACargo, int limiteDeJugadores)throws Exception {
		Actividad actAux = traerActividad(nombre);
		if(actAux != null) {
			throw new Exception("La actividad ya esta agregada en la lista\n");
		}
		int id=1;
		if(lstActividades.size()>0) {
			id = lstActividades.get(lstActividades.size()-1).getIdActividad()+1;
		}
		
		return lstActividades.add(new Actividad(id, nombre, profesorACargo, limiteDeJugadores));
	}
	
	public boolean agregarActividad()throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nIngrese nombre de la actividad");
		String nombre = sc.next();
		System.out.println("\nIngrese Legajo del profesor que imparte dicha actividad");
		Profesor profesorACargo = traerProfesor(sc.next());
		System.out.println("\nIngrese limite de jugadores para la actividad");
		int limiteDeJugadores = sc.nextInt();
		Actividad actAux = traerActividad(nombre);
		if(actAux != null) {
			throw new Exception("La actividad ya esta agregada en la lista\n");
		}
		int id=1;
		if(lstActividades.size()>0) {
			id = lstActividades.get(lstActividades.size()-1).getIdActividad()+1;
		}
		
		return lstActividades.add(new Actividad(id, nombre, profesorACargo, limiteDeJugadores));
	}
	
	public void modificarActividad(String nombre) throws Exception {
		Actividad actAux = traerActividad(nombre);
		if(actAux != null) {
			throw new Exception("La actividad que desea agregar no existe");
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("\nIngrese Legajo del profesor que imparte dicha actividad");
		Profesor profesorACargo = traerProfesor(sc.next());
		System.out.println("\nIngrese limite de jugadores para la actividad");
		int limiteDeJugadores = sc.nextInt();
		actAux.setActividadCompleto(nombre, profesorACargo, limiteDeJugadores);
	}
	
	public Profesor traerProfesor(String nroLegajo) {
		
		Profesor profAux = null;
		int i=0;
		while(i<lstProfesores.size() && profAux == null) {
			if(nroLegajo.equalsIgnoreCase(lstProfesores.get(i).getNroLegajo())) {
				profAux = lstProfesores.get(i);
			}
			i++;
		}
		return profAux;
	}
	
	public void modificarSocio(int credencial) throws Exception {
		Socio socioAux = traerSocio(credencial);
		if(socioAux == null) {
			throw new Exception("El socio que desea modificar no existe");
		}
		System.out.println("\nModificando socio: "+socioAux);
		Scanner sc = new Scanner(System.in);
		System.out.println("\nIngrese nombre: \n");
		String nombre = sc.next();
		System.out.println("\nIngrese apellido: \n");
		String apellido = sc.next();
		System.out.println("\nIngrese dni: \n");
		long dni = sc.nextLong();
		int anio,mes,dia;
		System.out.println("\nIngrese fecha de nacimiento AAAA/MM/DD: \n");
		anio = sc.nextInt();
		mes = sc.nextInt();
		dia = sc.nextInt();
		LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
		LocalDate fechaAlta = LocalDate.now();
		System.out.println("\nIngrese mail");
		String mail = sc.next();
		
		socioAux.setSocioCompleto(dni, nombre, apellido, fechaNacimiento, fechaAlta, mail);
		System.out.println("\nSe modifico el socio: "+socioAux+"\n");
		
	}
	
	public void modificarProfesor(String legajo)throws Exception {
		Profesor profAux = traerProfesor(legajo);
		if(profAux != null) {
			throw new Exception("El profesor que desea agregar no existe");
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("\nIngrese nombre: \n");
		String nombre = sc.next();
		System.out.println("\nIngrese apellido: \n");
		String apellido = sc.next();
		System.out.println("\nIngrese dni: \n");
		long dni = sc.nextLong();
		int anio,mes,dia;
		System.out.println("\nIngrese fecha de nacimiento AAAA/MM/DD: \n");
		anio = sc.nextInt();
		mes = sc.nextInt();
		dia = sc.nextInt();
		LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
		LocalDate fechaIngreso = LocalDate.now();
		System.out.println("\nIngrese deporte que imparte: \n");
		String deporte = sc.next();
		
		profAux.setProfesorCompleto(dni, nombre, apellido, fechaNacimiento, fechaIngreso, deporte);
	}
	
	public void modificarServicio(int codigoServicio) throws Exception {
		Servicio servAux = traerServicioPorCodigo(codigoServicio);
		if(servAux != null) {
			throw new Exception("El Servicio que desea agregar no existe");
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("\nIngrese nombre del servicio: \n");
		Actividad nombreServicio = traerActividad(sc.next());
		System.out.println("\nIngrese fecha de alquiler: AAAA/MM/DD");
		int anio = sc.nextInt();
		int mes = sc.nextInt();
		int dia = sc.nextInt();
		LocalDate fechaAlquiler = LocalDate.of(anio, mes, dia);
		System.out.println("\nIngrese hora desde: \n");
		int hora = sc.nextInt();
		int minutos = 0;
		LocalTime horaDesde = LocalTime.of(hora, minutos);
		System.out.println("\nIngrese hora hasta: \n");
		hora = sc.nextInt();
		LocalTime horaHasta = LocalTime.of(hora, minutos);
		System.out.println("\nIngrese costo del servicio por hora: \n");
		float precioSerPorHora = sc.nextFloat();
		System.out.println("\nIngrese DNI del socio que solicita el servicio: \n");
		Socio cliente = traerSocioPorDni(sc.nextInt());
		System.out.println("\nIngrese cantidad de personas que van a jugar: ");
		int cantPersonas = sc.nextInt();
		
		if(verificarDisponibilidad(nombreServicio, fechaAlquiler, horaDesde, horaHasta)) {
			throw new Exception ("El servicio se encuentra ocupado en ese horario");
		}
		
		servAux.setServicioCompleto(nombreServicio, precioSerPorHora, fechaAlquiler, horaDesde, horaHasta, cliente, cantPersonas);
	}

	public Socio traerSocio(int credencial) {
		Socio socioAux = null;
		int i=0;
		while(i<lstSocios.size() && socioAux == null) {
			if(credencial == lstSocios.get(i).getCredencial()) {
				socioAux = lstSocios.get(i);
			}
			i++;
		}
		return socioAux;
	}
	
	public Socio traerSocioPorDni(long dni) {
		Socio socioAux = null;
		int i=0;
		while(i<lstSocios.size() && socioAux == null) {
			if(dni == lstSocios.get(i).getDni()) {
				socioAux = lstSocios.get(i);
			}
			i++;
		}
		return socioAux;
	}
	
	
	public Actividad traerActividad(String nombreActividad) {
		Actividad actividadAux = null;
		int i=0;
		while(i<lstActividades.size() && actividadAux == null) {
			if(nombreActividad.equalsIgnoreCase(lstActividades.get(i).getNombre())) {
				actividadAux = lstActividades.get(i);
			}
			i++;
		}
		return actividadAux;

	}
	
	public Servicio traerServicio(String nombreServicio) {
		Servicio servAux = null;
		int i=0;
		while(i<lstServicios.size() && servAux == null) {
			if(nombreServicio.equalsIgnoreCase(lstServicios.get(i).getNombreServicio().getNombre())) {
				servAux = lstServicios.get(i);
			}
			i++;
		}
		return servAux;
	}
	
	public Servicio traerServicioPorCodigo(int codigoServicio) {
		Servicio servAux = null;
		int i=0;
		while(i<lstServicios.size() && servAux == null) {
			if(codigoServicio == lstServicios.get(i).getCodigoSevicio()) {
				servAux = lstServicios.get(i);
			}
			i++;
		}
		return servAux;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cuit, direccion, lstActividades, lstProfesores, lstServicios, lstSocios, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClubSantander other = (ClubSantander) obj;
		return Objects.equals(cuit, other.cuit) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(lstActividades, other.lstActividades)
				&& Objects.equals(lstProfesores, other.lstProfesores)
				&& Objects.equals(lstServicios, other.lstServicios) && Objects.equals(lstSocios, other.lstSocios)
				&& Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		return "ClubSantander\nCUIT = " + cuit + "\nnombre = " + nombre + "\ndireccion = " + direccion + "\nLISTA DE ACTIVIDADES = \n"
				+ lstActividades + "\nLISTA DE SERVICIOS = \n" + lstServicios + "\nLISTA DE SOCIOS = \n" + lstSocios + "\nLISTA DE PROFESORES = \n"
				+ lstProfesores;
	}
	
	public float calcularRecaudacion(LocalDate desde, LocalDate hasta) {
		float total = 0;
		for(Servicio c: lstServicios) {
			if((desde.equals(c.getFechaAlquiler()) || desde.isAfter(c.getFechaAlquiler())) || (hasta.equals(c.getFechaAlquiler())
					|| hasta.isAfter(c.getFechaAlquiler())))
			total += c.costoFinal();
		}
		return total;
	}
	
	public float calcularRecaudacion() {
		Scanner sc = new Scanner(System.in);
		int anio,mes,dia;
		System.out.println("Ingrese desde que fecha desea calcular: AAAA/MM/DD\n");
		System.out.println("Ingrese anio\n");
		anio = sc.nextInt();
		System.out.println("Ingrese mes\n");
		mes = sc.nextInt();
		System.out.println("Ingrese dia\n");
		dia = sc.nextInt();
		LocalDate desde = LocalDate.of(anio, mes, dia);
		System.out.println("Ingrese hasta que fecha desea calcular: AAAA/MM/DD\n");
		System.out.println("Ingrese anio\n");
		anio = sc.nextInt();
		System.out.println("Ingrese mes\n");
		mes = sc.nextInt();
		System.out.println("Ingrese dia\n");
		dia = sc.nextInt();
		LocalDate hasta = LocalDate.of(anio, mes, dia);
		float total = 0;
		for(Servicio c: lstServicios) {
			if((desde.equals(c.getFechaAlquiler()) || desde.isAfter(c.getFechaAlquiler())) || (hasta.equals(c.getFechaAlquiler())
					|| hasta.isAfter(c.getFechaAlquiler())))
			total += c.costoFinal();
		}
		return total;
	}
}
