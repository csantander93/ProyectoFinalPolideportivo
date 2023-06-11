package SistemaClub;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.List;

public class Archivo {
	
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
		System.out.println("Integrenates: ");
		System.out.println("");
		mostrarSociosDelClub(club);
		mostrarProfesoresDelClub(club);
		mostrarServiciosDelClub(club);
		mostrarActividadesDelClub(club);
	}
	
	public static void mostrarClubEnArchivo(ClubSantander club) throws FileNotFoundException {
		System.out.println("\n\n----------------------------------------------------------------------------");
		System.out.println("                          DEPORTIVO SANTANDER                                   ");
		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("Integrenates: ");
		System.out.println("");
		mostrarSociosDelClubEnArchivo(club);
		mostrarProfesoresDelClubEnArchivo(club);
		mostrarServiciosDelClubEnArchivo(club);
		mostrarActividadesDelClubEnMismoArchivo(club);
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
	
	public static void mostrarActividadesDelClubEnMismoArchivo(ClubSantander club) throws FileNotFoundException {
		FileOutputStream os = new FileOutputStream("actividades.txt"); 
		PrintStream ps = new PrintStream(os);
		ps.println("\n ----- ACTIVIDADES DEL CLUB ------\n");
		for(Actividad actividad : club.getLstActividades()) {
			ps.println(actividad);
		}
			
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
	
	// Leer desde Archivo
	
	public String leerTxt(String direccion) { // direccion del archivo
		
		String texto = "";
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(direccion));
			String temp = "";
			String bfRead;
			
			while((bfRead = bf.readLine()) != null) {
				temp = temp+bfRead+"\n";
			}
			texto = temp;
		}catch(Exception e) {
			System.err.println("No se encontro archivo");
		}
		return texto;
	}

}
