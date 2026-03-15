package accesoVisitantes;

import java.util.ArrayList;
import java.util.List;

public class Empleado {

    private static int contador = 1; // AUTOINCREMENTAL

    private int idEmpleado;
    private String nombre;
    private String apellidos;
    private DepartamentoExtension departamentoExtension;
    private List<Visitante> visitantesRecibidos = new ArrayList<>();

    // Constructor CORRECTO (sin idEmpleado)
    public Empleado(String nombre, String apellidos, DepartamentoExtension departamento) {
        this.idEmpleado = contador++; // ID autoincremental
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamentoExtension = departamento;
    }

    public void registrarVisita(Visitante v) {
        visitantesRecibidos.add(v);
    }

    public void listarVisitas() {
        if (visitantesRecibidos.isEmpty()) {
            System.out.println("Este empleado no tiene visitas registradas.");
            return;
        }

        System.out.println("Listado de visitas recibidas por " + nombre + ":");

        for (Visitante v : visitantesRecibidos) {
            System.out.println("- " + v.getNombre() + " (" + v.getEmpresa() + ")");
        }
    }

    public void notificarLlegada(Visitante v) {
        System.out.println("El visitante " + v.getNombre() +
                " ha llegado para ver al empleado " +
                this.getNombre() + " " + this.getApellidos());
    }

    public void notificarSalida(Visitante v) {
        System.out.println("El visitante " + v.getNombre() +
                " ha salido tras visitar al empleado " +
                this.getNombre() + " " + this.getApellidos());
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public DepartamentoExtension getDepartamentoExtension() {
        return departamentoExtension;
    }

    public List<Visitante> getVisitantesRecibidos() {
        return visitantesRecibidos;
    }
}
