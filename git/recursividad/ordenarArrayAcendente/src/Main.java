import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer>listInts= new ArrayList<>(Arrays.asList(1,3,2,4,6,5));
        ArrayList<String>listStrings= new ArrayList<>();
        listInts=organizarInts(listInts,0);
        System.out.print("los numeros organizados son: ");
        imprimirArray(listInts,0);

    }

    public static ArrayList<Integer> organizarInts(ArrayList<Integer>listInts,int i) {
        if (verificarOrdenInt(listInts, 0)) {
            return listInts;
        }
        if (i == listInts.size() - 1) {
            organizarInts(listInts, 0);
        }

        else {

            if (listInts.get(i) > listInts.get(i + 1)) {
                int temporal = listInts.get(i);
                listInts.set(i, listInts.get(i + 1));
                listInts.set(i + 1, temporal);
               return organizarInts(listInts, i+1);
            }else {
                return organizarInts(listInts, i+1);
            }

        }

         return organizarInts(listInts, i+1);
    }

    public static ArrayList<String>organizarStrings(ArrayList<String>listString, int i){
        if(verificarOrdenString(listString,0)){
            return listString;
        }

    }

    private static boolean verificarOrdenString(ArrayList<String> listString, int i) {
        if(i==listString.size()-2) {
            if (listString.get(i)<listString.get(i + 1)){
                return true;
            }else {
                return false;
            }
        } else {
            if(listString.get(i)<listString.get(i + 1)){
                return verificarOrdenInt(listString,i+1);
            }else {
                return false;
            }
        }

    }

    private static boolean verificarOrdenInt(ArrayList<Integer> listInts, int i) {
        if(i==listInts.size()-2) {
            if (listInts.get(i)<listInts.get(i + 1)){
                return true;
            }else {
                return false;
            }
        } else {
            if(listInts.get(i)<listInts.get(i + 1)){
                return verificarOrdenInt(listInts,i+1);
            }else {
                return false;
            }
        }
    }

    public static void imprimirArray(ArrayList<Integer>x,int i){
        if(i==x.size()-1){
            System.out.println(x.get(i));
        }else {
            System.out.print(x.get(i)+",");
            imprimirArray(x,i+1);
        }
    }

}