
/***************************************\
*Clase Telefono de proyecto "Central	*
*Telefonica"							*
*Su funcion es emular el funcionamiento	*
*de un telefono. Podra realizar y     	*
*recibir llamadas.						*
*---------------------------------------*
*Funciones:								*
*										*
*-Telefono(constructor)					* 
*-run(ejecucion de los hilos)			*
*-llamar								*
*-descolgar								*
*-marcando								*
*-setNumero								*
*-private despertar						*
\***************************************/

public class Telefono extends Thread{
	
	
	private Central central;//necesario para poder mantener comunicacion con el objeto "central"
	private boolean dormido = true;//estado del telefono (colgado = true, descolgado = false).
	private short estado, numero, telefono;
	//"estado"puede tomar diversos valores:
	//-1: error de conexion con la central.
	//0: colgado y en espera;
	//1: descolgado.
	//2: marcando
	//3: llamando.
	//4: en espera
	//5: en una llamada.
	//6: colgado con llamada entrante.
	//7: el numero no existe o es el mismo.
	//8: no se pudo realizar la llamada.
	
	
	//----------------constructor de la clase--------------------
	public Telefono(Central central, short telefono){
		this.central = central;
		this.telefono = telefono;
		estado = 0;
	}

	//---------------Funcion que crea los hilos------------------
	public void run() {
		while(true) {
			this.llamar();//se ejecuta la funcion "llamar" hasta que el hilo muera.
		}
	}
	
	//-------Funcion que emula las funciones de un telefono------
	//Segmento de codigo marcado como sincronizado, lo que
	//permitira mantenerlo en espera hasta que sea llamada
	//la funcion correspondiente (descolgar).
	public synchronized void llamar() {
		
		//el ciclo se ejecutara si el telefono se encuentra colgado, en ese caso
		//se pondra en espera todo el hilo
		while(dormido) {//en caso de haber realizado su tarea, colgado se define a true
			try{
				System.out.println("Telefono " + telefono + " colgado.");
				wait();//el hilo entra es espera hasta que sea llamada a la funcion correspondiente 
			}catch(InterruptedException e) {}
		}
		
		//cuando se ha llamado a la funcion correspondiente (descolgar)
		//el hilo reanudara su ejecucion, y entrara a este segmento de codigo
		System.out.println("Telefono "+ telefono+" "+this.getId() +" descolgado."+estado);
		
		//entra si telefono ha descolgado
		if(estado == 1) {
			this.marcando();
			estado = 4;
			System.out.println("Piii-Piii-Piii...");
			estado = central.conexion(numero, telefono); //Despierta a la central para poder realizar la conexion

			if(estado == 5){	//Si estado es igual a 5 se realiza la llamada
				System.out.println("Hola ");
				System.out.println("bla bla bla");
			}else if(estado == 7){ // Si estado es igual a 7 manda mensaje de que no existe
				System.out.println("El numero que usted marco no existe, favor de verificarlo");
				System.out.println("Tuuu-Tuuu-Tuuu...");
			}else if(estado == 8){ //Si estado es igual a 8 manda mensaje de que esta ocupado
				System.out.println("El numero que usted marco no existe no se encuentra disponible, favor de llamar mas tarde");
				System.out.println("Tuuu-Tuuu-Tuuu...");
			}
		}else if(estado == 6){ //si estado es igual a 6 indica que contesto la llamada entrante
			estado = 5;
			System.out.println("Bueno ");
			System.out.println("bla bla bla bla bla");
		}
		estado = 0;
		dormido = true;
	}
	
	//-------funcion que indica se ha descolgado el telefono-----
	//La funcion es llamada desde la interfaz. Al ser llamada
	//despierta al hilo de la central, y llama a la funcion que
	//despierta al hilo del telefono en que ha sido llamada 
	//esta funcion.
	public void descolgar() {
		this.despertar();//Despierta el hilo del objeto telefono en que ha sido llamado.
		estado = 1;
		//estado = central.conectar();//Despierta el hilo de la central telefgonica, y verifica estado.
	}

	/**
	 * Tiene la funcion de que cuando recibe una llamada y 
	 * desculega el telefono para recibirla
	 * @param remitente
	 */
	public synchronized void descolgarPorLlamada(short remitente){
		System.out.println("Ring-Ring");
		System.out.println("Me estan llamando el Telefono " + remitente);
		estado = 6;
		this.despertar();	//despierta al hilo telefono
	}
	
	//-------funcion que espera el marcado de un numero---------
	//Duerme al hilo hasta que sea marcado un numero, y establece
	//el estado del telefono en 2 (marcando).
	//una vez se despierta el hilo, antes de finalizar la funcion,
	//se establece el estado a 3(llamando).
	public synchronized void marcando() {
		System.out.println("marcando");
		estado = 2;
		try {
			wait();//el hilo entra es espera hasta que sea llamada a la funcion correspondiente
		}catch(InterruptedException e) {}
		estado = 3;
		System.out.println("marcado al tel No: "+numero);
	}
	
	//----------------Establece el numero a marcar---------------
	//Se llama desde la interfaz para establecer el numero al que
	//se marcar�, adem�s de despertar al hilo para continuar con la llamada
	public void setNumero(short numero){
		this.numero = numero;
		this.despertar();
	}
	
	//----------funcion que reanuda el hilo----------------------
	//La funcion hace una llamada que permite reanudar la
	//ejecucion del hilo, ademas de configurar las variables
	//necesarias para su correcto funcionamiento.
	//y configura las variables necesarias al ser llamada
	private synchronized void despertar() {
		dormido = false;//la bandera pasa a indicar que el telefono está descolgado
		System.out.println("Me desperte -> " + telefono);
		notify();//llamada a la funcion que reanuda la ejecucion del hilo.
	}

	public synchronized boolean getDormido(){
		return dormido;
	}

	public synchronized short getTelefono(){
		return telefono;
	}

	public synchronized short getEstado(){
		return estado;
	}
}
