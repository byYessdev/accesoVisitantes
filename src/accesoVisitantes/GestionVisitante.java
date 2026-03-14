package accesoVisitantes;

import java.util.ArrayList;
import java.util.List;

public class GestionVisitante {

    private List<Visitante> visitantes = new ArrayList<>();

    // Añadir un visitante (incluye alumnos)
    public void agregarVisitante(Visitante v) {
        visitantes.add(v);
    }

    // Buscar visitante por ID (DNI si es alumno)
    public Visitante buscarPorId(String id) {
        for (Visitante v : visitantes) {
            if (v.getIdVisitante().equalsIgnoreCase(id)) {
                return v;
            }
        }
        return null;
    }

    // Buscar visitante por nombre
    public Visitante buscarPorNombre(String nombre) {
        for (Visitante v : visitantes) {
            if (v.getNombre().equalsIgnoreCase(nombre)) {
                return v;
            }
        }
        return null;
    }

    // Buscar visitante por nombre y empresa (útil para externos)
    public Visitante buscarPorNombreYEmpresa(String nombre, String empresa) {
        for (Visitante v : visitantes) {
            if (v.getNombre().equalsIgnoreCase(nombre) &&
                v.getEmpresa().equalsIgnoreCase(empresa)) {
                return v;
            }
        }
        return null;
    }

    // Listar todos los visitantes
    public void listarVisitantes() {
        System.out.println("\n--- LISTA DE VISITANTES ---");
        for (Visitante v : visitantes) {
            System.out.println(v);
        }
    }

    // Eliminar visitante
    public void eliminarVisitante(Visitante v) {
        visitantes.remove(v);
    }

    // Obtener lista completa
    public List<Visitante> getVisitantes() {
        return visitantes;
    }
}
