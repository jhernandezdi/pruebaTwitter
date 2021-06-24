
package com.sine95.tweetsrv.service.ln.Cache;


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
import com.sine95.tweetsrv.domain.Configuration;
import com.sine95.tweetsrv.domain.ConfigurationCrit;
import com.sine95.tweetsrv.domain.ConfigurationCritPaged;
import com.sine95.tweetsrv.service.crud.ConfigurationServiceCRUD;

//import com.sine95.tweetsrv.domain.ConfigurationExt;
import com.sine95.tweetsrv.domain.ConfigurationExt;

//entity
import com.sine95.tweetsrv.domain.J314User;
import com.sine95.tweetsrv.domain.J314UserCrit;
import com.sine95.tweetsrv.domain.J314UserCritPaged;
import com.sine95.tweetsrv.service.crud.J314UserServiceCRUD;

//import com.sine95.tweetsrv.domain.J314UserExt;
import com.sine95.tweetsrv.domain.J314UserExt;

//enum

import com.sine95.tweetsrv.enums.AreasCache;
    





/**
* Lógica de negocio para la gestión caches
*/

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TweetsrvApp.class)
public class Cache_resetAreaLNServiceTest extends CacheLNServiceTest
{







    
	// Inicio tests metodo resetArea(area)
	/* Descripcion del metodo:
	* Vacia la cache del area seleccionada
	*/
      
	// Fin tests metodo resetArea(area)




/*


*/
}


