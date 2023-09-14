public class Main {
    public static void main(String[] args) {
        int[][] matriz={
                {1,1,0},
                {0,1,0},
                {0,0,1}
        };

        int [][] transpuesta= transpuesta(matriz);

        if(simetria(matriz,transpuesta,0,0)){
            System.out.println(" es simetrica");
        }else {
            System.out.println(" no es simetrica");
        }

    }

    public static boolean simetria(int[][]matriz,int[][]transpuesta,int i, int j){

        if(matriz.length-1==matriz[0].length-1){
            if(matriz.length-1==i){
                if(matriz[0].length-1==j){
                    if(matriz[i][j]==transpuesta[i][j]){
                        return true;
                    }
                    else {return false;}
                }else {
                    if(matriz[i][j]==transpuesta[i][j]){

                        return simetria(matriz,transpuesta,i,j+1);

                    }else {
                        return false;
                    }


                }
            }
            else {
                if(matriz[0].length-1==j){
                    if(matriz[i][j]==transpuesta[i][j]){
                        return simetria(matriz,transpuesta,i+1,0);
                    }else {
                        return false;
                    }



                }else {
                    if(matriz[i][j]==transpuesta[i][j]){
                        return simetria(matriz,transpuesta,i,j+1);

                    }else {
                        return false;
                    }

                }

            }
        }else {
            throw new RuntimeException(" la matriz no es cuadrada");
        }

    }

    public static int[][] transpuesta(int[][]matriz){
        int [][] matrizInversa = new int[matriz[0].length][matriz.length]; //crea la matriz de tamaño opuesto ala entrante
        matrizInversa= reescribirMatriz(matrizInversa,matriz,0,0); //se llena esa matriz el metodo reescribirMatriz
        return matrizInversa; //lo retorna al final

    }

    //metodo que reescribe la matriz
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
}