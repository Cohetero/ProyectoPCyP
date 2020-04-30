/***************************************\
*Clase Telefono de proyecto "Central	*
*Telefonica"							*
*Su funcion es emular el funcionamiento	*
*de un telefono. Podrá realizar y     	*
*recibir llamadas.						*
\***************************************/

public class Telefono extends Thread{
	
	
	private Central central;//necesario para poder mantener comunicacion con el objeto "central"
	private boolean colgado = true;//estado del telefono (colgado, descolgado).
	
	//----------------constructor de la clase--------------------
	public Telefono(Central central){
		this.central = central;
	}

	//---------------Funcion que crea los hilos------------------
	public void run() {
		while(true) {
			this.llamar();//se ejecuta la funcion "llamar" hasta que el hilo muera.
		}
	}
	
	//-------Funcion que emula las funciones de un telefono------
	//Segmento de codigo marcado como sincronizado, lo que
	//permitirá mantenerlo en espera hasta que sea llamada
	//la funcion correspondiente (descolgar).
	private synchronized void llamar() {
		
		//boolean estado = false;
		//int numero = -1;
		
		//el ciclo se ejecutará si el telefono se encuentra colgado, en ese caso
		//se pondrá en espera todo el hilo
		while(colgado) {//en caso de haber realizado su tarea, colgado se define a true
			try{
				System.out.println("Telefono colgado.");
				wait();//el hilo entra es espera hasta que sea llamada a la funcion correspondiente 
			}catch(InterruptedException e) {}
		}
		
		//cuando se hallamado a la funcion correspondiente (descolgar)
		//el hilo reanudará su ejecucion, y entrará a este segmento de codigo
		System.out.println("Telefono descolgado.");
		/*estado = central.verificar();
		if(estado) {
			central.marcar(numero);
		}*/
		colgado = true;
	}
	
	//----------funcion que reanuda el hilo----------------------
	//La funcion hace una llamada que permite reanudar la
	//ejecucion del hilo, además de configurar las variables
	//necesarias para su correcto funcionamiento.
	//y configura las variables necesarias al ser llamada
	public synchronized void descolgar() {
		colgado = false;//la bandera pasa a indicar que el telefono está descolgado
		notify();//llamada a la funcion que reanuda la ejecucion del hilo.
	}
}
