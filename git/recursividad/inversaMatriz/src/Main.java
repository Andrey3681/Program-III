public class Main {

    public static void main(String[] args) {
        int [][] matriz= {
                {1,3,4,5},
                {3,4,5,6},
                {2,1,1,1}
        };
        int[][] matrizInversas=matrizInversa(matriz);

        System.out.println(" tenemos la siguiente matriz:");
        System.out.println(" ");
        imprimirMatriz(matriz,0,0);
        System.out.println(" ");
        System.out.println("y esta es la inversa:");
        System.out.println(" ");
        imprimirMatriz(matrizInversas,0,0);
        System.out.println(" ");



    }


    public static int[][] matrizInversa(int[][]matriz){
        int [][] matrizInversa = new int[matriz[0].length][matriz.length]; //crea la matriz de tamaño opuesto ala entrante
        matrizInversa= reescribirMatriz(matrizInversa,matriz,0,0); //se llena esa matriz el metodo reescribirMatriz
        return matrizInversa; //lo retorna al final

    }

    //metodo que reescribe la matriz

    //
    private static int[][] reescribirMatriz(int[][] matrizInversa, int[][] matriz, int i, int j) {
        if(matriz.length-1==i){  //verifica si la matriz esta en su ultima fila
            if(matriz[0].length-1==j){ //verifica si esta en la ultima columna

                matrizInversa[j][i]=matriz[i][j]; //le da el valor que tenga la matriz en (i,j) ala otra en (j,1)
                return matrizInversa; // como no hay mas filas ni columnas retorna la matriz definida
            }else {
                matrizInversa[j][i]=matriz[i][j];  //le da el valor que tenga la matriz en (i,j) ala otra en (j,1)
                return reescribirMatriz(matrizInversa,matriz,i,j+1);
            }
        }
        else {
            if(matriz[0].length-1==j){
                matrizInversa[j][i]=matriz[i][j]; //le da el valor que tenga la matriz en (i,j) ala otra en (j,1)
                return reescribirMatriz(matrizInversa,matriz,i+1,0);
            }else {
                matrizInversa[j][i]=matriz[i][j]; //le da el valor que tenga la matriz en (i,j) ala otra en (j,1)
                return reescribirMatriz(matrizInversa,matriz,i,j+1);
            }
        }
    }


    //metodo para imprimir la matriz
    public static void imprimirMatriz(int[][]matriz,int i,int j){
        if(matriz.length-1==i){ //verfica si esta en la ultima fila
            if(matriz[0].length-1==j){ //verifica si esta en la ultima columna
                System.out.println(matriz[i][j]); //imprime la posicion de la matriz
            }else {
                System.out.print(matriz[i][j]+"-"); //imprime la posicion de la matriz
                imprimirMatriz(matriz,i,j+1); //como no esta en la ultima columna mantiene la fila y aumenta la columna
            }
        }
        else {
            if(matriz[0].length-1==j){//verifica si esta en la ultima columna
                System.out.println(matriz[i][j]); //imprime la posicion de la matriz
                imprimirMatriz(matriz,i+1,0);// reinicia las columnas y aumenta la fila en uno
            }else {
                System.out.print(matriz[i][j]+ "-"); //imprime la posicion de la matriz
                imprimirMatriz(matriz,i,j+1);  //como no esta en la ultima columna mantiene la fila y aumenta la columna
            }
        }
    }
}