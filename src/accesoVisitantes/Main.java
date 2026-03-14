package accesoVisitantes;

import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static GestionEmpleado gestionEmpleado = new GestionEmpleado();
	public static GestionVisitante gestionVisitante = new GestionVisitante();

	public static void main(String[] args) {

		cargarEmpleadosIniciales();

		boolean salir = false;

		while (!salir) {
			System.out.println("\n=== SISTEMA DE GESTIÓN DE VISITAS ===");
			System.out.println("1. Alumno");
			System.out.println("2. Recepción");
			System.out.println("3. Empleado");
			System.out.println("0. Salir");
			System.out.print("Seleccione una opción: ");

			int opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case 1 -> menuAlumno();
			case 2 -> menuRecepcion();
			case 3 -> menuEmpleado();
			case 0 -> salir = true;
			default -> System.out.println("Opción no válida.");
			}
		}

		sc.close();
		System.out.println("Programa finalizado.");
	}

	// ---------------- CARGA INICIAL ----------------
	private static void cargarEmpleadosIniciales() {
		gestionEmpleado.agregarEmpleado(new Empleado("Ana", "López", DepartamentoExtTelefono.INFORMATICA));
		gestionEmpleado.agregarEmpleado(new Empleado("Carlos", "Ruiz", DepartamentoExtTelefono.ADMINISTRACION));
		gestionEmpleado.agregarEmpleado(new Empleado("Lucía", "Martín", DepartamentoExtTelefono.DIRECCION));

	}

	// ---------------- MENÚ ALUMNO ----------------
	public static void menuAlumno() {

	    boolean volver = false;

	    while (!volver) {
	        System.out.println("\n--- MENÚ ALUMNO ---");
	        System.out.println("1. Solicitar cita");
	        System.out.println("2. Cancelar cita");
	        System.out.println("3. Actualizar datos");
	        System.out.println("0. Volver");
	        System.out.print("Seleccione una opción: ");

	        int opcion = Integer.parseInt(sc.nextLine());

	        switch (opcion) {
	            case 1 -> flujoSolicitarCita();
	            case 2 -> flujoCancelarCita();
	            case 3 -> flujoActualizarDatos();
	            case 0 -> volver = true;
	            default -> System.out.println("Opción no válida.");
	        }
	    }
	}
	
	private static void flujoActualizarDatos() {

	    System.out.print("Introduce tu DNI: ");
	    String dni = sc.nextLine();

	    Visitante v = gestionVisitante.buscarPorId(dni);

	    if (v == null || !(v instanceof Alumno)) {
	        System.out.println("Alumno no encontrado.");
	        return;
	    }

	    Alumno alumno = (Alumno) v;
	    alumno.actualizarDatos(sc);
	}

	
	private static void flujoCancelarCita() {

	    System.out.print("Introduce tu DNI: ");
	    String dni = sc.nextLine();

	    Visitante v = gestionVisitante.buscarPorId(dni);

	    if (v == null) {
	        System.out.println("No existe ningún alumno con ese DNI.");
	        return;
	    }

	    v.cancelarCita();
	}


	private static void flujoSolicitarCita() {

	    System.out.print("Introduce tu DNI: ");
	    String dni = sc.nextLine();

	    Visitante existente = gestionVisitante.buscarPorId(dni);

	    Alumno alumno;

	    if (existente != null && existente instanceof Alumno) {
	        alumno = (Alumno) existente;
	        System.out.println("Alumno encontrado: " + alumno.getNombre());
	    } else {
	        System.out.println("Alumno no encontrado. Introduce tus datos:");

	        System.out.print("Nombre: ");
	        String nombre = sc.nextLine();

	        System.out.print("Centro educativo: ");
	        String centro = sc.nextLine();

	        System.out.print("Curso: ");
	        String curso = sc.nextLine();

	        System.out.print("Tutor: ");
	        String tutor = sc.nextLine();

	        System.out.print("Teléfono: ");
	        String telefono = sc.nextLine();

	        System.out.print("Email: ");
	        String email = sc.nextLine();

	        alumno = new Alumno(dni, nombre, centro, curso, tutor, telefono, email);
	        gestionVisitante.agregarVisitante(alumno);
	    }

	    solicitarCitaAlumno(alumno);
	}


	private static void solicitarCitaAlumno(Visitante visitante) {

		System.out.println("\n--- EMPLEADOS DISPONIBLES ---");
		gestionEmpleado.listarEmpleados();

		System.out.print("Introduce el ID del empleado a visitar: ");
		int id = Integer.parseInt(sc.nextLine());

		Empleado empleado = gestionEmpleado.buscarPorId(id);

		if (empleado == null) {
			System.out.println("Empleado no encontrado.");
			return;
		}

		visitante.solicitarCita(empleado);

		gestionVisitante.agregarVisitante(visitante);

		empleado.registrarVisita(visitante);

		System.out.println("Cita solicitada correctamente.");
	}

	// ---------------- MENÚ RECEPCIÓN ----------------
	public static void menuRecepcion() {

		boolean volver = false;

		while (!volver) {
			System.out.println("\n--- MENÚ RECEPCIÓN ---");
			System.out.println("1. Registrar entrada");
			System.out.println("2. Registrar salida");
			System.out.println("3. Marcar no acude");
			System.out.println("0. Volver");
			System.out.print("Seleccione una opción: ");

			int opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case 1 -> registrarEntradaRecepcion();
			case 2 -> registrarSalidaRecepcion();
			case 3 -> marcarNoAcudeRecepcion();
			case 0 -> volver = true;
			default -> System.out.println("Opción no válida.");
			}
		}
	}

	private static Visitante pedirVisitantePorId() {
		System.out.print("Introduce ID del visitante (DNI si es alumno): ");
		String id = sc.nextLine();

		Visitante v = gestionVisitante.buscarPorId(id);

		if (v == null) {
			System.out.println("Visitante no encontrado.");
		}

		return v;
	}

	private static void registrarEntradaRecepcion() {
		Visitante v = pedirVisitantePorId();
		if (v != null) {
			v.registrarEntrada();
			v.getEmpleadoAVisitar().notificarLlegada(v);
		}
	}

	private static void registrarSalidaRecepcion() {
		Visitante v = pedirVisitantePorId();
		if (v != null) {
			v.registrarSalida();
			v.getEmpleadoAVisitar().notificarSalida(v);
		}
	}

	private static void marcarNoAcudeRecepcion() {
		Visitante v = pedirVisitantePorId();
		if (v != null) {
			v.marcarNoAcude();
		}
	}

	// ---------------- MENÚ EMPLEADO ----------------
	public static void menuEmpleado() {

		System.out.print("Introduce ID del empleado: ");
		int id = Integer.parseInt(sc.nextLine());

		Empleado empleado = gestionEmpleado.buscarPorId(id);

		if (empleado == null) {
			System.out.println("Empleado no encontrado.");
			return;
		}

		boolean volver = false;

		while (!volver) {
			System.out.println("\n--- MENÚ EMPLEADO ---");
			System.out.println("1. Listar visitas asignadas");
			System.out.println("0. Volver");
			System.out.print("Seleccione una opción: ");

			int opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case 1 -> empleado.listarVisitas();
			case 0 -> volver = true;
			default -> System.out.println("Opción no válida.");
			}
		}
	}
}
