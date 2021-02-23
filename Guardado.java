import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Esta clase contiene los metodos que crean el archivo y le agregan informacion a este mismo.
 * 
 * @author Alejandro Fernández Restrepo
 * @version mayo de 2019
 */
public class Guardado
{

    public static void crearArchivo() {
        /** Archivo*/
        File archivo;
        try {
            archivo = new File("Persistencia.txt");
            if(!archivo.exists()){
                if(archivo.createNewFile()){
                    System.out.println("Sea creado el archivo para la persistencia de los datos");
                }
            }else{
             System.out.println("El archivo ya existe , se van a añadar los datos en el archivo exsistente.");
            }
        } catch (IOException e) {
            System.err.println("No se pudo crear el archivo");
        } 
    }

    public static void aniadirArchivo(String textoAguardar) {
        FileWriter writer =null;
        try{
            writer= new FileWriter("Persistencia.txt",true);
            BufferedWriter agregar = new BufferedWriter(writer);
            agregar.write("\n");
            agregar.write(textoAguardar);
            agregar.close();
            
        }catch(IOException e){
            System.err.println("No se pudo guardar el dato en el archcivo");
        }
    }   
}

