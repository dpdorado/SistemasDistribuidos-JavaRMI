package servidor.utilidades.persistencia;

import java.util.ArrayList;
import java.util.Hashtable;

import servidor.dao.GestorObjetoDAO;

public class GestorAnteproyectosDAO implements GestorObjetoDAO{
	private GestorArchivo gestor;
	
	public GestorAnteproyectosDAO() {
		this.gestor=new GestorArchivo();
	}
	@Override
	public boolean registrarObjeto(Object obj) {
		boolean varResultado=false;
		@SuppressWarnings("unchecked")
		Hashtable<String,String> object=(Hashtable<String,String>)obj;
		boolean isCodigoAnt;
		this.gestor.openFile(IConstantes.PATH_ANTEPROYECTOS);
		isCodigoAnt=this.gestor.existsObject(IConstantes.CODIGO_ANTEPROYECTO, object.get(IConstantes.CODIGO_ANTEPROYECTO));						
		this.gestor.closeFile();
		if (isCodigoAnt){
			return varResultado;
		}
		this.gestor.openFile(IConstantes.PATH_ANTEPROYECTOS);						
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
		this.gestor.openFile(IConstantes.PATH_ANTEPROYECTOS);
		varResultado=this.gestor.modifyObject(IConstantes.CODIGO_ANTEPROYECTO, object.get(IConstantes.CODIGO_ANTEPROYECTO), IConstantes.CONCEPTO, object.get(IConstantes.CONCEPTO));
		this.gestor.closeFile();
		return varResultado;
	}

	@Override
	public Object listarObjetos() {
		this.gestor.openFile(IConstantes.PATH_ANTEPROYECTOS);
		ArrayList<Hashtable<String, String>> datas=this.gestor.listObjects();
		this.gestor.closeFile();
		return datas;
	}

}
