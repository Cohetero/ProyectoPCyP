
/***************************************\
*Clase Telefono de proyecto "Central	*
*Telefonica"                            *
*Su funcion es emular el funcionamiento	*
*de un telefono. Podra realizar y     	*
*recibir llamadas.                      *
*---------------------------------------*
*Funciones:				*
*					*
*-Telefono(constructor)                 * 
*-run(ejecucion de los hilos)           *
*-llamar				*
*-descolgar				*
*-marcando				*
*-setNumero				*
*-setEstado				*
*-private despertar                     *
\***************************************/

package centraltelefonica;

public class Telefono extends Thread{
	
	
	private final Central central;//necesario para poder mantener comunicacion con el objeto "central"
        private final short telefono;
        private final FXMLDocumentController control; 
	private boolean dormido = true;//estado del telefono (colgado = true, descolgado = false).
	private short estado, numero;
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
	public Telefono(Central central, short telefono, FXMLDocumentController control){
		this.central = central;
		this.telefono = telefono;
                this.control = control;
		setEstado(0);
	}

	//---------------Funcion que crea los hilos------------------
        @Override
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

		int auxEstado;
		
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
			this.setEstado(4);
			System.out.println("Piii-Piii-Piii...");
			auxEstado = central.conexion(numero, telefono); //Despierta a la central para poder realizar la conexion
			this.setEstado(auxEstado);

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
			this.setEstado(5);
			System.out.println("Bueno ");
			System.out.println("bla bla bla bla bla");
		}
		this.setEstado(0);
		dormido = true;
	}
	
	//-------funcion que indica se ha descolgado el telefono-----
	//La funcion es llamada desde la interfaz. Al ser llamada
	//despierta al hilo de la central, y llama a la funcion que
	//despierta al hilo del telefono en que ha sido llamada 
	//esta funcion.
	public boolean descolgar() {
		this.despertar();//Despierta el hilo del objeto telefono en que ha sido llamado.
		this.setEstado(1);
		//Despierta el hilo de la central telefonica, y verifica estado.
                return true;
	}

	/**
	 * Tiene la funcion de que cuando recibe una llamada y 
	 * desculega el telefono para recibirla
	 * @param remitente
	 */
	public synchronized void descolgarPorLlamada(short remitente){
		System.out.println("Ring-Ring");
		System.out.println("Me estan llamando el Telefono " + remitente);
		this.setEstado(6);
		this.despertar();	//despierta al hilo telefono
	}
	
	//-------funcion que espera el marcado de un numero---------
	//Duerme al hilo hasta que sea marcado un numero, y establece
	//el estado del telefono en 2 (marcando).
	//una vez se despierta el hilo, antes de finalizar la funcion,
	//se establece el estado a 3(llamando).
	public synchronized void marcando() {
		System.out.println("marcando");
		this.setEstado(2);
		try {
			wait();//el hilo entra es espera hasta que sea llamada a la funcion correspondiente
		}catch(InterruptedException e) {}
		this.setEstado(3);
		System.out.println("marcado al tel No: "+numero);
	}
	
	public synchronized  void colgar() {
		//Comparar si el telefono descolgado no está realizando una llamada.
		//Esto para poder notificar al otro teléfono que la llamada ya ha finalizado.
		System.out.println("Voy a colgar...");
		//Escenarios fuera de una llamada con otro teléfono (3) o bien, este permanezca colgado pero esté siendo llamado (6) 
		if(this.getEstado() > 0 && this.getEstado() != 3 && this.getEstado() != -6) {
			System.out.println("Este teléfono se ha colgado");
			this.setEstado(0); // El estado de colgado es 0. 
			//Deteniendo flujo del teléfono.
			dormido = true; //el teléfono ha sido colgado.
		}
		//De lo contrario, si el teléfono está en una llamada es necesario notificar a la centrar que el teléfono está libre.
		else if(this.getEstado() == 6) {
			//se debe notificar a la central para que el otro telefono sepa que ya se ha finalizado la llamada
			central.finalizarLlamada(telefono, numero); //donde telefono es el remitente y numero es el telefono con el que se comunica
			System.out.println("Este telefono con numero " + numero + " finalizó la llamada con " + telefono);
			this.setEstado(0);
			notifyAll(); //el telefono está libre y puede realizarse una nueva llamada
			dormido = true;
		}
	}
	
	//----------------Establece el numero a marcar---------------
	//Se llama desde la interfaz para establecer el numero al que
	//se marcar�, adem�s de despertar al hilo para continuar con la llamada
	public void setNumero(short numero){
		this.numero = numero;
		this.despertar();
	}

	//----------funcion que define el estado del telefono--------
	//La funcion modifica la variable de estado del telefono y
	//notifica a la funcion interfaz de dicho cambio.
	public void setEstado(int estado){
		this.estado = (short)estado;
		System.out.println("estado: "+this.estado);
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
