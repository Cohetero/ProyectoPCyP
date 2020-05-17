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
	}
}