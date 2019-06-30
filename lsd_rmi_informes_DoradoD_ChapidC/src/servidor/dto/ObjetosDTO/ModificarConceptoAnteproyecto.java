package servidor.dto.ObjetosDTO;

import servidor.dto.ObjectDTO;

public class ModificarConceptoAnteproyecto extends ObjectDTO {
	//Attributes
	private String CodigoAnteproyecto;
	private int NuevoConcepto;
	//Builders
	public ModificarConceptoAnteproyecto(String codigoAnteproyecto, int nuevoConcepto) {
		super();
		CodigoAnteproyecto = codigoAnteproyecto;
		NuevoConcepto = nuevoConcepto;
	}
	//Getters and Setters
	public String getCodigoAnteproyecto() {
		return CodigoAnteproyecto;
	}
	public void setCodigoAnteproyecto(String codigoAnteproyecto) {
		CodigoAnteproyecto = codigoAnteproyecto;
	}
	public int getNuevoConcepto() {
		return NuevoConcepto;
	}
	public void setNuevoConcepto(int nuevoConcepto) {
		NuevoConcepto = nuevoConcepto;
	}
	
}
