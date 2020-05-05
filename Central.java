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
	}
}
