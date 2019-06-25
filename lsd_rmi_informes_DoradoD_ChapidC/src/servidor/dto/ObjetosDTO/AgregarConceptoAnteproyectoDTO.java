package dto.ObjetosDTO;

import dto.ObjectDTO;

public class AgregarConceptoAnteproyectoDTO extends ObjectDTO{
	//Attributes
	private String CodigoAnteproyecto;
	private String Concepto;
	//Builders
	public AgregarConceptoAnteproyectoDTO(String codigoAnteproyecto, String concepto) {
		super();
		this.CodigoAnteproyecto = codigoAnteproyecto;
		this.Concepto = concepto;
	}
	//Getters and Setters
	public String getCodigoAnteproyecto() {
		return CodigoAnteproyecto;
	}
	public void setCodigoAnteproyecto(String codigoAnteproyecto) {
		CodigoAnteproyecto = codigoAnteproyecto;
	}
	public String getConcepto() {
		return Concepto;
	}
	public void setConcepto(String concepto) {
		Concepto = concepto;
	}
	


}
