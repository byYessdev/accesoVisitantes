package accesoVisitantes;

public enum DepartamentoExtTelefono {
	
	FORMACION(1001),
	PRACTICAS(1002),
	ORIENTACION(1003),
	ADMINISTRACION(1004),
	DIRECCION(1005),
	INFORMATICA(1006),
	RRHH(1007);
	
	private int extension;
	
	private DepartamentoExtTelefono(int extension) {
		this.extension = extension;
	}
	
	public int getExtension() {
		return extension;
	}
}
