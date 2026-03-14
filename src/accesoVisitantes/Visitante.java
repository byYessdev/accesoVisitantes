package accesoVisitantes;

import java.time.LocalDateTime;

public class Visitante {
	
	private String idVisitante;
	private String nombre;
	private String empresa;
	private LocalDateTime fechaVisita;
	private EstadoVisita estadoVisita;
	private Empleado empleadoAVisitar;
	
	public Visitante(String idVisitante, String nombre, String empresa, LocalDateTime fechaVisita,
			EstadoVisita estadoVisita) {
		this.idVisitante = idVisitante;
		this.nombre = nombre;
		this.empresa = empresa;
		this.fechaVisita = fechaVisita;
		this.estadoVisita = estadoVisita;
	}
	
	public Visitante(String idVisitante, String nombre, String centroEducativo) {
		super();
		this.idVisitante = idVisitante;
		this.nombre = nombre;
		this.empresa = centroEducativo;
	}
	
	public void registrarEntrada() {
	    this.estadoVisita = EstadoVisita.EN_CURSO;
	    System.out.println("Entrada registrada para el visitante " + nombre);
	}
	
	public void registrarSalida() {
	    this.estadoVisita = EstadoVisita.FINALIZADA;
	    System.out.println("Salida registrada para el visitante " + nombre);

	    if (empleadoAVisitar != null) {
	        empleadoAVisitar.notificarSalida(this);
	    }
	}

	
	public void marcarNoAcude() {
	    this.estadoVisita = EstadoVisita.NO_ACUDIO;
	    System.out.println("El visitante " + nombre + " no acudió a su cita.");
	}
	
	public void solicitarCita(Empleado empleado) {
	    this.empleadoAVisitar = empleado;
	    this.fechaVisita = LocalDateTime.now();
	    this.estadoVisita = EstadoVisita.PENDIENTE;

	    System.out.println("Se ha solicitado una cita con " +
	                       empleado.getNombre() + " " + empleado.getApellidos());
	}

	public void cancelarCita() {
	    if (this.estadoVisita == EstadoVisita.CANCELADA) {
	        System.out.println("La cita ya estaba cancelada.");
	        return;
	    }

	    this.estadoVisita = EstadoVisita.CANCELADA;

	    System.out.println("La cita del visitante " + this.nombre + " ha sido cancelada.");

	    if (empleadoAVisitar != null) {
	        System.out.println("Se notifica al empleado " +
	                           empleadoAVisitar.getNombre() + " " +
	                           empleadoAVisitar.getApellidos());
	    }
	}


	

	public String getIdVisitante() {
		return idVisitante;
	}

	public void setIdVisitante(String idVisitante) {
		this.idVisitante = idVisitante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public LocalDateTime getFechaVisita() {
		return fechaVisita;
	}

	public void setFechaVisita(LocalDateTime fechaVisita) {
		this.fechaVisita = fechaVisita;
	}

	public EstadoVisita getEstadoVisita() {
		return estadoVisita;
	}

	public void setEstadoVisita(EstadoVisita estadoVisita) {
		this.estadoVisita = estadoVisita;
	}
	
	public Empleado getEmpleadoAVisitar () {
		return empleadoAVisitar;
	}
	
	public void setEmpleadoAVisitar(Empleado empleadoAVisitar) {
		this.empleadoAVisitar = empleadoAVisitar;
	}
	
	

}
