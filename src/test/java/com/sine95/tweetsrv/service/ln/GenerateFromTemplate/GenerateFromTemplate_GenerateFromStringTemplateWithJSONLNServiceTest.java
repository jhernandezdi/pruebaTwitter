
package com.sine95.tweetsrv.service.ln.GenerateFromTemplate;


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







/**
* Logica de negocio para probar métodos privados
*/

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TweetsrvApp.class)
public class GenerateFromTemplate_GenerateFromStringTemplateWithJSONLNServiceTest extends GenerateFromTemplateLNServiceTest
{







    
	// Inicio tests metodo GenerateFromStringTemplateWithJSON(template,JSonStringParams)
	/* Descripcion del metodo:
	* Devuelve El contenido la cadena del template después de haber hecho las sustituciones de los parámetros. El contenido se toma como una template de groovy
	*/
      

	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo GenerateFromStringTemplateWithJSON(template,JSonStringParams)
	/**
	* Test de GenerateFromTemplateLNService.GenerateFromStringTemplateWithJSON(template,JSonStringParams)
	* ___________________________________________________
	* Probar con un json simple del estilo {"nombre":"JPGP","lista":[1,2,3,4],"obj":{"campo1":"val1","campo2":"val2"}}
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
	public void testGenerateFromStringTemplateWithJSON_GeneraDesdeFichero()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< String > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestGenerateFromStringTemplateWithJSON_GeneraDesdeFichero(ctx);
			
			throw new UnsupportedOperationException();


			//String template = ... ;

			//String JSonStringParams = ... ;

			//res=serviceLN.GenerateFromStringTemplateWithJSON( template,JSonStringParams ); 
			//if(res.isOk()){
			//	assertEquals(1,res.getData().getXXXX());
			//}
			//else {
			//	fail("El res no es válido");
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
			postTestGenerateFromStringTemplateWithJSON_GeneraDesdeFichero(ctx);
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
		File resource = getFileResourceOfClassMethod(this.getClass(),"GeneraDesdeFichero","json");// buca el recurso en el mismo path que la clase, con el nombre <nombreClase>_GeneraDesdeFichero.json
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
	public Map<String,Object> preTestGenerateFromStringTemplateWithJSON_GeneraDesdeFichero(Map<String,Object> ctx) throws Throwable
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
	public void postTestGenerateFromStringTemplateWithJSON_GeneraDesdeFichero(Map<String,Object> ctx)
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
	// Fin test y funciones auxiliares del metodo GenerateFromStringTemplateWithJSON



	// Fin tests metodo GenerateFromStringTemplateWithJSON(template,JSonStringParams)




/*


*/
}


