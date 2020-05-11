import java.util.Scanner;

public class InterfazUsuario {
	
	Telefono[] telefonos;
	Scanner sc;
	
	public InterfazUsuario(Telefono[] telefonos) {
		this.telefonos = telefonos;
		sc = new Scanner(System.in);
	}
	
	public void interfaz(){
		System.out.println("Telefono a descolgar");
		System.out.println("Piiiiiii...");
		int tel = sc.nextInt();
		telefonos[tel].descolgar();
		short num = sc.nextShort();
		telefonos[tel].setNumero(num);
	}
}
