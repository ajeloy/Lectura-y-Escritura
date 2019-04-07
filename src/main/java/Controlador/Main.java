
package Controlador;
import java.io.*;
/**
 *
 * @author ALEX
 */
public class Main {
    public static void main(String [] args) throws FileNotFoundException, IOException{
        String direccion = "src\\main\\java\\Archivos\\texto.txt";
        System.out.println(leerTexto (direccion));
        agregarTexto("The first man who stepped on the moon.",direccion);
        System.out.println(leerTexto (direccion));
    }
    
    //Lee el archivo de texto y lo muestra por consola
    public static boolean leerTexto( String ubicacionTexto) throws FileNotFoundException{  //Tiene como parámetro la dirección del archivo en cuestión.
        File file = new File (ubicacionTexto);
        if(file.exists() && file.canRead()){
            String cadena;
            FileReader fl = new FileReader(ubicacionTexto);
            BufferedReader br = new BufferedReader(fl);            
            try{
                while((cadena = br.readLine()) != null){
                    System.out.println(cadena);
               }
            }catch(IOException e){
                       System.out.println(e);
             }
            return true;
        }else{ //Retorno de tipo booleano dependiendo de la existencia del archivo y sus permisos para ser leído
            return false;
        }
       }
       
    //Agrega un texto al fichero en la última linea
    public static boolean agregarTexto(String textoAgregado, String ubicacionTexto) throws IOException{  //Tiene como parámetro el texto a agregar y la dirección del archivo
        File file = new File(ubicacionTexto);
        if (file.exists() && file.canWrite()){
            FileWriter fl = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fl);
            bw.newLine();
            bw.write(textoAgregado);
            bw.close();
            fl.close();
            return true;
        } //Retorno booleano dependiendo de la existencia del archivo y sus permisos para ser escritos
        else{
            return false;
        }
    }
}