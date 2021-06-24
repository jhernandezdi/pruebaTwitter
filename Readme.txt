Para lanzar la pr�ctica se puede importar la pr�ctica desde Eclipse y ejecutarla, o directamente desde l�nea de comandos.
Para ello primero habr�a que compilar el proyecto con la ayuda de un bat:
	compila.bat
	
Este script genera un .war

Para ejecutar desde l�nea de comandos:
	java -jar <nombre del war>
	
Una vez arrancado, empezar� a cargar tweets en la BD, seg�n los criterios espcificados en el fichero de configuraci�n:

	ConfigurationData.json
	
Los par�metros de inter�s a efectos de la pr�ctica son:
	NumMinSuscriptoresUsuarioParaPersistir
	IdiomasPermitidosParaPersistir
	MaxNumHashTags
	
El resto son par�metros adicionales de la arquitectura.

La BD es org.hsqldb. Es una BD SQL en memoria que viene embebida en Spring.

El acceso a los servicios vendr� a trav�s de las siguientes urls:

	http://localhost:8080/api/gestiontweets.Tweets              (Get)
	http://localhost:8080/api/gestiontweets.ValidarTweet/200    (Put) --> Cambiar el valor (200) por el id del tweet. Es un id secuencial, no el id real del tweet. Est� hecho as� para facilitar el uso del api rest en las pruebas
	http://localhost:8080/api/gestiontweets.TweetsValidos       (Get)
	http://localhost:8080/api/gestiontweets.HashtagsMasUsados   (Post) --> Poner content-type = application/json. Requiere un par�metro en el body: {"maxHashtags":<num_m�ximo>}  ; donde <num_m�ximo> es el n�mero m�ximo de hashtags que se devuelven. Si no se especifica (null), se toma el valor indicado en el fichero de configuraci�n
