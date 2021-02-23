public class Node {
    public Node left;
    public Node right;
    public double data;
    public int sinRoya;
    public int conRoya;
    int variable;
    double valor;
    double[][] datos;
    double probabilidad;

    public Node(double[][] matriz){

        datos = matriz;
        

        if(datos[0].length>1|| datos[0].length!=1|| datos[0].length!=6|| datos.length>0){
            int contcolumnas=0;

            for(int i=0;i<datos.length-1;i++){
                if(datos[i][0]!=-10000){
                    contcolumnas++;
                }
            }
            System.out.println(datos[0].length);
            variable = variableimpureza(matriz);
            valor = valorimpureza(matriz);
            double[][] izq = ladoIzq(matriz,variable,valor);
            double[][] der = ladoDer(matriz,variable,valor);
            
            int total = datos.length - contcolumnas;
            //System.out.println(contcolumnas);
            if (contcolumnas > 1||izq[0].length>0||der[0].length>0||contcolumnas!=0|| contcolumnas>0){
                left = new Node(izq);
                right = new Node(der);
            }
        }
        else
        {  
            if(datos[0].length>0){
                conRoya = totalRoya(datos);
                sinRoya = datos.length - conRoya;
                probabilidad = conRoya / datos[0].length*100;
            }else{
                conRoya = totalRoya(datos);
                sinRoya = datos.length - conRoya;
                probabilidad=0;
            }
        }

    }

    public static int totalRoya(double[][]matriz){
        int total=0;
        for(int i=0;i<matriz[0].length;i++){
            if(matriz[matriz.length-1][i]==1){
                total++;
            }

        }
        return total;
    }

    public static double[][] ladoIzq(double[][] matriz , int variable , double valor){
        int contador=0;
        for(int i = 0;i<matriz[0].length;i++){

            if(matriz[variable][i]<=valor){
                contador++;

            }

        }
        double [][]izquierda = new double [matriz.length][contador];
        int cont=0;
        for(int i = 0;i<matriz[0].length;i++){

            if(matriz[variable][i]<=valor){
                for(int x=0;x<izquierda.length;x++){
                    izquierda[x][cont]=matriz[x][i];
                }
                cont++;
            }

        }

        return quitarColumna(izquierda,variable);
    }

    public static double[][] ladoDer(double[][] matriz , int variable , double valor){
        int contador=0;
        for(int i = 0;i<matriz[0].length;i++){

            if(matriz[variable][i]>valor){
                contador++;

            }

        }
        double [][]derecha = new double [matriz.length][contador];
        int cont=0;
        for(int i = 0;i<matriz[0].length;i++){

            if(matriz[variable][i]>valor){
                for(int x=0;x<derecha.length;x++){
                    derecha[x][cont]=matriz[x][i];

                }
                cont++;
            }

        }

        return quitarColumna(derecha,variable);
    }

    public static double[][] quitarColumna(double [][] matriz ,int variable){

        for(int x=0;x<matriz[0].length;x++){
            matriz[variable][x]=-10000;
        }
        return matriz;
    }

    public static double valorimpureza(double[][] datos){
        double datoimpureza=0.0;
        for(int variable=0;variable<datos.length-1;variable++){
            double d=0;
            double impureza=100000000;

            for(int x=0;x<datos[variable].length;x++){
                if(datos[variable][x]==-10000){
                }else{
                    double total=0;
                    int contd=0;
                    int conti=0;
                    d=datos[variable][x];

                    for(int i=0;i<datos[variable].length;i++){
                        if(d>=datos[variable][i]){
                            contd++;
                        }else{
                            conti++;
                        }
                        total++;
                    }
                    double [][] izquierda= new double[7][conti];
                    double [][] derecha=new double [7][contd];
                    int temp1=0;
                    int temp2=0;
                    for(int i=0;i<datos[variable].length;i++){
                        if(d>=datos[variable][i]){
                            derecha[variable][temp1]=datos[variable][i];
                            derecha[6][temp1]=datos[6][i];
                            temp1++;
                        }else{
                            izquierda[variable][temp2]=datos[variable][i];
                            izquierda[6][temp2]=datos[6][i];
                            temp2++;
                        }
                    }
                    /*
                    for(int a=0;a<izquierda[0].length;a++){
                    for(int b=0;b<izquierda.length;b++){
                    System.out.print(" "+izquierda[b][a]);
                    }
                    System.out.println();
                    }
                     */
                    double cont1=0;
                    double cont1t=0;
                    for(int i=0;i<derecha[variable].length;i++){
                        if(derecha[6][i]==1.0){
                            cont1++;
                        }
                        cont1t++;
                    }

                    double cont2=0;
                    double cont2t=0;
                    for(int i=0;i<izquierda[variable].length;i++){
                        if(izquierda[6][i]==1.0){
                            cont2++;
                        }
                        cont2t++;
                    }
                    //System.out.println(conti+contd);
                    //System.out.println(total);
                    double giniizquierda =1-((cont1/cont1t)*(cont1/cont1t))+(((cont1t-cont1)/cont1t)*(cont1t-cont1)/cont1t);
                    double giniderecha =1-((cont2/cont2t)*(cont2/cont2t))+(((cont2t-cont2)/cont2t)*(cont2t-cont2)/cont2t);
                    double gini =((giniderecha*cont1t)+(giniizquierda*cont2t))/(cont1t+cont2t);
                    //System.out.println(gini);
                    if(gini<=impureza){
                        impureza =gini;
                        datoimpureza=d;
                    }
                }
            }
        }
        return datoimpureza;
    }

    public static int variableimpureza(double[][] datos){
        int variableimpureza=0;
        for(int variable=0;variable<datos.length-1;variable++){
            double d=0;
            double impureza=100000000;

            for(int x=0;x<datos[variable].length;x++){
                double total=0;
                int contd=0;
                int conti=0;
                d=datos[variable][x];
                for(int i=0;i<datos[variable].length;i++){
                    if(d>=datos[variable][i]){
                        contd++;
                    }else{
                        conti++;
                    }
                    total++;
                }
                double [][] izquierda= new double[7][conti];
                double [][] derecha=new double [7][contd];
                int temp1=0;
                int temp2=0;
                for(int i=0;i<datos[variable].length;i++){
                    if(d>=datos[variable][i]){
                        derecha[variable][temp1]=datos[variable][i];
                        derecha[6][temp1]=datos[6][i];
                        temp1++;
                    }else{
                        izquierda[variable][temp2]=datos[variable][i];
                        izquierda[6][temp2]=datos[6][i];
                        temp2++;
                    }
                }
                /*
                for(int a=0;a<izquierda[0].length;a++){
                for(int b=0;b<izquierda.length;b++){
                System.out.print(" "+izquierda[b][a]);
                }
                System.out.println();
                }
                 */
                double cont1=0;
                double cont1t=0;
                for(int i=0;i<derecha[variable].length;i++){
                    if(derecha[6][i]==1.0){
                        cont1++;
                    }
                    cont1t++;
                }

                double cont2=0;
                double cont2t=0;
                for(int i=0;i<izquierda[variable].length;i++){
                    if(izquierda[6][i]==1.0){
                        cont2++;
                    }
                    cont2t++;
                }
                //System.out.println(conti+contd);
                //System.out.println(total);
                double giniizquierda =1-((cont1/cont1t)*(cont1/cont1t))+(((cont1t-cont1)/cont1t)*(cont1t-cont1)/cont1t);
                double giniderecha =1-((cont2/cont2t)*(cont2/cont2t))+(((cont2t-cont2)/cont2t)*(cont2t-cont2)/cont2t);
                double gini =((giniderecha*cont1t)+(giniizquierda*cont2t))/(cont1t+cont2t);
                //System.out.println(gini);
                if(gini<=impureza){
                    impureza =gini;
                    variableimpureza=variable;
                }
            }

        }
        return variableimpureza;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRigth(){
        return this.right;
    }

    public double getData(){
        return this.data;
    }
}