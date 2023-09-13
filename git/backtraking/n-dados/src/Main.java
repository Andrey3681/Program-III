public class Main {
    public static void main(String[] args) {
        int[] dados = {1, 1, 1,1};
        int valorSuperar = 9;
        tirarDados(dados,0,valorSuperar);
    }

    public static void tirarDados(int[]dados,int tirada,int valorSuperar){
        if(tirada==dados.length&&suma(dados,0)>valorSuperar){
            System.out.println(imprimirSuma(dados, dados.length - 1) + "=" + suma(dados, 0));
        }else {
            valorDados(dados,tirada,valorSuperar,1);
        }
    }
    public static void valorDados(int[]dados,int tirada,int valorSuperar,int i){
        if (i<=6){
            if(tirada!=dados.length){
                dados[tirada]=i;
                tirarDados(dados,tirada+1,valorSuperar);
                valorDados(dados,tirada,valorSuperar,i+1);
            }
        }
    }

    public static String imprimirSuma(int[]dados,int i){
        if(i==0){
            return String.valueOf(dados[i]);
        }else {
            return imprimirSuma(dados,i-1)+"+"+ String.valueOf(dados[i]);
        }
    }

    public static int suma(int[]dados,int i){
        if(i==dados.length-1){
            return dados[i];
        }
        else {
            return suma(dados,i+1)+dados[i];
        }
    }
}