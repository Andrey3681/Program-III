public class Main {
    public static void main(String[] args) {
        int[][] matriz={
                {2,1,1,4},
                {1,2,1,4},
                {1,1,2,4}
        };

       System.out .println(promedioDiagonal(matriz));
    }

    public static float promedioDiagonal(int[][] matriz){
        if(matriz.length-1==matriz[0].length-1){
            System.out.print(" el promedio de la matriz es:");
            return sumaDiagonal(matriz,0,0)/matriz.length;
        }
        else {
            throw new RuntimeException(" la matriz no es cuadrada");
        }
    }

    public static int sumaDiagonal(int[][]matriz,int i,int j){
        if(i==matriz.length-1){
            return +matriz[i][j];
        }
        else {
            return sumaDiagonal(matriz,i+1,j+1)+matriz[i][j];
        }
    }


}