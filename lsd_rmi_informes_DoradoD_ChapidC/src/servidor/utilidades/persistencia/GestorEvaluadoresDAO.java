package servidor.utilidades.persistencia;

import java.util.Hashtable;

import servidor.dao.GestorObjetoDAO;

public class GestorEvaluadoresDAO implements GestorObjetoDAO{
	private GestorArchivo gestor;
	
	public GestorEvaluadoresDAO() {
		this.gestor=new GestorArchivo();
	}
	
	@Override
	public boolean registrarObjeto(Object obj) {
		boolean varResultado=false;
		@SuppressWarnings("unchecked")
		Hashtable<String,String> object=(Hashtable<String,String>)obj;
		boolean isCodigoAnt;
		this.gestor.openFile(IConstantes.PATH_EVALUADORES);
		isCodigoAnt=this.gestor.existsObject(IConstantes.CODIGO_ANTEPROYECTO, object.get(IConstantes.CODIGO_ANTEPROYECTO));						
		this.gestor.closeFile();
		if (isCodigoAnt){
			return varResultado;
		}
		this.gestor.openFile(IConstantes.PATH_EVALUADORES);						
		varResultado= this.gestor.writeObject(null, object);
		this.gestor.closeFile();
		return varResultado;
	}

	@Override
	public Object leerObjeto(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editarObjeto(Object obj) {
		boolean varResultado=false;
		@SuppressWarnings("unchecked")
		Hashtable<String,String> object=(Hashtable<String,String>)obj;
		this.gestor.openFile(IConstantes.PATH_EVALUADORES);
		if(this.gestor.existsObject(IConstantes.CODIGO_ANTEPROYECTO, object.get(IConstantes.CODIGO_ANTEPROYECTO))) {
			varResultado=this.gestor.modifyObject(IConstantes.CODIGO_ANTEPROYECTO, object.get(IConstantes.CODIGO_ANTEPROYECTO), IConstantes.CONCEPTO, object.get(IConstantes.CONCEPTO));
		}
		return varResultado;
	}

	@Override
	public Object listarObjetos() {
		// TODO Auto-generated method stub
		return null;
	}

}
