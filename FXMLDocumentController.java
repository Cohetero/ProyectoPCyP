/***************************************\
*Clase de control de interfaz grafica   *
*su funcion es unicamente proporcional  *
*funciones y entidades que permitan     *
*conectar el codigo FXML con la logica  *
*interna del programa.                  *
\***************************************/
package centraltelefonica;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    
    //------------------Creacion de instancias-----------------
    
    //Array de clases "Telefono" permite acceder a los telefonos
    private Telefono[] telefonos;
    
    //Instancias Label state'0-1' muestran mensajes con el estado de el telefono correspondiente
    @FXML
    private Label state0;
    @FXML
    private Label state1;
    @FXML
    private Label state2;
    @FXML
    private Label state3;
    @FXML
    private Label state4;
    @FXML
    private Label state5;
    @FXML
    private Label state6;
    @FXML
    private Label state7;
    @FXML
    private Label state8;
    @FXML
    private Label state9;
    
    
     //Instancias Label genSte'0-1' muestran el estado general del telefono correspondiente
    @FXML
    private Label genSte0;
    @FXML
    private Label genSte1;
    @FXML
    private Label genSte2;
    @FXML
    private Label genSte3;
    @FXML
    private Label genSte4;
    @FXML
    private Label genSte5;
    @FXML
    private Label genSte6;
    @FXML
    private Label genSte7;
    @FXML
    private Label genSte8;
   @FXML
    private Label genSte9; 
    
    
    //Instancias TextField permiten capturar informacion en forma de cadena
    //se usan para especificar numero a marcar.
    @FXML
    private TextField call0;
    @FXML
    private TextField call1;  
    @FXML
    private TextField call2;    
    @FXML
    private TextField call3;    
    @FXML
    private TextField call4;    
    @FXML
    private TextField call5;    
    @FXML
    private TextField call6;   
    @FXML
    private TextField call7;   
    @FXML
    private TextField call8;   
    @FXML
    private TextField call9;

    
    
    //-----------Funciones de la interfaz grafica--------------
    
    
    //Funciones handlePickButton'0-9' cuelgan y descuelgan el telefono
    //se puede realizar esta accion en cualquier momento
    //si el telefono no se encuentra "colgado" pasará al estado "colgado"
    //independientemente de su estado anterior.
    @FXML
    private void handlePickButton0(ActionEvent event) {
        switch(telefonos[0].getEstado()){
            case 0:
                genSte0.setText("Descolgado");
                if(telefonos[0].descolgar()){
                    state0.setText("piiii...");
                }else{
                    state0.setText("Sin señal");
                }
            break;
            case 6:
                genSte0.setText("Llamada");
                if(telefonos[0].descolgar()){
                    state0.setText("Ring-Ring");
                }else{
                    state0.setText("Sin señal");
                }
            break;
            default:
                genSte0.setText("Colgado");
                state0.setText("");
                telefonos[0].colgar();
            break;
            
        }
    }
    @FXML
    private void handlePickButton1(ActionEvent event) {
        switch(telefonos[1].getEstado()){
            case 0:
                genSte1.setText("Descolgado");
                if(telefonos[1].descolgar()){
                    state1.setText("piiii...");
                }else{
                    state1.setText("Sin señal");
                }
            break;
            case 6:
                genSte1.setText("Llamada");
                if(telefonos[1].descolgar()){
                    state1.setText("Ring-Ring");
                }else{
                    state1.setText("Sin señal");
                }
            break;
            default:
                genSte1.setText("Colgado");
                state1.setText("");
                telefonos[1].colgar();
            break;
            
        }
    }
    @FXML
    private void handlePickButton2(ActionEvent event) {
        switch(telefonos[2].getEstado()){
            case 0:
                genSte2.setText("Descolgado");
                if(telefonos[2].descolgar()){
                    state2.setText("piiii...");
                }else{
                    state2.setText("Sin señal");
                }
            break;
            case 6:
                genSte2.setText("Llamada");
                if(telefonos[2].descolgar()){
                    state2.setText("Ring-Ring");
                }else{
                    state2.setText("Sin señal");
                }
            break;
            default:
                genSte2.setText("Colgado");
                state2.setText("");
                telefonos[2].colgar();
            break;
            
        }
    }
    @FXML
    private void handlePickButton3(ActionEvent event) {
        switch(telefonos[3].getEstado()){
            case 0:
                genSte3.setText("Descolgado");
                if(telefonos[3].descolgar()){
                    state3.setText("piiii...");
                }else{
                    state3.setText("Sin señal");
                }
            break;
            case 6:
                genSte3.setText("Llamada");
                if(telefonos[3].descolgar()){
                    state3.setText("Ring-Ring");
                }else{
                    state3.setText("Sin señal");
                }
            break;
            default:
                genSte3.setText("Colgado");
                state3.setText("");
                telefonos[3].colgar();
            break;
            
        }
    }
    @FXML
    private void handlePickButton4(ActionEvent event) {
        switch(telefonos[4].getEstado()){
            case 0:
                genSte4.setText("Descolgado");
                if(telefonos[4].descolgar()){
                    state4.setText("piiii...");
                }else{
                    state4.setText("Sin señal");
                }
            break;
            case 6:
                genSte4.setText("Llamada");
                if(telefonos[4].descolgar()){
                    state4.setText("Ring-Ring");
                }else{
                    state4.setText("Sin señal");
                }
            break;
            default:
                genSte4.setText("Colgado");
                state4.setText("");
                telefonos[4].colgar();
            break;
            
        }
    }
    @FXML
    private void handlePickButton5(ActionEvent event) {
        switch(telefonos[5].getEstado()){
            case 0:
                genSte5.setText("Descolgado");
                if(telefonos[5].descolgar()){
                    state5.setText("piiii...");
                }else{
                    state5.setText("Sin señal");
                }
            break;
            case 6:
                genSte5.setText("Llamada");
                if(telefonos[5].descolgar()){
                    state5.setText("Ring-Ring");
                }else{
                    state5.setText("Sin señal");
                }
            break;
            default:
                genSte5.setText("Colgado");
                state5.setText("");
                telefonos[5].colgar();
            break;
            
        }
    }
    @FXML
    private void handlePickButton6(ActionEvent event) {
        switch(telefonos[6].getEstado()){
            case 0:
                genSte6.setText("Descolgado");
                if(telefonos[6].descolgar()){
                    state6.setText("piiii...");
                }else{
                    state6.setText("Sin señal");
                }
            break;
            case 6:
                genSte6.setText("Llamada");
                if(telefonos[6].descolgar()){
                    state6.setText("Ring-Ring");
                }else{
                    state6.setText("Sin señal");
                }
            break;
            default:
                genSte6.setText("Colgado");
                state6.setText("");
                telefonos[6].colgar();
            break;
            
        }
    }
    @FXML
    private void handlePickButton7(ActionEvent event) {
        switch(telefonos[7].getEstado()){
            case 0:
                genSte7.setText("Descolgado");
                if(telefonos[7].descolgar()){
                    state7.setText("piiii...");
                }else{
                    state7.setText("Sin señal");
                }
            break;
            case 6:
                genSte7.setText("Llamada");
                if(telefonos[7].descolgar()){
                    state7.setText("Ring-Ring");
                }else{
                    state7.setText("Sin señal");
                }
            break;
            default:
                genSte7.setText("Colgado");
                state7.setText("");
                telefonos[7].colgar();
            break;
            
        }
    }
    @FXML
    private void handlePickButton8(ActionEvent event) {
        switch(telefonos[8].getEstado()){
            case 0:
                genSte8.setText("Descolgado");
                if(telefonos[8].descolgar()){
                    state8.setText("piiii...");
                }else{
                    state8.setText("Sin señal");
                }
            break;
            case 6:
                genSte8.setText("Llamada");
                if(telefonos[8].descolgar()){
                    state8.setText("Ring-Ring");
                }else{
                    state8.setText("Sin señal");
                }
            break;
            default:
                genSte8.setText("Colgado");
                state8.setText("");
                telefonos[8].colgar();
            break;
            
        }
    }
    @FXML
    private void handlePickButton9(ActionEvent event) {
        switch(telefonos[9].getEstado()){
            case 0:
                genSte9.setText("Descolgado");
                if(telefonos[9].descolgar()){
                    state9.setText("piiii...");
                }else{
                    state9.setText("Sin señal");
                }
            break;
            case 6:
                genSte9.setText("Llamada");
                if(telefonos[9].descolgar()){
                    state9.setText("Ring-Ring");
                }else{
                    state9.setText("Sin señal");
                }
            break;
            default:
                genSte9.setText("Colgado");
                state9.setText("");
                telefonos[9].colgar();
            break;
            
        }
    }
    
    //Funciones handleCallButton'0-9' marcan al numero escrito en el 
    //TextField correspondiente
    @FXML
    private void handleCallButton0(ActionEvent event){
        String strNum;
        if(telefonos[0].getEstado() == 2){
            strNum = call0.getText();
            if(strNum != null){
                try {
                    short num = Short.parseShort(strNum);
                    telefonos[0].setNumero(--num);
                }catch (NumberFormatException e){}
            }
        }
    }
    @FXML
    private void handleCallButton1(ActionEvent event){
        String strNum;
        if(telefonos[1].getEstado() == 2){
            strNum = call1.getText();
            if(strNum != null){
                try {
                    short num = Short.parseShort(strNum);
                    telefonos[1].setNumero(--num);
                }catch (NumberFormatException e){}
            }
        }
    }
    @FXML
    private void handleCallButton2(ActionEvent event){
        String strNum;
        if(telefonos[2].getEstado() == 2){
            strNum = call2.getText();
            if(strNum != null){
                try {
                    short num = Short.parseShort(strNum);
                    telefonos[2].setNumero(--num);
                }catch (NumberFormatException e){}
            }
        }
    }
    @FXML
    private void handleCallButton3(ActionEvent event){
        String strNum;
        if(telefonos[3].getEstado() == 2){
            strNum = call3.getText();
            if(strNum != null){
                try {
                    short num = Short.parseShort(strNum);
                    telefonos[3].setNumero(--num);
                }catch (NumberFormatException e){}
            }
        }
    }
    @FXML
    private void handleCallButton4(ActionEvent event){
        String strNum;
        if(telefonos[4].getEstado() == 2){
            strNum = call4.getText();
            if(strNum != null){
                try {
                    short num = Short.parseShort(strNum);
                    telefonos[4].setNumero(--num);
                }catch (NumberFormatException e){}
            }
        }
    }
    @FXML
    private void handleCallButton5(ActionEvent event){
        String strNum;
        if(telefonos[5].getEstado() == 2){
            strNum = call5.getText();
            if(strNum != null){
                try {
                    short num = Short.parseShort(strNum);
                    telefonos[5].setNumero(--num);
                }catch (NumberFormatException e){}
            }
        }
    }
    @FXML
    private void handleCallButton6(ActionEvent event){
        String strNum;
        if(telefonos[6].getEstado() == 2){
            strNum = call6.getText();
            if(strNum != null){
                try {
                    short num = Short.parseShort(strNum);
                    telefonos[6].setNumero(--num);
                }catch (NumberFormatException e){}
            }
        }
    }
    @FXML
    private void handleCallButton7(ActionEvent event){
        String strNum;
        if(telefonos[7].getEstado() == 2){
            strNum = call7.getText();
            if(strNum != null){
                try {
                    short num = Short.parseShort(strNum);
                    telefonos[7].setNumero(--num);
                }catch (NumberFormatException e){}
            }
        }
    }
    @FXML
    private void handleCallButton8(ActionEvent event){
        String strNum;
        if(telefonos[8].getEstado() == 2){
            strNum = call8.getText();
            if(strNum != null){
                try {
                    short num = Short.parseShort(strNum);
                    telefonos[8].setNumero(--num);
                }catch (NumberFormatException e){}
            }
        }
    }
    @FXML
    private void handleCallButton9(ActionEvent event){
        String strNum;
        if(telefonos[9].getEstado() == 2){
            strNum = call9.getText();
            if(strNum != null){
                try {
                    short num = Short.parseShort(strNum);
                    telefonos[9].setNumero(--num);
                }catch (NumberFormatException e){}
            }
        }
    }
    
    
     //Funciones onClickNum'0-9' se llama al dar click en el
    //TextField correspondiente, muestra el mensaje de estado
    //"marcando"
    @FXML
    private void onClickNum0(Event event){
        if(telefonos[0].getEstado() == 2){
            state0.setText("Marcando");
        }
    }
    @FXML
    private void onClickNum1(Event event){
        if(telefonos[1].getEstado() == 2){
            state1.setText("Marcando");
        }
    }
    @FXML
    private void onClickNum2(Event event){
        if(telefonos[2].getEstado() == 2){
            state2.setText("Marcando");
        }
    }
    @FXML
    private void onClickNum3(Event event){
        if(telefonos[3].getEstado() == 2){
            state3.setText("Marcando");
        }
    }
    @FXML
    private void onClickNum4(Event event){
        if(telefonos[4].getEstado() == 2){
            state4.setText("Marcando");
        }
    }
    @FXML
    private void onClickNum5(Event event){
        if(telefonos[5].getEstado() == 2){
            state5.setText("Marcando");
        }
    }
    @FXML
    private void onClickNum6(Event event){
        if(telefonos[6].getEstado() == 2){
            state6.setText("Marcando");
        }
    }
    @FXML
    private void onClickNum7(Event event){
        if(telefonos[7].getEstado() == 2){
            state7.setText("Marcando");
        }
    }
    @FXML
    private void onClickNum8(Event event){
        if(telefonos[8].getEstado() == 2){
            state8.setText("Marcando");
        }
    }
    @FXML
    private void onClickNum9(Event event){
        if(telefonos[9].getEstado() == 2){
            state9.setText("Marcando");
        }
    }
    
    //Funcion que inicia la ejecucion de la interfaz grafica, define los parametros
    //con los que se ejecutará, ademas instancia las clases e inicia los hilos
    //necesarios.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        //------------------Creacion de instancias-----------------
        //Se crea un array para diez elementos de tipo "Telefono"
        telefonos = new Telefono[10]; 
        
        //Se instancia un objeto "Central" 
        Central central = new Central(telefonos);
        
        //Se instancia cada uno de los elementos de dicho array
        for(short i = 0; i < 10; i++) telefonos[i] = new Telefono(central, i, this);
        
        //-----------------Ejecucion de los hilos-----------------
        for(Telefono telefono: telefonos) telefono.start();//se ejecuta un hilo por cada instancia "telefono" en "telefonos"
        
    }    
    
}
