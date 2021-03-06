
package com.sine95.tweetsrv.service.ln.hilos.taskperiodica_tarea_lecturaperiodicadetweets;


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
import org.springframework.context.ApplicationContext;
import java.io.File;

import java.util.*;





/**
* Una vez por minuto se revisan los tweets a descargar
*/

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TweetsrvApp.class)
public class TaskPeriodica_Tarea_LecturaPeriodicaDeTweetsTest extends BaseTest
{

    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;

    @Autowired
    protected ConfigurationServiceCRUD configService;
    
    @Autowired
    protected UtilDB udb;
    
    


    @Before
    public void init(){
      

    }










/*


*/
}
