/***************************************\
*Clase Central del proyecto central 	*
*telefonica, su objetivo es emular el 	*
*funcionamiento de una central          *
*telefonica.                            *
\***************************************/

package centraltelefonica;

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
            if(destinatario == remitente){ //si se llamo a si mismo
                return 9; //devuelve un estado de 9
            }
		for(int i = 0; i < numeroTelefonos; i++)
		{
			if(telefonos[i].getTelefono() == destinatario)
			{
				if(telefonos[i].getEstado() == 0) {
					telefonos[i].descolgarPorLlamada(remitente);
                                        do{ //Ciclo para espera hasta que le conteste el otro telefono
                                            try {
                                                    Thread.sleep(800);
                                            }catch(InterruptedException e) {}
                                            System.out.println("Telefono " + remitente + " esperando");
                                        }while(telefonos[i].getEstado() != 5); //se sale cuando el otro telefono le contesto
					return 5; 
				}else if(telefonos[i].getEstado() == 5){
                                    telefonos[remitente].waitTelefono();
                                    do{ //Ciclo para espera hasta que le conteste el otro telefono
                                        try {
                                                Thread.sleep(800);
                                        }catch(InterruptedException e) {}
                                        System.out.println("Telefono " + remitente + " esperando");
                                    }while(telefonos[i].getEstado() != 0); //se sale cuando el otro telefono le contesto
                                    telefonos[remitente].descolgar();
                                    telefonos[i].descolgarPorLlamada(remitente);
                                }
				return 8;
			}
		}
		return 7;
	}
	
        public void notifica(int destinatario){
            for(int i = 0; i < numeroTelefonos; i++) {
                if(destinatario == telefonos[i].getTelefono()){
                    telefonos[i].setEstado(3);
                    telefonos[i].mensajeNotifacion();
                    break;
                }
            }
        }
        
	//Funcion que se ejecuta cuando un telefono cuelga, por lo que el estado del otro telefono tambien debe cambiar.
	public void finalizarLlamada(int remitente, int destinatario) {
		this.remitente = (short)remitente; //numero que cuelga
		this.destinatario = (short)destinatario; //numero al que se colgó
		for(short i = 0; i < numeroTelefonos; i ++) { //buscar el telefono al que se le ha colgado
			//cuando el teléfono que solicitó colgar cumpla esa función, es necesario cambiar
			// el estado del otro teléfono a descolgado.
			if(telefonos[i].getTelefono() == destinatario) { //si el telefono corresponde con el que se establecía la llamada
				//telefonos[i].descolgar(); //cambiamos el estado del destinatario de llamada a unicamente descolgado.
				
                                System.out.println("Mensaje del telefono" + destinatario + " -> El telefono " + remitente + " terminó la llamada conmigo.");
				break; //rompemos el ciclo de busqueda
			}
		}
	}
}
