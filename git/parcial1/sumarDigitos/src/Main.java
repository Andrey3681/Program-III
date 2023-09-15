import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int [][] matirz={
            {454,1010,4141,4444,234},
            {100,2163,5456,222,444},
            {1001,0,99,111,5654},
            {13,89,6,112,555}

        };
        ArrayList<Integer>lisNew=new ArrayList<>();
        ArrayList<Integer>listNew=mayores(matirz,lisNew,0,0);
        imprimirList(listNew,0);
    }

   public static void imprimirList(ArrayList<Integer>x,int n){
        if(n==x.size()-1){
            System.out.println(x.get(n));
        }else {
            System.out.println(x.get(n));
            imprimirList(x,n+1);
        }
   }

    public static ArrayList<Integer> mayores(int[][]matriz,ArrayList<Integer>listNew,int i,int j){
        if(matriz.length-1==i){
            if(matriz[0].length-1==j){
                if(sumaDeCifras(matriz[i][j])>10){
                    listNew.add(matriz[i][j]);
                }
                return listNew;
            }else {
                if(sumaDeCifras(matriz[i][j])>10){
                    listNew.add(matriz[i][j]);
                }
                return mayores(matriz,listNew,i,j+1);
            }
        }
        else {
            if(matriz[0].length-1==j){
                if(sumaDeCifras(matriz[i][j])>10){
                    listNew.add(matriz[i][j]);
                }

                return mayores(matriz,listNew,i+1,0);

            }else {
                if(sumaDeCifras(matriz[i][j])>10){
                    listNew.add(matriz[i][j]);
                }
                return mayores(matriz,listNew,i,j+1);
            }

        }
    }
    public static int sumaDeCifras(int n){
        if(n<=10){
            return n;
        }
        else {
            return sumaDeCifras(n/10)+n%10;
        }
    }



}