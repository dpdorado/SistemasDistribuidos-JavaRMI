package servidor.utilidades.persistencia;

import java.util.Hashtable;

import servidor.dao.GestorObjetoDAO;

public class GestorUsuariosDAO implements GestorObjetoDAO{
	private GestorArchivo gestor;
	
	public GestorUsuariosDAO() {
		this.gestor=new GestorArchivo();
	}
	
	@Override
	public boolean registrarObjeto(Object obj) {
		boolean varResultado=false;
		@SuppressWarnings("unchecked")
		Hashtable<String,String> object=(Hashtable<String,String>)obj;
		boolean isUsersId;
		boolean isUsersUs;
		boolean isAdminUs;
		this.gestor.openFile(IConstantes.PATH_USERS);
		isUsersId=this.gestor.existsObject(IConstantes.IDENTIFICACION, object.get(IConstantes.IDENTIFICACION));
		isUsersUs=this.gestor.existsObject(IConstantes.TIPO_USUARIO, object.get(IConstantes.TIPO_USUARIO));
		this.gestor.openFile(IConstantes.PATH_ADMIN);
		isAdminUs=this.gestor.existsObject(IConstantes.TIPO_USUARIO, object.get(IConstantes.TIPO_USUARIO));
		this.gestor.closeFile();
		if (isUsersId || isUsersUs || isAdminUs){
			return varResultado;
		}
		this.gestor.openFile(IConstantes.PATH_USERS);						
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object listarObjetos() {
		// TODO Auto-generated method stub
		return null;
	}

}
