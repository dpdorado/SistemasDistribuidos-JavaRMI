package dto.ObjetosDTO;

import dto.ObjectDTO;

public class EvaluadoresDTO extends ObjectDTO{
	 //Atributos
    private String CodigoAnteproyecto;
    private String NombreEvaluador1;
    private String ConceptoEvaluador1;
    private String FechaRevision1;
    private String NombreEvaluador2;
    private String ConceptoEvaluador2;
    private String FechaRevision2;
    //Constructores
    
    public EvaluadoresDTO() {}
    public EvaluadoresDTO(String CodigoAnteproyecto, String NombreEvaluador1, String ConceptoEvaluador1, String FechaRevision1, String NombreEvaluador2, String ConceptoEvaluador2, String FechaRevision2) {
        this.CodigoAnteproyecto = CodigoAnteproyecto;
        this.NombreEvaluador1 = NombreEvaluador1;
        this.ConceptoEvaluador1 = ConceptoEvaluador1;
        this.FechaRevision1 = FechaRevision1;
        this.NombreEvaluador2 = NombreEvaluador2;
        this.ConceptoEvaluador2 = ConceptoEvaluador2;
        this.FechaRevision2 = FechaRevision2;
    }
    //Getters and Setters

    public String getCodigoAnteproyecto() {
        return CodigoAnteproyecto;
    }

    public void setCodigoAnteproyecto(String CodigoAnteproyecto) {
        this.CodigoAnteproyecto = CodigoAnteproyecto;
    }

    public String getNombreEvaluador1() {
        return NombreEvaluador1;
    }

    public void setNombreEvaluador1(String NombreEvaluador1) {
        this.NombreEvaluador1 = NombreEvaluador1;
    }

    public String getConceptoEvaluador1() {
        return ConceptoEvaluador1;
    }

    public void setConceptoEvaluador1(String ConceptoEvaluador1) {
        this.ConceptoEvaluador1 = ConceptoEvaluador1;
    }

    public String getFechaRevision1() {
        return FechaRevision1;
    }

    public void setFechaRevision1(String FechaRevision1) {
        this.FechaRevision1 = FechaRevision1;
    }

    public String getNombreEvaluador2() {
        return NombreEvaluador2;
    }

    public void setNombreEvaluador2(String NombreEvaluador2) {
        this.NombreEvaluador2 = NombreEvaluador2;
    }

    public String getConceptoEvaluador2() {
        return ConceptoEvaluador2;
    }

    public void setConceptoEvaluador2(String ConceptoEvaluador2) {
        this.ConceptoEvaluador2 = ConceptoEvaluador2;
    }

    public String getFechaRevision2() {
        return FechaRevision2;
    }

    public void setFechaRevision2(String FechaRevision2) {
        this.FechaRevision2 = FechaRevision2;
    }
}
