public class Main {

    public static int fib(int n){
        if (n <= 1){
            return n;
        }
        else{

            return fib(n-1)+fib(n-2);    //condición recursiva
        }
    }

    public static Object iterador(int m,int terminal){
        if(m>=terminal){
            return null;
        }
        else {
            System.out.println(fib(m));
            return iterador(m+1,terminal);
        }
    }
    public static void main(String[] args) {
        System.out.println( fib((Integer) iterador(0,9)));
    }
}