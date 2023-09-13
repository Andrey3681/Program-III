public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }


    public static void filas(int [][] matriz,int i){
        if(i==matriz.length-1){
            diagonal(matriz,i,0);
        }else {
            diagonal(matriz,i,0);
            filas(matriz,i+1);

        }
    }


    public static void diagonal(int [][] matriz,int i, int j){
        if(i==0){
            System.out.println(matriz[i][j]);
        }else {
            System.out.println(matriz[i][j]);
            diagonal(matriz,i-1,j+1);
        }
    }
}