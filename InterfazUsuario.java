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
		int num = sc.nextInt();
		telefonos[num].descolgar();
	}
}
