package servidor.dto.ObjetosDTO;

import servidor.dto.ObjectDTO;

public class NodoAnteproyectoDTO extends ObjectDTO{
	//Atributos
    private String Modalidad;
    private String Titulo;
    private String Codigo;
    private String NombreEstudiante1;
    private String NombreEstudiante2;
    private String NombreDirector;
    private String NombreCoDirector;
    private String FechaRegistro;//Date??
    private String FechaAprobacion;
    private int Concepto;
    private int Estado;
    private int NumeroRevision;
    private NodoAnteproyectoDTO SiguinteAnteproyecto=null;
    //Constructores
    public NodoAnteproyectoDTO() {}
    
    public NodoAnteproyectoDTO(String Modalidad, String Titulo, String Codigo, String NombreEstudiante1, String NombreEstudiante2, String NombreDirector, String NombreCoDirector, String FechaRegistro, String FechaAprobacion, int Concepto, int Estado, int NumeroRevision) {
        this.Modalidad = Modalidad;
        this.Titulo = Titulo;
        this.Codigo = Codigo;
        this.NombreEstudiante1 = NombreEstudiante1;
        this.NombreEstudiante2 = NombreEstudiante2;
        this.NombreDirector = NombreDirector;
        this.NombreCoDirector = NombreCoDirector;
        this.FechaRegistro = FechaRegistro;
        this.FechaAprobacion = FechaAprobacion;
        this.Concepto = Concepto;
        this.Estado = Estado;
        this.NumeroRevision = NumeroRevision;
    }
    //Getters and Setters

    public String getModalidad() {
        return Modalidad;
    }

    public void setModalidad(String Modalidad) {
        this.Modalidad = Modalidad;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombreEstudiante1() {
        return NombreEstudiante1;
    }

    public void setNombreEstudiante1(String NombreEstudiante1) {
        this.NombreEstudiante1 = NombreEstudiante1;
    }

    public String getNombreEstudiante2() {
        return NombreEstudiante2;
    }

    public void setNombreEstudiante2(String NombreEstudiante2) {
        this.NombreEstudiante2 = NombreEstudiante2;
    }

    public String getNombreDirector() {
        return NombreDirector;
    }

    public void setNombreDirector(String NombreDirector) {
        this.NombreDirector = NombreDirector;
    }

    public String getNombreCoDirector() {
        return NombreCoDirector;
    }

    public void setNombreCoDirector(String NombreCoDirector) {
        this.NombreCoDirector = NombreCoDirector;
    }

    public String getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(String FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public String getFechaAprobacion() {
        return FechaAprobacion;
    }

    public void setFechaAprobacion(String FechaAprobacion) {
        this.FechaAprobacion = FechaAprobacion;
    }

    public int getConcepto() {
        return Concepto;
    }

    public void setConcepto(int Concepto) {
        this.Concepto = Concepto;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public int getNumeroRevision() {
        return NumeroRevision;
    }

    public void setNumeroRevision(int NumeroRevision) {
        this.NumeroRevision = NumeroRevision;
    }

	public NodoAnteproyectoDTO getSiguinteAnteproyecto() {
		return SiguinteAnteproyecto;
	}

	public void setSiguinteAnteproyecto(NodoAnteproyectoDTO siguinteAnteproyecto) {
		SiguinteAnteproyecto = siguinteAnteproyecto;
	}
    
}
