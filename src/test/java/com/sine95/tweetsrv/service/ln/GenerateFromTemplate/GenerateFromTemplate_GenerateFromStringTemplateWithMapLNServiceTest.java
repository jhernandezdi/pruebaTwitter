
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
public class GenerateFromTemplate_GenerateFromStringTemplateWithMapLNServiceTest extends GenerateFromTemplateLNServiceTest
{







    
	// Inicio tests metodo GenerateFromStringTemplateWithMap(template,model)
	/* Descripcion del metodo:
	* Devuelve El contenido la cadena del template después de haber hecho las sustituciones de los parámetros. El contenido se toma como una template de groovy.
	* Nota: el model debe ser un Map<String,Object>
	*/
      
	// Fin tests metodo GenerateFromStringTemplateWithMap(template,model)




/*


			throw new UnsupportedOperationException();


			//String template = ... ;

			//Object model = ... ;

			//res=serviceLN.GenerateFromStringTemplateWithMap( template,model ); 
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

			


		//Inserciones en BBDD o similares para probar el metodo
		


		//Limpiar lo generado en pre o en el metodo
		


*/
}

