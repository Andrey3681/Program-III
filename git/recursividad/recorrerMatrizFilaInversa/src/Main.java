public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static void recorrerMatrizFilaInversa(int [][]matriz,int i,int j){
        if(i==0){
            if(j==matriz[0].length-1){
                System.out.println();

            }else {
                 recorrerMatrizFilaInversa(matriz,i,j+1);
            }
        }
        else {
            if (j==matriz[0].length-1) {
                recorrerMatrizFilaInversa(matriz, i-1, 0);

            } else {
                recorrerMatrizFilaInversa(matriz, i, j + 1);
            }
        }
    }
}