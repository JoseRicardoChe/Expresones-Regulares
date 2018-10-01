package expresionesregulares;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.*;
import javax.swing.JOptionPane;

public class ExpresionesRegulares {

    public static void main(String[] args) {
        
       
        
        ExpresionesRegulares m=new ExpresionesRegulares();
        String s1 = "C:\\users\\angel\\desktop\\lectura.txt";
        boolean b;
        
        do{
        b=m.letras(m.leerTxt(s1));
        }while(b==true);
        
    }

    public String leerTxt(String direccion){ //direccion del archivo
        
        String texto = "";
        
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){ 
                //haz el ciclo, mientras bfRead tiene datos
                temp = temp + bfRead; //guardado el texto del archivo
            }
            
            texto = temp;
            
        }catch(Exception e){ 
            System.err.println("No se encontro archivo");
        }
        
        return texto;
        
    }
    
   public boolean letras(String direccion1){
       
       
      int n=Integer.parseInt(JOptionPane.showInputDialog(null, "Elija la opcion Deseada\n 1.-Todas las palabras que tengan una longitud de 7 o mas letras\n 2-.Expresiones que NO finalicen con una vocal \n 3.-Las palabras que inicien con M donde la segunda letra no sea vocal"
           + "\n 4.-Expresiones encerradas entre comillas \n 5.-IP \n 6.-Fechas \n 7-Telefonos \n 8.-Correos electronicos \n 9.- URL \n 10.-Codigo postal"));
       
      
      
      String expresion = "";
        boolean a = true;
       switch(n){
           case 1:
                expresion="[a-zA-Z]{7,20}";
               break;
           case 2:
                expresion="[a-zA-Z]+[^aeiou]";
                
               break;
           case 3:
                expresion="M";
               break;
           case 4:
                expresion="('([^\"]*)\"|'([^']*)')";
               break;
           case 5:
                expresion="\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b";
               break;
            case 6:
                expresion="\\d{1,2}/\\d{1,2}/\\d{4}";
               break;
           case 7:
                expresion="\\d{3}-\\d{3}-\\d{4}";
               break;
           case 8:
              expresion="([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\\\.[a-zA-Z0-9-]+)*).com";
               break;
           case 9:
                expresion="^http?:\\/\\/[\\w\\-]+(\\.[\\w\\-]+)+[/#?]?.com";
               break;
           case 10:
                expresion="[1-9][1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}";
               break;  
           default:
                a=false;   
               break;
       } 
       
       Pattern p1=Pattern.compile(expresion);
       Matcher mm=p1.matcher(direccion1);
       
       while(mm.find()){
           System.out.printf("Encontrado %s en la posicion %d y acaba en %d\n",mm.group(),mm.start(),mm.end());
       }
return a;
       
   }
}

