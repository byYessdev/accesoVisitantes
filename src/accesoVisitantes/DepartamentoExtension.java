package accesoVisitantes;

public enum DepartamentoExtension {
	
	FORMACION(1001),
	PRACTICAS(1002),
	ORIENTACION(1003),
	ADMINISTRACION(1004),
	DIRECCION(1005),
	INFORMATICA(1006),
	RRHH(1007);
	
	private int extension;
	
	private DepartamentoExtension(int extension) {
		this.extension = extension;
	}
	
	public int getExtension() {
		return extension;
	}
}
