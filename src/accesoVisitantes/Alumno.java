package accesoVisitantes;


import java.util.Scanner;

public class Alumno extends Visitante {

	private String dni;
    private String centroEducativo;
    private String curso;
    private String tutor;
    private String telefono;
    private String email;

    public Alumno(String dni, String nombre, String centroEducativo,
                  String curso, String tutor, String telefono, String email) {

        // Llama al constructor de Visitante para alumnos
        super(dni, nombre, centroEducativo);

        this.dni = dni;
        this.centroEducativo = centroEducativo;
        this.curso = curso;
        this.tutor = tutor;
        this.telefono = telefono;
        this.email = email;
    }

	public void solicitarCita(Empleado empleado) {
		super.solicitarCita(empleado);
	}

	public void cancelarCita() {
		super.cancelarCita();
	}

	public void actualizarDatos(Scanner sc) {

		System.out.println("Actualizando datos del alumno...");

		System.out.print("Nuevo nombre: ");
		this.setNombre(sc.nextLine());

		System.out.print("Nuevo teléfono: ");
		this.setTelefono(sc.nextLine());

		System.out.print("Nuevo email: ");
		this.setEmail(sc.nextLine());

		System.out.println("Datos actualizados correctamente.");

	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCentroEducativo() {
		return centroEducativo;
	}

	public void setCentroEducativo(String centroEducativo) {
		this.centroEducativo = centroEducativo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
