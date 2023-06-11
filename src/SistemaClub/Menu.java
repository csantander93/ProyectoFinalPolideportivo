package SistemaClub;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	public static void menuPricipal() {
		ClubSantander club = new ClubSantander("20373525643", "Santander", "Malvinas Argentinas 743");
		Scanner sc = new Scanner(System.in);
		Archivo archivo = new Archivo();
		int opcion = -1;
		do {
			System.out.println("------------------Menu------------------\nIngrese las siguientes algunas de las siguientes opciones:\n");
			System.out.println("1 - Opcion de agregar");
			System.out.println("2 - Opcion de modificar");
			System.out.println("3 - Opcion de buscar y eliminar");
			System.out.println("4 - Cargar Solicitud de servicio");
			System.out.println("5 - Mostrar ");
			System.out.println("6 - Calcular recaudacion");
			System.out.println("7 - Leer desde archivo");
			System.out.println("9 - salir\n");
			opcion = sc.nextInt();
			if(opcion == 1) {
				do {
					System.out.println("\nElige que deseas agregar\n");
					System.out.println("1 - agregar Profesor");
					System.out.println("2 - agregar Actividad");
					System.out.println("3 - agregar Socio");
					System.out.println("0 - salir\n");
					opcion = sc.nextInt();
					if(opcion == 2 && club.getLstProfesores().size() == 0) {
						System.out.println("No puede agregar actividades sin dar de alta antes algun profesor\nEliga la opcion de cargar profesor primero\n");
						opcion = 0;
					}
					if(opcion == 1) {
						try{
							System.out.println("Cargando profesor...");
							club.agregarProfesor();
						}catch(Exception e) {
							System.out.println("");
							System.out.println(e.getMessage());
						}
					}
					if(opcion == 2) {
						try {
							System.out.println("Cargando actividad...");
							club.agregarActividad();
						}catch(Exception e) {
							System.out.println("");
							System.out.println(e.getMessage());
						}
						
					}
					if(opcion == 3) {
						try {
							System.out.println("Cargando socio");
							club.agregarSocio();
						}catch(Exception e) {
							System.out.println("");
							System.out.println(e.getMessage());
						}
					}
				}while(opcion != 0);
			}
			if(opcion == 2) {
				do {
					System.out.println("\nElije que desea modificar\n");
					System.out.println("1 - modificar Profesor");
					System.out.println("2 - modificar Actividad");
					System.out.println("3 - modificar Socio");
					System.out.println("4 - modificar Servicio");
					System.out.println("0 - Salir");
					opcion = sc.nextInt();
					if(club.getLstProfesores().size() == 0 && opcion == 1) {
						System.out.println("\nNo hay profesores para modificar, primero carguelos");
						opcion = 0;
					}
					if(club.getLstActividades().size() == 0 && opcion == 2) {
						System.out.println("\nNo hay actividades para modificar, primero carguelas");
						opcion = 0;
					}
					if(club.getLstSocios().size() == 0 && opcion == 3) {
						System.out.println("\nNo hay socios para modificar, primero carguelos");
						opcion = 0;
					}
					if(club.getLstServicios().size() == 0 && opcion == 4) {
						System.out.println("\nNo hay servicios para modificar, primero carguelos");
						opcion = 0;
					}
					if(opcion == 1) {
						System.out.println("\nIngrese legajo del profesor que desea modificar los datos");
						try {
						club.modificarProfesor(sc.next());
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					if(opcion == 2) {
						System.out.println("\nIngrese el nombre de la actividad que desea modificar");
						try {
							club.modificarActividad(sc.next());
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					if(opcion == 3) {
						System.out.println("\nIngrese credencial del cliente que desea modificar los datos");
						try {
							club.modificarSocio(sc.nextInt());
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					if(opcion == 4) {
						System.out.println("\nIngrese codigo de servicio que desea modificar los datos");
						try{
							club.modificarServicio(sc.nextInt());
						}catch(Exception e) {
							System.out.println("");
							System.out.println(e.getMessage());
						}
					}
				}while(opcion != 0);
			}
			if(opcion == 3) {
				do {
					System.out.println("\nElige que deseas eliminar\n");
					System.out.println("1 - eliminar Profesor");
					System.out.println("2 - eliminar Actividad");
					System.out.println("3 - eliminar Socio");
					System.out.println("0 - salir\n");
					opcion = sc.nextInt();
					if(opcion == 1 && club.getLstProfesores().size() == 0) {
						System.out.println("\nNo hay profesores para eliminar, primero carguelos");
						opcion = 0;
					}
					if(opcion == 2 && club.getLstActividades().size() == 0) {
						System.out.println("\nNo hay actividades para eliminar, primero carguelos");
						opcion = 0;
					}
					if(opcion == 3 && club.getLstSocios().size() == 0) {
						System.out.println("\nNo hay Socios para eliminar, primero carguelos");
						opcion = 0;
					}
					if(opcion == 1) {
						System.out.println("\nIngrese Nro de legajo:\n");
						String legajo = sc.next();
						try {
							club.eliminarProfesor(legajo);
						}catch(Exception e) {
							System.out.println("");
							System.out.println(e.getMessage());
						}
					}
					if(opcion == 2) {
						System.out.println("\nIngrese nombre de la actividad que desea borrar:\n");
						String nombre = sc.next();
						try {
							club.eliminarActividad(nombre);
						}catch(Exception e) {
							System.out.println("");
							System.out.println(e.getMessage());
						}
					}
				}while(opcion != 0);
			}
			if(opcion == 4) {
				do {
					if(club.getLstActividades().size() == 0) {
						System.out.println("La Lista de actividades esta VACIA no puede cargar servicio!\n");
						opcion = 0;
					}else {
						System.out.println("\nCargando Servicio....");
						try {
							club.agregarServicio();
						}catch(Exception e) {
							System.out.println("");
							System.out.println(e.getMessage());
						}
						opcion = 0;
					}	
				}while(opcion != 0);
				}
			if(opcion == 5) {
				do {
					System.out.println("\nElige que deseas mostrar\n");
					System.out.println("1 - mostrar todo");
					System.out.println("2 - mostrar Profesores");
					System.out.println("3 - mostrar Actividades");
					System.out.println("4 - mostrar Socios");
					System.out.println("5 - mostrar Servicios");
					System.out.println("0 - salir\n");
					opcion = sc.nextInt();
					if(opcion == 1) {
						System.out.println(club);
						try {
							archivo.mostrarClubEnArchivo(club);
						}catch(Exception e) {
							System.out.println("");
							System.out.println(e.getMessage());
						}
					}
					if(opcion == 2) {
						System.out.println(club.getLstProfesores());
						try {
							archivo.mostrarProfesoresDelClubEnArchivo(club);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					if(opcion == 3) {
						System.out.println(club.getLstActividades());
						try {
							archivo.mostrarActividadesDelClubEnMismoArchivo(club);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					if(opcion == 4) {
						System.out.println(club.getLstSocios());
						try {
							archivo.mostrarSociosDelClubEnArchivo(club);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					if(opcion == 5) {
						System.out.println(club.getLstServicios());
						try {
							archivo.mostrarServiciosDelClubEnArchivo(club);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}while(opcion != 0);
			}
		if(opcion == 6) {
			System.out.println("Recaudacion total\n");
			System.out.println("$"+club.calcularRecaudacion());
		}
		if(opcion == 7) {
			do {
				System.out.println("1 - Leer Profesores");
				System.out.println("2 - Leer Actividades");
				System.out.println("3 - Leer Socios");
				System.out.println("4 - Leer Servicios");
				System.out.println("0 - Salir");
				opcion = sc.nextInt();
				if(opcion == 1) {
					System.out.println(archivo.leerTxt("D:\\UNLA PC\\2do AÑO\\MATERIAS\\2do cuatrimestre\\2 - Orientacion a Objetos 1 (MARTES 8 a 14hs)\\archivos\\ProyectoFinalSeminario\\profesores.txt"));
				}
				if(opcion == 2) {
					System.out.println(archivo.leerTxt("D:\\UNLA PC\\2do AÑO\\\\MATERIAS\\2do cuatrimestre\\2 - Orientacion a Objetos 1 (MARTES 8 a 14hs)\\archivos\\ProyectoFinalSeminario\\actividades.txt"));
				}
				if(opcion == 3) {
					System.out.println(archivo.leerTxt("D:\\UNLA PC\\2do AÑO\\MATERIAS\\2do cuatrimestre\\2 - Orientacion a Objetos 1 (MARTES 8 a 14hs)\\archivos\\ProyectoFinalSeminario\\sociosDelClub.txt"));
				}
				if(opcion == 4) {
					System.out.println(archivo.leerTxt("D:\\UNLA PC\\2do AÑO\\MATERIAS\\2do cuatrimestre\\2 - Orientacion a Objetos 1 (MARTES 8 a 14hs)\\archivos\\ProyectoFinalSeminario\\servicios.txt"));
				}
			}while(opcion != 0);	
		}
		}while(opcion != 9);
			 
	}

}
