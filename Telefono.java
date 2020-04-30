/***************************************\
*Clase Telefono de proyecto "Central	*
*Telefonica"				*
*Su funcion es emular el funncionamiento*
*de un telefono. Podrá realizar y     	*
* recibir llamadas			*
\***************************************/

public class Telefono extends Thread{
	
	
	
	//Constructor de telefono, no requiere parametros al ser creado.
	public Telefono(){}

	public void run() {
		System.out.println("soy un telefono");
	}
}
