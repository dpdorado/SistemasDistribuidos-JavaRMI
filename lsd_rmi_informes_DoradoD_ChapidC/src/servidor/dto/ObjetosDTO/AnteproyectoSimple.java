package servidor.dto.ObjetosDTO;

import servidor.dto.ObjectDTO;

public class AnteproyectoSimple extends ObjectDTO{
	private String Codigo;
	private String Titulo;
	
	public AnteproyectoSimple() {}
	public AnteproyectoSimple(String codigo, String titulo) {
		super();
		Codigo = codigo;
		Titulo = titulo;
		
	}
	
	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}	
}
