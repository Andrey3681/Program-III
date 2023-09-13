
import java.util.ArrayList;
import java.util.Arrays;
public class Main {

    public static int numeroMenorArreglo(ArrayList<Integer>vector, int fin){
        if(fin>=vector.size()-1){
            return fin+1;
        }
        else {
            return numeroMenorArreglo(vector,fin +1);
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer>vector= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        System.out.println(numeroMenorArreglo(vector,0)) ;
    }
}