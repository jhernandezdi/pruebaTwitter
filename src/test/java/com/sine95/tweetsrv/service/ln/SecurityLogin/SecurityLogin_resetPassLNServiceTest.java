
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
public class SecurityLogin_resetPassLNServiceTest extends SecurityLoginLNServiceTest
{







    
	// Inicio tests metodo resetPass(login)
	/* Descripcion del metodo:
	* Resetea el pass y envia correo
	*/
      
	// Fin tests metodo resetPass(login)




/*


*/
}

