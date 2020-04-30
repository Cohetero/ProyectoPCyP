//Main del proyecto central telefonica, la clase main unicamente instanciará a las clases Telefono y Central
public class CentralTelefonica
{
    public static void main (String args[])
    {
        Telefono[] telefonos = new Telefono[10]; 
        
        for(int i = 0; i < 10; i++) telefonos[i] = new Telefono();
        
        Central central = new Central(telefonos);
        
        central.start();
        for(Telefono telefono: telefonos) telefono.start();
    }
}
