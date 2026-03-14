package accesoVisitantes;

import java.util.ArrayList;
import java.util.List;

public class GestionEmpleado {

    private List<Empleado> empleados = new ArrayList<>();

    // Añadir un empleado al sistema
    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    // Buscar empleado por ID (int)
    public Empleado buscarPorId(int id) {
        for (Empleado e : empleados) {
            if (e.getIdEmpleado() == id) {   // ✔ Correcto si idEmpleado es int
                return e;
            }
        }
        return null;
    }

    // Buscar empleado por nombre y apellidos
    public Empleado buscarPorNombre(String nombre, String apellidos) {
        for (Empleado e : empleados) {
            if (e.getNombre().equalsIgnoreCase(nombre) &&
                e.getApellidos().equalsIgnoreCase(apellidos)) {
                return e;
            }
        }
        return null;
    }

    // Listar todos los empleados
    public void listarEmpleados() {
        System.out.println("\n--- LISTA DE EMPLEADOS ---");
        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }

    // Listar empleados por departamento
    public void listarPorDepartamento(DepartamentoExtTelefono depto) {
        System.out.println("\n--- EMPLEADOS DEL DEPARTAMENTO " + depto + " ---");
        for (Empleado e : empleados) {
            if (e.getDepartamento() == depto) {
                System.out.println(e);
            }
        }
    }

    // Obtener la lista completa
    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
