
package com.sine95.tweetsrv.web.rest;

import com.sine95.tweetsrv.domain.*;
import com.sine95.tweetsrv.repository.*;
import com.sine95.tweetsrv.service.crud.*;
import java.net.URISyntaxException;
import java.util.*;
import javax.validation.Valid;
import javax.transaction.Transactional;

import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.ResultExt;
import org.sine95.kernel.base.Contexto;

import org.sine95.kernel.base.web.rest.ControllerBase;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.sine95.tweetsrv.errores.ErrorGeneral;
import com.sine95.tweetsrv.errores.ErrorSinPermiso;
import com.codahale.metrics.annotation.Timed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing Hashtags.
 */
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class HashtagsRest extends ControllerBase {

    private final Logger log = LoggerFactory.getLogger(HashtagsRest.class);

//    private static final String ENTITY_NAME = "hashtags";

    private final HashtagsRepository repository;
    private final HashtagsServiceCRUD service;

    public HashtagsRest(HashtagsRepository repository,HashtagsServiceCRUD service) {
        this.repository = repository;
        this.service = service;
    }


//import io.github.jhipster.web.util.ResponseUtil;



	/**
	 * POST  /hashtags : Cear un objeto de tipo Hashtags nuevo.
	 *
	 * @param obj el Hashtags a crear
	 * @return Un ResponseEntity con estado 201 (Created) y con el cuerpo (body) del nuevo Hashtags, o con el estado 400 (Bad Request) si el  Hashtags tiene un ID preexistente
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PostMapping("/hashtags")
	@Timed

	@Transactional
	
	public ResultExt< HashtagsPoj> create(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody HashtagsPoj obj)
	{
		
		String params=UtilParams.paramsToString("HashtagsPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_HASHTAGS_CREATE");
		ctx.put(Contexto.URL_SOLICITADA,"/hashtags");
		Result< HashtagsPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:create("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_HASHTAGS_CREATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_HASHTAGS_CREATE","/hashtags"));
			}
			else
			{
				params=UtilParams.paramsToString("HashtagsPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:create("+params+")"+params);

				Hashtags obj_ = HashtagsPoj.getModel(obj);

				Result< Hashtags > res_=service.insert(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new HashtagsPoj(res_.getData()):null);

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:create("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:create("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:create("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< HashtagsPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * PUT  /hashtags : Actualiza (Update) un objeto preexistente  (Hashtags).
	 *
	 * @param obj El objeto de tipo Hashtags a modificar
	 * @return El ResponseEntity con estado 200 (OK) y con el cuerpo (body) actualizado Hashtags,
	 * o con estado 400 (Bad Request) si el objeto de tipo Hashtags no es valido,
	 * o con estado 500 (Internal Server Error) si el objeto de tipo Hashtags no puede ser actualizado
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PutMapping("/hashtags")
	@Timed

	@Transactional
	
	public ResultExt< HashtagsPoj> update(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody HashtagsPoj obj)
	{
		
		String params=UtilParams.paramsToString("HashtagsPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_HASHTAGS_UPDATE");
		ctx.put(Contexto.URL_SOLICITADA,"/hashtags");
		Result< HashtagsPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:update("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_HASHTAGS_UPDATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_HASHTAGS_UPDATE","/hashtags"));
			}
			else
			{
				params=UtilParams.paramsToString("HashtagsPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:update("+params+")"+params);

				Hashtags obj_ = HashtagsPoj.getModel(obj);

				Result< Hashtags > res_=service.update(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new HashtagsPoj(res_.getData()):null);

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:update("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:update("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST PUT:update("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< HashtagsPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /hashtags : obtener todos los objetos de tipo Hashtags.
	 *
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo hashtags en el cuerpo (body)
	 */

	@GetMapping("/hashtags")
	@Timed
	
	public ResultExt< List< HashtagsPoj >> getAll(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_HASHTAGS_GETALL");
		ctx.put(Contexto.URL_SOLICITADA,"/hashtags");
		Result< List< HashtagsPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:getAll("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_HASHTAGS_GETALL"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_HASHTAGS_GETALL","/hashtags"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:getAll("+params+")"+params);

				Result< List< Hashtags > > res_=service.findAll();
				res.setInfoEWI(res_);

				res.setData( HashtagsPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:getAll("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:getAll("+params+"). Resultado:"+res.toString());

		ResultExt< List< HashtagsPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /hashtags : obtener todos los objetos de tipo Hashtags.
	 *
	 * @param pageable informacion de paginacion
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo hashtags en el cuerpo (body)
	 */

	@PostMapping("/hashtags.pag")
	@Timed
	
	public ResultExt< Page< HashtagsPoj >> getAllPag(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody HashtagsCritPaged pag)
	{
		
		String params=UtilParams.paramsToString("HashtagsCritPaged",pag);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_HASHTAGS_GETALLPAG");
		ctx.put(Contexto.URL_SOLICITADA,"/hashtags.pag");
		Result< Page< HashtagsPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getAllPag("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_HASHTAGS_GETALLPAG"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_HASHTAGS_GETALLPAG","/hashtags.pag"));
			}
			else
			{
				params=UtilParams.paramsToString("HashtagsCritPaged",pag);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getAllPag("+params+")"+params);

				HashtagsCritPaged pag_ = pag;

				Result< Page< Hashtags > > res_=service.findAll(pag_);
				res.setInfoEWI(res_);

				res.setData(HashtagsPoj.toPOJOPage(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:getAllPag("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:getAllPag("+params+"). Resultado:"+res.toString());

		ResultExt< Page< HashtagsPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /hashtags/:id : obtiene el objeto con el "id" de tipo Hashtags.
	 *
	 * @param id el id del tipo Hashtags a devolver
	 * @return la ResponseEntity con estado 200 (OK) con el cuerpo (body) del tipo Hashtags, o con estado 404 (Not Found)
	 */

	@GetMapping("/hashtags/{id1}")
	@Timed
	
	public ResultExt< HashtagsPoj> get(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_HASHTAGS_GET");
		ctx.put(Contexto.URL_SOLICITADA,"/hashtags/{id1}");
		Result< HashtagsPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:get("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_HASHTAGS_GET"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_HASHTAGS_GET","/hashtags/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1);
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:get("+params+")"+params);

				Long id1_ = id1;

				Result< Hashtags > res_=service.findWithResult(id1_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new HashtagsPoj(res_.getData()):null);

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:get("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:get("+params+"). Resultado:"+res.toString());

		ResultExt< HashtagsPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /hashtags : devuelve los objetos de tipo hashtags filtrados por el criterio y paginados.
	 *
	 * @param pageable la informacion de paginacion
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo hashtags en el cuerpo (body)
	 */

	@PostMapping("/hashtags.querypaged")
	@Timed

	@Transactional
	
	public ResultExt< Page< HashtagsPoj >> queryCritPaged(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody HashtagsCritPaged param)
	{
		
		String params=UtilParams.paramsToString("HashtagsCritPaged",param);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_HASHTAGS_QUERYCRITPAGED");
		ctx.put(Contexto.URL_SOLICITADA,"/hashtags.querypaged");
		Result< Page< HashtagsPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:queryCritPaged("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_HASHTAGS_QUERYCRITPAGED"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_HASHTAGS_QUERYCRITPAGED","/hashtags.querypaged"));
			}
			else
			{
				params=UtilParams.paramsToString("HashtagsCritPaged",param);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:queryCritPaged("+params+")"+params);

				HashtagsCritPaged param_ = param;

				Result< Page< Hashtags > > res_=service.listByCriteriaPaged(param_);
				res.setInfoEWI(res_);

				res.setData(HashtagsPoj.toPOJOPage(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:queryCritPaged("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:queryCritPaged("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:queryCritPaged("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< Page< HashtagsPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /hashtags : devuelve los objetos de tipo hashtags filtrados por el criterio.
	 *
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo hashtags en el cuerpo (body)
	 */

	@PostMapping("/hashtags.query")
	@Timed

	@Transactional
	
	public ResultExt< List< HashtagsPoj >> getCrit2(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody HashtagsCrit criteria)
	{
		
		String params=UtilParams.paramsToString("HashtagsCrit",criteria);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_HASHTAGS_GETCRIT2");
		ctx.put(Contexto.URL_SOLICITADA,"/hashtags.query");
		Result< List< HashtagsPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getCrit2("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_HASHTAGS_GETCRIT2"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_HASHTAGS_GETCRIT2","/hashtags.query"));
			}
			else
			{
				params=UtilParams.paramsToString("HashtagsCrit",criteria);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getCrit2("+params+")"+params);

				HashtagsCrit criteria_ = criteria;

				Result< List< Hashtags > > res_=service.listByCriteria(criteria_);
				res.setInfoEWI(res_);

				res.setData( HashtagsPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:getCrit2("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:getCrit2("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:getCrit2("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< List< HashtagsPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * DELETE  /hashtags/:id : elimina el objeto de id "id" Hashtags.
	 *
	 * @param id el id del objeto de tipo Hashtags a borrar
	 * @return la ResponseEntity con estado 200 (OK)
	 */

	@DeleteMapping("/hashtags/{id1}")
	@Timed

	@Transactional
	
	public ResultExt< Vacio> delete(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_HASHTAGS_DELETE");
		ctx.put(Contexto.URL_SOLICITADA,"/hashtags/{id1}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST DELETE:delete("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_HASHTAGS_DELETE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_HASHTAGS_DELETE","/hashtags/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1);
				if (log.isInfoEnabled()) log.info("Verificado en REST DELETE:delete("+params+")"+params);

				Long id1_ = id1;

				Result< Vacio > res_=service.delete(id1_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST DELETE:delete("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST DELETE:delete("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST DELETE:delete("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



// Metodos para gestionar las relaciones

// FIN de metodos para gestionar las relaciones
// LN de CRUD

// FIN LN de CRUD




//Si hay que anadir metodos se incluyen aqui,
// se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}

