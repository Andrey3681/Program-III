public class Main {
    public static void main(String[] args) {
        int [][] matriz= {{1,3,4},{3,4,5},{2,1,1}};
        System.out.println(sumarMatrizInversa(matriz,0,matriz[0].length-1));
    }

    public static int sumarMatrizInversa(int [][] matriz, int i, int j){
        if(matriz.length-1==i){
            if(j==0){
                return matriz[i][j];

            }else {
                return sumarMatrizInversa(matriz,i,j-1)+matriz[i][j];
            }
        }
        else {
            if (j == 0) {
                return sumarMatrizInversa(matriz, i + 1, matriz[0].length-1) + matriz[i][j];

            } else {
                return sumarMatrizInversa(matriz, i, j - 1) + matriz[i][j];
            }
        }
    }
}