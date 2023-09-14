import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Persona persona= new Persona(12,"juan"); //no es ninguno
        Persona persona2=new Persona(6,"felipe");  // es perfecto
        Persona persona1= new Persona(5,"andres");  //es primo
        Persona persona3= new Persona(3,"luis"); // es primo
        Persona [][] matriz= {
                {persona1,persona2},
                {persona3,persona}
        };
        ArrayList<Persona>edadesPrimas=new ArrayList<>();
        ArrayList<Persona>edadesPerfectas=new ArrayList<>();
        recorrerMatriz(matriz,matriz.length-1,0,edadesPrimas,edadesPerfectas);

    }


    public static void recorrerMatriz(Persona[][] matriz, int i, int j, ArrayList<Persona> primos, ArrayList<Persona>perfectos){
        if(i==0){
            if(j==matriz[0].length-1){
                if(esPrimo(matriz[i][j].getEdad(),1,0)){
                    primos.add(matriz[i][j]);
                } else if (esPerfecto(matriz[i][j].getEdad())) {
                    perfectos.add(matriz[i][j]);
                }
                System.out.println("las personas con edades primas son: ");
                imprimirArray(primos,0);
                System.out.println(" ");
                System.out.println("las personas con edades perfectas son: ");
                imprimirArray(perfectos,0);


            }else {
                if(esPrimo(matriz[i][j].getEdad(),1,0)){
                    primos.add(matriz[i][j]);
                } else if (esPerfecto(matriz[i][j].getEdad())) {
                    perfectos.add(matriz[i][j]);
                }
                recorrerMatriz(matriz,i,j+1,primos,perfectos);
            }
        }
        else {
            if (j==matriz[0].length-1) {
                if(esPrimo(matriz[i][j].getEdad(),1,0)){
                    primos.add(matriz[i][j]);
                } else if (esPerfecto(matriz[i][j].getEdad())) {
                    perfectos.add(matriz[i][j]);
                }
                recorrerMatriz(matriz,i-1,0,primos,perfectos);


            } else {
                if(esPrimo(matriz[i][j].getEdad(),1,0)){
                    primos.add(matriz[i][j]);
                } else if (esPerfecto(matriz[i][j].getEdad())) {
                    perfectos.add(matriz[i][j]);
                }
                recorrerMatriz(matriz, i, j + 1,primos,perfectos);
            }
        }


    }

    private static void imprimirArray(ArrayList<Persona> list, int i) {
        if(i==list.size()-1){
            System.out.println(list.get(i).getNombre()+": "+list.get(i).getEdad()+ " años");
        }else {
            System.out.println(list.get(i).getNombre()+": "+list.get(i).getEdad()+ " años");
            imprimirArray(list,i+1);
        }
    }

    public static boolean esPrimo(int edad, int i,int divisores){
        if(edad==i){
            divisores+=1;
            return divisores == 2;
        }else {
            if((edad%i)==0){
                divisores+=1;
                return esPrimo(edad,i+1,divisores);
            }
            return esPrimo(edad,i+1,divisores);
        }
    }

    public static boolean esPerfecto(int edad){
        ArrayList<Integer>divisores=new ArrayList<>();
        divisores=hallarDivisores(edad,1,divisores);
        return sumaDivisores(divisores, 0) == edad;

    }

    private static int sumaDivisores(ArrayList<Integer> divisores,int i) {
        if(i==divisores.size()-1){
            return +divisores.get(i);
        }else {
            return sumaDivisores(divisores,i+1)+divisores.get(i);
        }

    }

    public static ArrayList<Integer>hallarDivisores(int edad,int i,ArrayList<Integer>divisores){
        if(edad==i){
            return divisores;
        }else {
            if(edad%i==0){
                divisores.add(i);
            }
            return hallarDivisores(edad,i+1,divisores);
        }


    }
}