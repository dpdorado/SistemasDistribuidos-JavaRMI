package dto.ObjetosDTO;

import dto.ObjectDTO;

public class AnteproyectoCompletoDTO extends ObjectDTO{
	//Attributes
	private NodoAnteproyectoDTO Anteproyecto;
	private EvaluadoresDTO Evaluadores;
	//Builders
	public AnteproyectoCompletoDTO() {
		this.Anteproyecto=null;
		this.Evaluadores=null;
	}
	public AnteproyectoCompletoDTO(NodoAnteproyectoDTO anteproyecto, EvaluadoresDTO evaluadores) {
		super();
		this.Anteproyecto = anteproyecto;
		this.Evaluadores = evaluadores;
	}
	//Getters and Setters
	public NodoAnteproyectoDTO getAnteproyecto() {
		return Anteproyecto;
	}
	public void setAnteproyecto(NodoAnteproyectoDTO anteproyecto) {
		Anteproyecto = anteproyecto;
	}
	public EvaluadoresDTO getEvaluadores() {
		return Evaluadores;
	}
	public void setEvaluadores(EvaluadoresDTO evaluadores) {
		Evaluadores = evaluadores;
	}
}
