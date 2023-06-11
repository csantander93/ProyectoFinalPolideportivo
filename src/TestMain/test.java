package TestMain;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

import SistemaClub.ClubSantander;
import SistemaClub.Actividad;
import SistemaClub.Profesor;
import SistemaClub.Servicio;
import SistemaClub.Socio;

public class test {

	public static void main(String[] args) {
		
		///creo el club
		ClubSantander club = new ClubSantander("20373525643", "Santander", "Malvinas Argentinas 743");
		///agregamos a los siguientes profesores
		try{
			club.agregarProfesor(37352564, "Cristian", "Santander", LocalDate.of(1993, 2, 20), LocalDate.now(), "Futbol", "11111");
			club.agregarProfesor(11111111, "Marcos", "Rojas", LocalDate.of(1998, 5, 6), LocalDate.now(), "Handball", "22222");
			club.agregarProfesor(22222222, "Vanesa", "Sanchez", LocalDate.of(2000, 3, 10), LocalDate.now(), "Volleyball", "33333");
			club.agregarProfesor(33333333, "Yanet", "Mendoza", LocalDate.of(1990, 3, 11), LocalDate.now(), "Basquet", "44444");
			club.agregarProfesor(33333333, "Soledad", "Marquez", LocalDate.of(2001, 4, 22), LocalDate.now(), "Salon", "55555");
		}catch(Exception e) {
			System.out.println("");
			System.out.println(e.getMessage());
		}
		///si intento agregar uno que ya existe me arroja error
		try{
			club.agregarProfesor(37352564, "Cristian", "Santander", LocalDate.of(1993, 2, 20), LocalDate.now(), "Futbol", "11111");
		}catch(Exception e) {
			System.out.println("");
			System.out.println(e.getMessage());
		}
		///agrego las actividades en este caso el predio cuenta con 4 tipos de actividades
		try {
			club.agregarActividad("Futbol", club.traerProfesor("11111"), 10);
			club.agregarActividad("Handball", club.traerProfesor("22222"), 14);
			club.agregarActividad("Volleyball", club.traerProfesor("33333"), 12);
			club.agregarActividad("Basquet", club.traerProfesor("44444"), 10);
			club.agregarActividad("Salon", club.traerProfesor("55555"), 60);
		}catch(Exception e) {
			System.out.println("");
			System.out.println(e.getMessage());
		}
		//intento agregar una actividad que ya existe
		try {
			club.agregarActividad("Futbol", club.traerProfesor("11111"), 10);
		}catch(Exception e) {
			System.out.println("");
			System.out.println(e.getMessage());
		}
		///agrego los siguientes socios
		try {
			club.agregarSocio(12345678, "Santiago", "Pereyra", LocalDate.of(1991, 2, 25), LocalDate.now(), "santiP@gmail.com");
			club.agregarSocio(11111111, "Cristian", "Martinez", LocalDate.of(1990, 3, 15), LocalDate.now(), "cMartinez@gmail.com");
			club.agregarSocio(22222222, "Valeria", "Solano", LocalDate.of(1989, 4, 5), LocalDate.now(),"valeSola@gmail.com");
			club.agregarSocio(33333333, "Juan", "Marcos", LocalDate.of(1994, 5, 21), LocalDate.now(),"JMarcos@hotmail.com");
			club.agregarSocio(44444444, "Ricardo", "Arjona", LocalDate.of(1995, 5, 20), LocalDate.now(), "rickyAr@yahoo.com.ar");
			club.agregarSocio(55555555, "Armando", "Gimenez", LocalDate.of(1999, 1, 13), LocalDate.now(), "armaGi@gmail.com");
			club.agregarSocio(66666666, "Lorena", "Mendoza", LocalDate.of(2002, 12, 14), LocalDate.now(), "LoreMen@hotmail.com.ar");
			club.agregarSocio(77777777, "Rosario", "Vera", LocalDate.of(2001, 10, 10), LocalDate.now(), "RosaVe@gmail.com");
		}catch(Exception e) {
			System.out.println("");
			System.out.println(e.getMessage());
		}
		///intento agreagar un socio ya existente
		try {
			club.agregarSocio(12345678, "Santiago", "Pereyra", LocalDate.of(1991, 2, 25), LocalDate.now(),"santiP@gmail.com");
		}catch(Exception e) {
			System.out.println("");
			System.out.println(e.getMessage());
		}
		
		///realizo la carga de algun servicio siempre en horario de apertura entre las 8:00am y las 23:00pm
		try {
			club.agregarServicio(club.traerActividad("Futbol"), 1000, LocalDate.of(2022, 1, 1), LocalTime.of(10, 00), LocalTime.of(11, 00), club.traerSocio(1), 10);
			club.agregarServicio(club.traerActividad("Handball"), 900, LocalDate.of(2022, 1, 1), LocalTime.of(10, 00), LocalTime.of(11, 00), club.traerSocio(1), 14);
			club.agregarServicio(club.traerActividad("volleyball"), 800, LocalDate.of(2022, 1, 1), LocalTime.of(10, 00), LocalTime.of(11, 00), club.traerSocio(1), 12);
			club.agregarServicio(club.traerActividad("Futbol"), 1000, LocalDate.of(2022, 1, 1), LocalTime.of(12, 00), LocalTime.of(13, 00), club.traerSocio(2), 10);
			club.agregarServicio(club.traerActividad("Basquet"), 1200, LocalDate.of(2022, 1, 1), LocalTime.of(12, 00), LocalTime.of(13, 00), club.traerSocio(3), 10);
			club.agregarServicio(club.traerActividad("Salon"), 10000, LocalDate.of(2022, 1, 1), LocalTime.of(15, 00), LocalTime.of(20, 00), club.traerSocio(4), 50);
			//en este caso al querer reservar en un horario ya registrado lanzara un error de ocupado
			club.agregarServicio(club.traerActividad("Futbol"), 1000, LocalDate.of(2022, 1, 1), LocalTime.of(12, 00), LocalTime.of(13, 00), club.traerSocio(3), 10);
		}catch(Exception e) {
			System.out.println("");
			System.out.println(e.getMessage());
		}
		
		try {
			///vemos que probando con otra fecha este si permite la carga
			club.agregarServicio(club.traerActividad("Futbol"), 1000, LocalDate.of(2022, 1, 2), LocalTime.of(12, 00), LocalTime.of(13, 00), club.traerSocio(3), 10);
		}catch(Exception e) {
			System.out.println("");
			System.out.println(e.getMessage());
		}
		
		try {
			///vemos que probando con otra fecha este si permite la carga
			club.agregarServicio(club.traerActividad("Futbol"), 1000, LocalDate.of(2022, 1, 3), LocalTime.of(8, 00), LocalTime.of(9, 00), club.traerSocio(3), 10);
		}catch(Exception e) {
			System.out.println("");
			System.out.println(e.getMessage());
		}
		
		try {
			///si intendo cargar en horario no permitido arroja error
			club.agregarServicio(club.traerActividad("Futbol"), 1000, LocalDate.of(2022, 1, 3), LocalTime.of(7, 00), LocalTime.of(8, 00), club.traerSocio(3), 10);
		}catch(Exception e) {
			System.out.println("");
			System.out.println(e.getMessage());
		}
		
		//muestro la lista de socios
		System.out.println(club.getLstSocios());
		try{
			//elimino el socio con carnet 1
			club.eliminarSocio(1);
		}catch(Exception e) {
			System.out.println("");
			System.out.println(e.getMessage());
		}
		System.out.println("Lista con socio 11111 Ya eliminado\n");
		System.out.println(club.getLstSocios());
		
		try {
			//elimino profesor de futbol
			club.eliminarProfesor("11111");
		}
			catch(Exception e) {
				System.out.println(e.getMessage());
		}
		//muestro solo los profesores
		System.out.println(club.getLstProfesores());
		
		//muestro todo el sistema en general
		//System.out.println("");
		//System.out.println(club);
		//calculo la recaudacion de una fecha a otra
		System.out.println("Recaudado desde 1/1 al 3/1: $"+club.calcularRecaudacion(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 3)));

		try {
			mostrarProfesoresDelClubEnArchivo(club);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			mostrarSociosDelClubEnArchivo(club);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			mostrarServiciosDelClubEnArchivo(club);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			mostrarActividadesDelClubEnArchivo(club);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
//  MOSTRAR
//----------------------------------------
	
	public static void mostrarSociosDelClub(ClubSantander club) {
		System.out.println("\n ----- SOCIOS DEL CLUB -----\n");
		mostrarSocios(club.getLstSocios());
		System.out.println("\n----------------------------------\n");
			
	}
	
	public static void mostrarSocios(List<Socio> socios) {
		for(Socio socio : socios) {
			System.out.println(socio);
		}
	}
	
	public static void mostrarServiciosDelClub(ClubSantander club) {
		System.out.println("\n ----- SERVICIOS DEL CLUB -----\n");
		for(Servicio servicio : club.getLstServicios()) {
			System.out.println(servicio);
		}
	
		System.out.println("\n----------------------------------\n");
	}
	
	public static void mostrarProfesoresDelClub(ClubSantander club) {
		System.out.println("\n ----- PROFESORES DEL CLUB -----\n");
		for(Profesor profesor : club.getLstProfesores()) {
			System.out.println(profesor);
		}
	
		System.out.println("\n----------------------------------\n");
	}
	
	public static void mostrarActividadesDelClub(ClubSantander club) {
		System.out.println("\n\n   ACTIVIDADES DEL CLUB                 ");
		for(Actividad actividad : club.getLstActividades()) {
			mostrarActividad(actividad);
	 }
	}
	
	public static void mostrarActividad(Actividad actividad) {
		System.out.println("\n\n-------------------------- "+ actividad.getNombre().toUpperCase() +" -----------------------------\n");
		System.out.println(actividad);
		 
	}
	
	public static void mostrarClub(ClubSantander club) {
		System.out.println("\n\n----------------------------------------------------------------------------");
		System.out.println("                          DEPORTIVO SANTANDER                                   ");
		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("Integrenates : ");
		System.out.println("");
		mostrarSociosDelClub(club);
		mostrarProfesoresDelClub(club);
		mostrarServiciosDelClub(club);
		mostrarActividadesDelClub(club);
	}
	
	public static void mostrarProfesoresDelClubEnArchivo(ClubSantander club) throws FileNotFoundException {
		FileOutputStream os = new FileOutputStream("profesores.txt");
		PrintStream ps = new PrintStream(os);
		
		ps.println("\n ----- PROFESORES DEL CLUB -----\n");
		for(Profesor profesor : club.getLstProfesores()) {
			ps.println(profesor);
		}
	
		ps.println("\n----------------------------------\n");
	}
	
	public static void mostrarSociosDelClubEnArchivo(ClubSantander club) throws FileNotFoundException {
		FileOutputStream os = new FileOutputStream("sociosDelClub.txt");
		PrintStream ps = new PrintStream(os);
		ps.println("\n ----- SOCIOS DEL CLUB -----\n");
		
		for(Socio socio : club.getLstSocios()) {
			ps.println(socio);
		}
		ps.println("\n----------------------------------\n");
			
	}
	
	public static void mostrarServiciosDelClubEnArchivo(ClubSantander club) throws FileNotFoundException {
		FileOutputStream os = new FileOutputStream("servicios.txt");
		PrintStream ps = new PrintStream(os);
		ps.println("\n ----- SERVICIOS DEL CLUB -----\n");
		for(Servicio servicio : club.getLstServicios()) {
			ps.println(servicio);
		}
	
		ps.println("\n----------------------------------\n");
	}
	
	public static void mostrarActividadesDelClubEnArchivo(ClubSantander club) throws FileNotFoundException {
		FileOutputStream os; 
		PrintStream ps;
		for(Actividad actividad : club.getLstActividades()) {
			os = new FileOutputStream(actividad.getNombre()+".txt");
			ps = new PrintStream(os);
			ps.println("\n\n-------------------------- ACTIVIDAD "+ actividad.getNombre().toUpperCase() +" -----------------------------\n");
			ps.println(actividad);
		}
			
	 }
}

