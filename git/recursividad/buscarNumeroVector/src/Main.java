import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer>numero=new ArrayList<>(Arrays.asList(1,2,3,4,5,5,6,6));
        System.out.println(buscarNumero(numero,5,0));
    }
    public static int buscarNumero(ArrayList<Integer>vector,int valorBuscar,int i){
        if(i==vector.size()-1){
            if(vector.get(i)==valorBuscar){
                return 1;
            }
            else return 0;
        }
        else {
            if(vector.get(i)==valorBuscar){
                return buscarNumero(vector,valorBuscar,i+1)+1;
            }
            else {
                return buscarNumero(vector,valorBuscar,i+1);
            }
        }
    }
}