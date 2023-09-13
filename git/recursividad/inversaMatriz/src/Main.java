public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }


    public static int[][] matrizInversa(int[][]matriz,int i,int j){
        int [][] matrizInversa = new int[j][i];
        matrizInversa= reescribirMatriz(matrizInversa,matriz,0,0);
        return matrizInversa;

    }

    private static int[][] reescribirMatriz(int[][] matrizInversa, int[][] matriz, int i, int j) {
        if(matriz.length-1==i){
            if(matriz[0].length-1==j){

                matrizInversa[j][i]=matriz[i][j];
                return matrizInversa;

            }else {
                matrizInversa[j][i]=matriz[i][j];
                reescribirMatriz(matrizInversa,matriz,i,j+1);
            }
        }
        else {
            if(matriz[0].length-1==j){
                matrizInversa[j][i]=matriz[i][j];
                reescribirMatriz(matrizInversa,matriz,i+1,0);

            }else {
                matrizInversa[j][i]=matriz[i][j];
                reescribirMatriz(matrizInversa,matriz,i,j+1);

            }

        }

        return matrizInversa;
    }
}