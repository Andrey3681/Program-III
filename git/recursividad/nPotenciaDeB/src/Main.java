public class Main {
    public static void main(String[] args) {
        int n =27; //la potencia
        int b= 3; // la posible base

        if(verificarPotencia(n,b,b)){
            System.out.println(n+ " es potencia de "+ b);
        }else {
            System.out.println(n+ " no es potencia de "+ b);
        }

    }

    public static boolean verificarPotencia(int n,int b,int total){
        if(total==n){
            return true;
        }
        if(total>n){
            return false;
        }else {
            total=total*b;
            return verificarPotencia(n,b,total);
        }
    }
}