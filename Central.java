public class Central extends Thread{
	
	Telefono[] telefonos;
	
	public Central(Telefono[] telefonos) {
		this.telefonos = telefonos;
	}
	
	public void run() {
		System.out.println("soy la central");
	}
}
