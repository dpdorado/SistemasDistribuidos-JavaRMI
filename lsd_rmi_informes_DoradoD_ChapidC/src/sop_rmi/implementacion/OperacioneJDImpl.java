package sop_rmi.implementacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;

import servidor.dao.GestorObjetoDAO;
import servidor.dto.ObjectDTO;
import servidor.dto.ObjetosDTO.AnteproyectoCompletoDTO;
import servidor.dto.ObjetosDTO.EvaluadoresDTO;
import servidor.dto.ObjetosDTO.ModificarConceptoAnteproyecto;
import servidor.dto.ObjetosDTO.NodoAnteproyectoDTO;
import servidor.dto.ObjetosDTO.RespuestaG;
import servidor.dto.ObjetosDTO.UsuarioDTO;
import sop_rmi.interfaces.LoguearInt;
import sop_rmi.interfaces.OperacionesJDInt;
import servidor.utilidades.persistencia.GestorAnteproyectosDAO;
import servidor.utilidades.persistencia.GestorEvaluadoresDAO;
import servidor.utilidades.persistencia.GestorUsuariosDAO;
import servidor.utilidades.persistencia.IConstantes;
import sop_rmi.callback.clienteCallbackInt;

public class OperacioneJDImpl extends UnicastRemoteObject implements OperacionesJDInt{
        
        private ArrayList<clienteCallbackInt> objsCallback;
	private GestorObjetoDAO gestorAnteproyectos;
	private GestorObjetoDAO gestorUsuarios;
	private GestorObjetoDAO gestorEvaluadores;
	
	public OperacioneJDImpl() throws RemoteException {
		super();
		this.gestorAnteproyectos=new GestorAnteproyectosDAO();
		this.gestorUsuarios=new GestorUsuariosDAO();
		this.gestorEvaluadores=new GestorEvaluadoresDAO();
                objsCallback=new ArrayList<clienteCallbackInt> ();
	}


        @Override
	public ObjectDTO registrarUsuario(ObjectDTO datosUser) throws RemoteException {
		RespuestaG respuesta=new RespuestaG();
		UsuarioDTO user=(UsuarioDTO)datosUser;
		Hashtable<String,String> object=new Hashtable<String,String>(); 
		object.put(IConstantes.NOMBRES_APELLIDOS,user.getNombresApellidos());
		object.put(IConstantes.IDENTIFICACION, user.getIdentificacion());
		object.put(IConstantes.USUARIO, user.getUsuario());
		object.put(IConstantes.CONTRASENIA, user.getContrasenia());
		object.put(IConstantes.TIPO_USUARIO, Integer.toString(user.getTipoUser()));
		respuesta.setOperacionExito(this.gestorUsuarios.registrarObjeto(object));
		if(respuesta.isOperacionExito()) {
			respuesta.setMensaje("Registro exitoso.");
		}else {
			respuesta.setMensaje("No se realizo el registro, puede ser que el id o el usuario ya existan.");
		}
		return respuesta;
	}


        @Override
	public ObjectDTO registrarAnteproyecto(ObjectDTO datosAnteproyecto) throws RemoteException {
		RespuestaG respuesta=new RespuestaG();
		NodoAnteproyectoDTO anteproyecto=(NodoAnteproyectoDTO)datosAnteproyecto;
		Hashtable<String,String> object=new Hashtable<String,String>(); 
		object.put(IConstantes.MODALIDAD,anteproyecto.getModalidad());
		object.put(IConstantes.TITULO,anteproyecto.getTitulo());
		object.put(IConstantes.CODIGO_ANTEPROYECTO,anteproyecto.getCodigo());
		object.put(IConstantes.NOMBRE_EST_1,anteproyecto.getNombreEstudiante1());
		object.put(IConstantes.NOMBRE_EST_2,anteproyecto.getNombreEstudiante2());
		object.put(IConstantes.NOMBRE_DIRECTOR,anteproyecto.getNombreDirector());
		object.put(IConstantes.NOMBRE_CO_DIRECTOR,anteproyecto.getNombreCoDirector());
		object.put(IConstantes.FECHA_REGISTRO,anteproyecto.getFechaRegistro());
		object.put(IConstantes.FECHA_APROBACION,anteproyecto.getFechaAprobacion());
		object.put(IConstantes.CONCEPTO,Integer.toString(anteproyecto.getConcepto()));
		object.put(IConstantes.ESTADO,Integer.toString(anteproyecto.getEstado()));
		object.put(IConstantes.NUMERO_REVISION,Integer.toString(anteproyecto.getNumeroRevision()));		
		respuesta.setOperacionExito(this.gestorAnteproyectos.registrarObjeto(object));
		if(respuesta.isOperacionExito()) {
			respuesta.setMensaje("Registro exitoso.");
		}else {
			respuesta.setMensaje("No se realizo el registro, puede ser que el codigo del anteproyecto ya este registrado.");
		}
		return respuesta;
	}
	

	//Nificar->CallBack

        @Override
	public ObjectDTO asignarEvaluadores(ObjectDTO datosEvaluadores) throws RemoteException {
		RespuestaG respuesta=new RespuestaG();
		EvaluadoresDTO evaluadores=(EvaluadoresDTO)datosEvaluadores;
		Hashtable<String,String> object=new Hashtable<String,String>(); 		
		object.put(IConstantes.CODIGO_ANTEPROYECTO,evaluadores.getCodigoAnteproyecto());
		object.put(IConstantes.NOMBRE_EVAL_1,evaluadores.getNombreEvaluador1());
		object.put(IConstantes.CONCEPTO_EVAL_1,evaluadores.getConceptoEvaluador1());
		object.put(IConstantes.FECHA_REVISION_1,evaluadores.getFechaRevision1());
		object.put(IConstantes.NOMBRE_EVAL_2,evaluadores.getNombreEvaluador2());
		object.put(IConstantes.CONCEPTO_EVAL_2,evaluadores.getConceptoEvaluador2());
		object.put(IConstantes.FECHA_REVISION_2,evaluadores.getFechaRevision2());
		respuesta.setOperacionExito(this.gestorEvaluadores.registrarObjeto(object));
		if(respuesta.isOperacionExito()) {
                        String message=evaluadores.getCodigoAnteproyecto()+" y evaluadore:"+evaluadores.getNombreEvaluador1()+","+evaluadores.getConceptoEvaluador2();
			respuesta.setMensaje("Se asignaron los evaluadores.");
                        doCallbacks(message);
		}else {
			respuesta.setMensaje("No se pudo realizar la asignaci�n, verifique que el anteproyecto no tenga evaluadores asignados.");
		}
		return respuesta;
	}
	
	
        @Override
	public ObjectDTO buscarAnteproyceto(String codigoAnteproyecto) throws RemoteException {
		AnteproyectoCompletoDTO anteproyectosC=new AnteproyectoCompletoDTO();
		NodoAnteproyectoDTO anteproyecto=null;
		EvaluadoresDTO evaluadores=null;
		@SuppressWarnings("unchecked")
		Hashtable<String,String> objectA=(Hashtable<String,String>)this.gestorAnteproyectos.leerObjeto(codigoAnteproyecto);
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
			@SuppressWarnings("unchecked")
			Hashtable<String,String> objectE=(Hashtable<String,String>)this.gestorEvaluadores.leerObjeto(codigoAnteproyecto);
			if(objectE!=null) {
				evaluadores=new EvaluadoresDTO();
				evaluadores.setCodigoAnteproyecto(objectE.get(IConstantes.CODIGO_ANTEPROYECTO));
				evaluadores.setNombreEvaluador1(objectE.get(IConstantes.NOMBRE_EVAL_1));
				evaluadores.setConceptoEvaluador1(objectE.get(IConstantes.CONCEPTO_EVAL_1));
				evaluadores.setFechaRevision1(objectE.get(IConstantes.FECHA_REVISION_1));
				evaluadores.setNombreEvaluador2(objectE.get(IConstantes.NOMBRE_EVAL_2));
				evaluadores.setConceptoEvaluador2(objectE.get(IConstantes.CONCEPTO_EVAL_2));
				evaluadores.setFechaRevision2(objectE.get(IConstantes.FECHA_REVISION_2));						
			}
		}
		anteproyectosC.setAnteproyecto(anteproyecto);
		anteproyectosC.setEvaluadores(evaluadores);
		return anteproyectosC;
	}


        @Override
	public ObjectDTO modificarConceptoAnteproyecto(ObjectDTO datosModificacion) throws RemoteException {
		RespuestaG respuesta=new RespuestaG();		
		ModificarConceptoAnteproyecto datas=(ModificarConceptoAnteproyecto)datosModificacion;
		Hashtable<String,String> object=new Hashtable<String,String>(); 
		object.put(IConstantes.CODIGO_ANTEPROYECTO, datas.getCodigoAnteproyecto());
		object.put(IConstantes.CONCEPTO, Integer.toString(datas.getNuevoConcepto()));
		respuesta.setOperacionExito(this.gestorAnteproyectos.editarObjeto(object));
		if(respuesta.isOperacionExito()) {
			respuesta.setMensaje("Se realizó el cambio de concepto del anteproyecto.");
		}else {
			respuesta.setMensaje("No se pudo realizar la modificación, contacte con eladministrador.");
		}
		return respuesta;
	}

    @Override
    public String notify(String message) throws RemoteException {
        return message;
    }

    @Override
    public void registerForCallback(clienteCallbackInt callbackClientObject) throws RemoteException {
        if (!(objsCallback.contains(callbackClientObject))){
           objsCallback.add(callbackClientObject);        
        } 
    }

    @Override
    public void unregisterForCallback(clienteCallbackInt callbackClientObject) throws RemoteException {
        if (objsCallback.remove(callbackClientObject)) {
            System.out.println("Unregistered client. ");
        } else {
            System.out.println("unregister: client wasn't registered.");
        } 
    }
    
    //message codigo y evaluador nombre
    private void doCallbacks(String message) throws RemoteException{
        for(clienteCallbackInt cli:this.objsCallback){
            cli.notifyMe(message);
        }            
    } 
    

}
