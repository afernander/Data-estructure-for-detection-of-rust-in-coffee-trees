import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.io.*;

public  class LecturaDeDatos{
    private  ArrayList <Dato> lista;
    public static  double[][] guardar(String archivo,int tamanoa) throws FileNotFoundException{
        ArrayList <Dato> lista= new ArrayList();
        Scanner leer= new Scanner(new File(archivo));
        int size =0;

        double [][]datos= new double[7][tamanoa];
        int cont=0;
        while(leer.hasNextLine()){

            String line=leer.nextLine();
            String[] planta= line.split(",");

            String[] info= new String[7];
            if(planta[0].equals("ph")){
            }else{
                datos[0][cont]=Double.parseDouble(planta[0]);
                datos[1][cont]=Double.parseDouble(planta[1]);
                datos[2][cont]=Double.parseDouble(planta[2]);
                datos[3][cont]=Double.parseDouble(planta[3]);
                datos[4][cont]=Double.parseDouble(planta[4]);
                datos[5][cont]=Double.parseDouble(planta[5]);
                if(planta[6].equals("no")){
                    datos[6][cont]=0;
                }else{
                    datos[6][cont]=1;
                }
                cont++;
            }
        }
        /*
        for(int x=0;x<datos[1].length;x++){
        for(int y=0;y<datos.length;y++){
        System.out.print(" "+datos[y][x]);
        }
        System.out.println();
        }
         */
        return datos;
    }


    

    public static void main(String[]args)throws FileNotFoundException{
        /* // tiempo de ejecusion y espacio de memoria en lectura de datos.
        for (int i = 1; i < 100; i++) {
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();
        LecturaDeDatos datos = new LecturaDeDatos();
        datos.guardar("data_set_test.csv");
        int impurezaph=0;
        long tiempo = System.currentTimeMillis() - startTime;
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long actualMemUsed=afterUsedMem-beforeUsedMem;
        //System.out.println(tiempo);
        System.out.println(actualMemUsed);
        }
         */

        LecturaDeDatos datos = new LecturaDeDatos();
        //datos.guardar("data_set_test.csv");
        double [][]matrizdatos=datos.guardar("data_set_train.csv",372);
        
        Node raiz = new Node(matrizdatos);

        double [][]matriztest=datos.guardar("data_set_test.csv",300);
        
        double [][]matrizevaluar = new double[matriztest.length+2][matriztest[1].length];
        for(int x=0;x<matriztest[1].length;x++){
            for(int y=0;y<matriztest.length;y++){
                matrizevaluar[y][x]=matriztest[y][x];
            }
        }

       
    }
    
   
    
    
}