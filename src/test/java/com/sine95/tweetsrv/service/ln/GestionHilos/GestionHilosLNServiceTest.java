
package com.sine95.tweetsrv.service.ln.GestionHilos;


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


//textual
import org.sine95.kernel.base.task.ITicket;
    
//obj    
import com.sine95.tweetsrv.domain.ParamInCambiaPosTarea;
    
//obj    
import com.sine95.tweetsrv.domain.ParamOutITicket;
    
//obj    
import com.sine95.tweetsrv.domain.ParamOutTasks;
    
//enum

import com.sine95.tweetsrv.enums.ColaHilos;
    
//enum

import com.sine95.tweetsrv.enums.TareasPeriodicas;
    


import com.sine95.tweetsrv.service.ln.GestionHilosLNService;




/**
* Lógica de negocio para la gestion de los Hilos de tareas asíncronas mediante Threads
*/

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TweetsrvApp.class)
@Transactional
public class GestionHilosLNServiceTest extends BaseTest
{



    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;


    @Autowired
    protected GestionHilosLNService serviceLN;

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
