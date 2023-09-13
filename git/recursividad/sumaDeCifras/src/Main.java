public class Main {


    public static int sumaDeCifras(int n){
        if(n<=10){
            return n;
        }
        else {
            return sumaDeCifras(n/10)+n%10;
        }
    }

    public static void main(String[] args) {
        System.out.println(sumaDeCifras(58646488));
    }
}