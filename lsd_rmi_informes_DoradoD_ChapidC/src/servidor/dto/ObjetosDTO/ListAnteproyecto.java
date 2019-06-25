package dto.ObjetosDTO;

import dto.ObjectDTO;

public class ListAnteproyecto extends ObjectDTO{
	private String Codigo;
	private String Titulo;
	private ListAnteproyecto SiguienteListAnteproyecto=null;
	
	public ListAnteproyecto() {}
	public ListAnteproyecto(String codigo, String titulo) {
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

	public ListAnteproyecto getSiguienteListAnteproyecto() {
		return SiguienteListAnteproyecto;
	}

	public void setSiguienteListAnteproyecto(ListAnteproyecto siguienteListAnteproyecto) {
		SiguienteListAnteproyecto = siguienteListAnteproyecto;
	}
	
	
}
