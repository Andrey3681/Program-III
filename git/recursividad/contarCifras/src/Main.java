public class Main {
    public static void main(String[] args) {
        System.out.println(calcularCifras(223453));
    }


    public static int calcularCifras(int n){
        if(n<10){
            return 1;
        }
        else {
            return calcularCifras(n/10)+1;
        }
    }
}