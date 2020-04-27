public class telefono
{
    String numero[];
    central_Telefonica cenTel;

    public telefono(String numero[], central_Telefonica cenTel)
    {
        this.numero = new String[10];
        this.numero = numero;
        this.cenTel = cenTel;
    }

    public synchronized void descolgar()
    {

    }

    public synchronized void colgar()
    {

    }
}