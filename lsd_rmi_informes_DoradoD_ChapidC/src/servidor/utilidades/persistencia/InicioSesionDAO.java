package servidor.utilidades.persistencia;

import java.util.Hashtable;

import servidor.dao.GestorObjetoDAO;

public class InicioSesionDAO implements GestorObjetoDAO{
	private GestorArchivo gestor;
	
	public InicioSesionDAO() {
		this.gestor=new GestorArchivo();
	}
	
	@Override
	public boolean registrarObjeto(Object obj) {
		// TODO Auto-generated method stub
		//No se utiliza.
		return false;
	}

	@Override
	public Object leerObjeto(Object obj) {
		@SuppressWarnings("unchecked")
		Hashtable<String,String> datas=(Hashtable<String,String>)obj;
		Hashtable<String,String> object=null;
		String clave=datas.keys().nextElement();
		String valor=datas.elements().nextElement();
		//Leer objeto admin y si es nulo leer objeto usuario
		gestor.openFile(IConstantes.PATH_ADMIN);
		object=gestor.readObject(clave, valor);
		gestor.closeFile();
		
		if (object==null) {
			gestor.openFile(IConstantes.PATH_USERS);
			object=gestor.readObject(clave, valor);
			gestor.closeFile();
		}
		return object;
	}

	@Override
	public boolean editarObjeto(Object obj) {
		boolean varResultado=false;
		@SuppressWarnings("unchecked")
		Hashtable<String,String> datas=(Hashtable<String,String>)obj;
		this.gestor.openFile(IConstantes.PATH_ADMIN);
		varResultado=this.gestor.modifyObject(IConstantes.PATH_USERS, datas.get(IConstantes.PATH_USERS), IConstantes.CONTRASENIA, datas.get(IConstantes.CONTRASENIA));
		this.gestor.closeFile();
		return varResultado;
	}

	@Override
	public Object listarObjetos() {
		// TODO Auto-generated method stub
		//No se utiliza.
		return null;
	}

}
