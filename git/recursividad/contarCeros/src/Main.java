import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public static int contarCeros(ArrayList<Integer> arreglo, int n){
        if(n==arreglo.size()-1){
            if (arreglo.get(n)==0){
                return 1;
            }
            else {
                return 0;
            }
        }else if( arreglo.get(n)==0){
            return contarCeros(arreglo,n+1)+1;
        }else {
            return contarCeros(arreglo,n+1);
        }
    }



    public static void main(String[] args) {
        ArrayList<Integer>arreglo= new ArrayList<>(Arrays.asList(1,2,3,0,4,0,4,0,3,0));

        System.out.println(contarCeros(arreglo,0));
    }
}