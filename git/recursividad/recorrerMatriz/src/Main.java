public class Main {
    public static void main(String[] args) {
        int [][] matriz= {{1,3,4,5},{3,4,5,6},{2,1,1,1}};
        System.out.println(recorrerMatrizInv(matriz,matriz.length-1,matriz[0].length-1));
    }


    public static int recorrerMatriz(int[][] matriz, int i, int j) {
        if(matriz.length-1==i){
            if(matriz[0].length-1==j){
                System.out.println(matriz[i][j]);
                return matriz[i][j];

            }else {
                System.out.println(matriz[i][j]);
                return recorrerMatriz(matriz,i,j+1);
            }
        }
        else {
            if(matriz[0].length-1==j){
                System.out.println(matriz[i][j]);
                return recorrerMatriz(matriz,i+1,0)+matriz[i][j];

            }else {
                return recorrerMatriz(matriz,i,j+1)+matriz[i][j];
            }

        }
    }


    public static int recorrerMatrizInv(int[][] matriz, int i, int j) {
        if(i==0){
            if(j==0){
                System.out.println(matriz[i][j]);
                return matriz[i][j];

            }else {
                System.out.println(matriz[i][j]);
                return recorrerMatrizInv(matriz,i,j-1)+matriz[i][j];
            }
        }
        else {
            if(j==0){
                System.out.println(matriz[i][j]);
                return recorrerMatrizInv(matriz,i-1,matriz[0].length-1)+matriz[i][j];

            }else {
                System.out.println(matriz[i][j]);
                return recorrerMatrizInv(matriz,i,j-1)+matriz[i][j];
            }

        }
    }

}