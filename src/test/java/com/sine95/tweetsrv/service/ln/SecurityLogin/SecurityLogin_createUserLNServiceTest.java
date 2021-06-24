
package com.sine95.tweetsrv.service.ln.SecurityLogin;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import com.sine95.tweetsrv.TweetsrvApp;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.sine95.kernel.base.Result;
import com.sine95.tweetsrv.errores.*;
import com.sine95.tweetsrv.warnings.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import org.sine95.kernel.base.test.*;
import com.sine95.tweetsrv.service.Config;
import com.sine95.tweetsrv.service.crud.ConfigurationServiceCRUD;
import com.sine95.tweetsrv.repository.UtilDB;
import com.sine95.tweetsrv.domain.Configuration;
import org.sine95.kernel.base.Contexto;

import java.util.*;
import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;


//entity
import com.sine95.tweetsrv.domain.J314User;
import com.sine95.tweetsrv.domain.J314UserCrit;
import com.sine95.tweetsrv.domain.J314UserCritPaged;
import com.sine95.tweetsrv.service.crud.J314UserServiceCRUD;

//import com.sine95.tweetsrv.domain.J314UserExt;
import com.sine95.tweetsrv.domain.J314UserExt;

//entity
import com.sine95.tweetsrv.domain.J314UserAuthority;
import com.sine95.tweetsrv.domain.J314UserAuthorityCrit;
import com.sine95.tweetsrv.domain.J314UserAuthorityCritPaged;
import com.sine95.tweetsrv.service.crud.J314UserAuthorityServiceCRUD;

//entity
import com.sine95.tweetsrv.domain.SecurityGroup;
import com.sine95.tweetsrv.domain.SecurityGroupCrit;
import com.sine95.tweetsrv.domain.SecurityGroupCritPaged;
import com.sine95.tweetsrv.service.crud.SecurityGroupServiceCRUD;

//import com.sine95.tweetsrv.domain.SecurityGroupExt;
import com.sine95.tweetsrv.domain.SecurityGroupExt;

//obj    
import com.sine95.tweetsrv.domain.ResLogin;
    
//obj    
import com.sine95.tweetsrv.domain.InfoUser;
    
//enum

import com.sine95.tweetsrv.enums.SiNo;
    





/**
* Logica de negocio para el login y asociados
*/

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TweetsrvApp.class)
public class SecurityLogin_createUserLNServiceTest extends SecurityLoginLNServiceTest
{







    
	// Inicio tests metodo createUser(user)
	/* Descripcion del metodo:
	* Realiza la creacion del usuario. Error login duplicado
	*/
      

	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo createUser(user)
	/**
	* Test de SecurityLoginLNService.createUser(user)
	* ___________________________________________________
	* Se crea el usuario sin problema
	* ___________________________________________________
	* Recordatorio: tambien hay que probar casos de error
	* ayudas:
	*
	* Para crear Fechas (Date) de una determinada fecha:
	* Date fechaIni=sdfFechaCompleta.parse("2019-07-07T00:00:00+0000");
	*
	* Para verificar errores:
	*	assertEquals(1, res.getErrores().size());
	*	assertEquals(<ClaseDeError>.class, res.getErrores().get(0).getClass());
	*/
	@Test
	@Transactional
	public void testCreateUser_CreacionValida()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< J314User > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestCreateUser_CreacionValida(ctx);
			
			throw new UnsupportedOperationException();


			//J314User user = ... ;

			//res=serviceLN.createUser( user ); 
			//Comprobacion todo correcto
			//if(res.isOk()){
			//	assertEquals(1,res.getData().getXXXX());
			//}
			//else {
			//	fail("El res no es válido");
			//}

			//Comprobacion de tipo Error
			//if(res.isOk()){
			//	fail("El res no es válido");
			//}
			//else {
			//	assertEquals("Deberia dar un error de tipo <TipoError>",1,UtilError.findErrorByType(res.getErrores(), <TipoError>.class).size());
			//}

			
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Throwable e)
		{
			fail("Se ha levantado la siguiente excepción:"+UtilException.printStackTrace(e));
		}
		finally
		{
			postTestCreateUser_CreacionValida(ctx);
		}
	}
	/*
	Ayuda: 
		Para insertar en BD un usuario con uno o mas roles y meterlo en sesion:
		Long numIdUser=inyectaUsuarioEnSesionYBD(udb,userSevice "usuario",new String[]{"roles"});

		para insertar datos en BD
		udb.insert(<cadena>) o udb.insert(new File(<fichero))
		
		Para pasar datos al resto del test, usar ctx, que se devuelve 

		La forma mas habitual sera la siguiente:
		File resource = getFileResourceOfClassMethod(this.getClass(),"CreacionValida","json");// buca el recurso en el mismo path que la clase, con el nombre <nombreClase>_CreacionValida.json
		if(!resource.exists())
		{
			fail("Fichero de recursos "+resource.getAbsolutePath()+" no encontrado");
		}
		else {
			udb.truncate(resource);
			udb.insert(resource);
			Contexto con=Contexto.get();
			inyectaUsuarioYRolesEnSesion("admin",new String[] {"ADMIN","USER"}); // esta linea si se necesita el usuario en sesion
			ctx.put("fichero", resource); // pasar el fichero a la parte de post
		}
	*/
	public Map<String,Object> preTestCreateUser_CreacionValida(Map<String,Object> ctx) throws Throwable
	{
		
		//Inserciones en BBDD o similares para probar el metodo
		
		return ctx;
	}
	/*
		Ayuda:
		Para vaciar BD:
		try {
			udb.truncate(new String[] {"jhi_user_authority","jhi_authority","jhi_user"});
		} catch (Throwable e) {
			
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
		En este ejemplo se incluyen los de usuarios, cuidado con el orden de los datos

		La forma mas comun sera:
		File resource=(File) ctx.get("fichero"); //obtiene el recurso empleado en el preTest
		if(resource!=null )
		{
			if(resource.exists())
			{
				udb.truncate(resource);//invierte las tablas y hace el truncate de cada uno de ellas
			}
			else {
				fail("Fichero de recursos "+resource.getAbsolutePath()+" no encontrado");//si no lo encuentra esta mal el test
			}
		}
	*/
	public void postTestCreateUser_CreacionValida(Map<String,Object> ctx)
	{
		try {
		
		
		//Limpiar lo generado en pre o en el metodo
		
		Contexto.close();
		ctx.clear();
		} catch (Throwable e) {	
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
	}
	// Fin test y funciones auxiliares del metodo createUser




	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo createUser(user)
	/**
	* Test de SecurityLoginLNService.createUser(user)
	* ___________________________________________________
	* Da error de login duplicado
	* ___________________________________________________
	* Recordatorio: tambien hay que probar casos de error
	* ayudas:
	*
	* Para crear Fechas (Date) de una determinada fecha:
	* Date fechaIni=sdfFechaCompleta.parse("2019-07-07T00:00:00+0000");
	*
	* Para verificar errores:
	*	assertEquals(1, res.getErrores().size());
	*	assertEquals(<ClaseDeError>.class, res.getErrores().get(0).getClass());
	*/
	@Test
	@Transactional
	public void testCreateUser_CreacionErroneaPorLoginDuplicado()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< J314User > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestCreateUser_CreacionErroneaPorLoginDuplicado(ctx);
			
			throw new UnsupportedOperationException();


			//J314User user = ... ;

			//res=serviceLN.createUser( user ); 
			//Comprobacion todo correcto
			//if(res.isOk()){
			//	assertEquals(1,res.getData().getXXXX());
			//}
			//else {
			//	fail("El res no es válido");
			//}

			//Comprobacion de tipo Error
			//if(res.isOk()){
			//	fail("El res no es válido");
			//}
			//else {
			//	assertEquals("Deberia dar un error de tipo <TipoError>",1,UtilError.findErrorByType(res.getErrores(), <TipoError>.class).size());
			//}

			
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Throwable e)
		{
			fail("Se ha levantado la siguiente excepción:"+UtilException.printStackTrace(e));
		}
		finally
		{
			postTestCreateUser_CreacionErroneaPorLoginDuplicado(ctx);
		}
	}
	/*
	Ayuda: 
		Para insertar en BD un usuario con uno o mas roles y meterlo en sesion:
		Long numIdUser=inyectaUsuarioEnSesionYBD(udb,userSevice "usuario",new String[]{"roles"});

		para insertar datos en BD
		udb.insert(<cadena>) o udb.insert(new File(<fichero))
		
		Para pasar datos al resto del test, usar ctx, que se devuelve 

		La forma mas habitual sera la siguiente:
		File resource = getFileResourceOfClassMethod(this.getClass(),"CreacionErroneaPorLoginDuplicado","json");// buca el recurso en el mismo path que la clase, con el nombre <nombreClase>_CreacionErroneaPorLoginDuplicado.json
		if(!resource.exists())
		{
			fail("Fichero de recursos "+resource.getAbsolutePath()+" no encontrado");
		}
		else {
			udb.truncate(resource);
			udb.insert(resource);
			Contexto con=Contexto.get();
			inyectaUsuarioYRolesEnSesion("admin",new String[] {"ADMIN","USER"}); // esta linea si se necesita el usuario en sesion
			ctx.put("fichero", resource); // pasar el fichero a la parte de post
		}
	*/
	public Map<String,Object> preTestCreateUser_CreacionErroneaPorLoginDuplicado(Map<String,Object> ctx) throws Throwable
	{
		
		//Inserciones en BBDD o similares para probar el metodo
		
		return ctx;
	}
	/*
		Ayuda:
		Para vaciar BD:
		try {
			udb.truncate(new String[] {"jhi_user_authority","jhi_authority","jhi_user"});
		} catch (Throwable e) {
			
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
		En este ejemplo se incluyen los de usuarios, cuidado con el orden de los datos

		La forma mas comun sera:
		File resource=(File) ctx.get("fichero"); //obtiene el recurso empleado en el preTest
		if(resource!=null )
		{
			if(resource.exists())
			{
				udb.truncate(resource);//invierte las tablas y hace el truncate de cada uno de ellas
			}
			else {
				fail("Fichero de recursos "+resource.getAbsolutePath()+" no encontrado");//si no lo encuentra esta mal el test
			}
		}
	*/
	public void postTestCreateUser_CreacionErroneaPorLoginDuplicado(Map<String,Object> ctx)
	{
		try {
		
		
		//Limpiar lo generado en pre o en el metodo
		
		Contexto.close();
		ctx.clear();
		} catch (Throwable e) {	
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
	}
	// Fin test y funciones auxiliares del metodo createUser



	// Fin tests metodo createUser(user)




/*


*/
}


