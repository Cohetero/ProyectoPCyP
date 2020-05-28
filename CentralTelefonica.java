/***************************************\
*Main del proyecto central telefonica,  *
*la clase main unicamente instanciará a *
*las clases necesarias e inicia la      *
*ejecucion de los procesos.             *
\***************************************/

public class CentralTelefonica
{
    public static void main (String args[])
    {
        //------------------Creacion de instancias-----------------
        //Se crea un array para diez elementos de tipo "Telefono"
        Telefono[] telefonos = new Telefono[10]; 
        
        //Se instancia un objeto "Central" 
        Central central = new Central(telefonos);
        
        //se instancia la interfaz de usuario
        InterfazUsuario interfaz = new InterfazUsuario(telefonos);
        
        //Se instancia cada uno de los elementos de dicho array
        for(short i = 0; i < 10; i++) telefonos[i] = new Telefono(central, i);
        
        //-----------------Ejecucion de los hilos-----------------
//<<<<<<< Codigo-en-revison-2
//=======
        central.start();
//>>>>>>> Codigo-en-revision
        for(Telefono telefono: telefonos) telefono.start();//se ejecuta un hilo por cada instancia "telefono" en "telefonos"
        
        while(true){
        	interfaz.interfaz();
        }
    }
}
