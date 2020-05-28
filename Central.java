//<<<<<<< Codigo-en-revison-2
/***************************************\
*Clase Central del proyecto central 	*
*telefonica, su objetivo es emular el 	*
*funcionamiento de una central 			*
*telefonica.							*
\***************************************/

public class Central{
	
	Telefono[] telefonos;	//Se guarda todos los telefonos
	short destinatario, remitente;	//el numero de los telefonos que van hacer conexion
	boolean dormido = true;
	int numeroTelefonos; //el numero total de los telefonos

	//----------------constructor de la clase--------------------
	public Central(Telefono[] telefonos) {
		this.telefonos = telefonos;
		numeroTelefonos = telefonos.length;
	}

	/**
	 * Esta funcion guarda los telefonos que se van hacer conexion
	 * y retorna el estado para verificar si se pudo realizar la llamada
	 * o no
	 * @param destinatario numero llamando
	 * @param remitente numero a llamar
	 * @return 
	 */
	public int conexion(short destinatario, short remitente) { //funcion que guarda el numero del telefono al que vamos a marcar.
		int estado;	//para ver en que estado se encuentra el telefono que esta llamando
		this.destinatario = destinatario;	//se guarda el telefono que esta llamando
		this.remitente = remitente; //se guarda el telefono que se esta marcando
		System.out.println("Numero a llamar: " + destinatario + " Numero que esta llamando: " + remitente);

		estado = verificar();	//verifica si el numero a marca se encuetra, esta libre o esta ocupado;
		return estado;
	}

	/**
	 * Verifica si el telefono, al que se quiere hacer la llamada,
	 * se encuentra disponible para realizar la conexion, retorno 5 si
	 * es que se pudo realizar la llamada. Si no se encuentra retorna un
	 * 7. Y si esta ocupado el numero a llamarar retorna un 8
	 * indicando que no se pudo realizar la llamada
	 * @return
	 */
	private int verificar()
	{
		for(int i = 0; i < numeroTelefonos; i++)
		{
			if(telefonos[i].getTelefono() == destinatario)
			{
				if(telefonos[i].getEstado() == 0) {
					telefonos[i].descolgarPorLlamada(remitente);
					return 5; 
				}
				return 8;
			}
		}
		return 7;
//=======
public class Central extends Thread{
	
	Telefono[] telefonos;
	int destinatario;
	public Central(Telefono[] telefonos) {
		this.telefonos = telefonos;
	}

	public conexion(int num) { //funcion que guarda el numero del telefono al que vamos a marcar.
		this.destinatario = num;
	}
	
	public void run() {
		System.out.println("soy la central");
		while(true) { //mientras dure la llamada, entonces sigue manteniendo la conexion entre ambos telefonos
			telefono[destinatario].llamar();
		}
	}

	public void marcar(int num) {
		this.conexion(num); //guardamos el numero al que vamos a comunicar
		if(telefono[num].colgado) { //si el telefono al que se marca esta colgado, entonces central aceptara la llamada, ya que el recurso esta libre
			this.run(); //en ese caso, la llamada se hará de forma directa
		}
		else { //de lo contrario, debemos esperar a que el telefono finalice la llamada
			while(!telefono[num].colgado) {
				try {
					System.out.println("El telefono esta ocupado, espere por favor");
					wait();
				}catch(InterruptedException e) {;}
				if(telefono[num].colgado){ //si el telefono ya ha terminado de llamar, entonces procederemos a establecer una conexion entre estos
					this.run()
					break;			
				}
			}			
		}
//>>>>>>> Codigo-en-revision
	}
}
