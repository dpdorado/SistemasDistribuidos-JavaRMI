package sop_rmi.implementacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

import servidor.dao.GestorObjetoDAO;
import servidor.dto.ObjectDTO;
import servidor.dto.ObjetosDTO.AnteproyectoSimple;
import servidor.dto.ObjetosDTO.NodoAnteproyectoDTO;
import sop_rmi.interfaces.OperacioneEDInt;
import servidor.utilidades.persistencia.GestorAnteproyectosDAO;
import servidor.utilidades.persistencia.IConstantes;

public class OperacionesEDImpl extends UnicastRemoteObject implements OperacioneEDInt{
	private GestorObjetoDAO gestorAnteproyectos;
	
	public OperacionesEDImpl() throws RemoteException {
		super();
		this.gestorAnteproyectos=new GestorAnteproyectosDAO();
	}

	@Override
	public ObjectDTO buscarAnteproyecto(String CodigoAnteproyecto) throws RemoteException {		
		NodoAnteproyectoDTO anteproyecto=null;		
		@SuppressWarnings("unchecked")
		Hashtable<String,String> objectA=(Hashtable<String,String>)this.gestorAnteproyectos.leerObjeto(CodigoAnteproyecto);
		if(objectA!=null) {
			anteproyecto=new NodoAnteproyectoDTO();
			anteproyecto.setModalidad(objectA.get(IConstantes.MODALIDAD));
			anteproyecto.setTitulo(objectA.get(IConstantes.TITULO));
			anteproyecto.setCodigo(objectA.get(IConstantes.CODIGO_ANTEPROYECTO));
			anteproyecto.setNombreEstudiante1(objectA.get(IConstantes.NOMBRE_EST_1));
			anteproyecto.setNombreEstudiante2(objectA.get(IConstantes.NOMBRE_EST_2));
			anteproyecto.setNombreDirector(objectA.get(IConstantes.NOMBRE_DIRECTOR));
			anteproyecto.setNombreCoDirector(objectA.get(IConstantes.NOMBRE_CO_DIRECTOR));
			anteproyecto.setFechaRegistro(objectA.get(IConstantes.FECHA_REGISTRO));
			anteproyecto.setFechaAprobacion(objectA.get(IConstantes.FECHA_APROBACION));
			anteproyecto.setConcepto(Integer.parseInt(objectA.get(IConstantes.CONCEPTO)));
			anteproyecto.setEstado(Integer.parseInt(objectA.get(IConstantes.ESTADO)));
			anteproyecto.setNumeroRevision(Integer.parseInt(objectA.get(IConstantes.NUMERO_REVISION)));
			
		}
		return anteproyecto;
	}

	//Si nno funciona, implementar la interfaz clonable en ListAnteproyecto
	@SuppressWarnings("unchecked")
	@Override
	public Vector listarAnteproyectos() throws RemoteException {
            Vector datos=null;
            ArrayList<Hashtable<String, String>> datas=null;
            AnteproyectoSimple nuevo=null;
            datas=(ArrayList<Hashtable<String, String>>)this.gestorAnteproyectos.listarObjetos();
            if (datas!=null) {	
                datos=new Vector();
                for(Hashtable<String, String> ant:datas) {
                    nuevo=new AnteproyectoSimple();
                    nuevo.setCodigo(ant.get(IConstantes.CODIGO_ANTEPROYECTO));
                    nuevo.setTitulo(ant.get(IConstantes.TITULO));
                    datos.add(nuevo);
                }
            }
            return datos;
	}

}
