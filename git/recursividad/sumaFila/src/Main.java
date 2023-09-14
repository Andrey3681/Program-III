public class Main {
    public static void main(String[] args) {
        int[][] matriz = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 2}
        };

        System.out.println(hallarIndice(matriz,0));
    }


    public static int hallarIndice(int [][]matriz,int i){
        if(sumarFila(matriz,i,0)==mayorSumaFila(matriz,i)){
            return i;
        }else {
            return hallarIndice(matriz,i+1);
        }
    }


    public static int mayorSumaFila(int[][]matriz,int i){
        if(i==matriz.length-1){
            return sumarFila(matriz,i,0);
        }else {
            int sumaMayor= mayorSumaFila(matriz,i+1);
            if(sumaMayor>sumarFila(matriz,i,0)){

                return sumaMayor;
            }else {
                return sumaMayor;
            }
        }
    }

    public static int sumarFila(int[][]matriz,int i, int j){
        if(j==matriz[0].length-1){
            return matriz[i][j];
        }else {
            return sumarFila(matriz,i,j+1)+matriz[i][j];
        }
    }
}