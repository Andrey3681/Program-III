public class Main {
    public static void main(String[] args) {
        int [][] matriz= {{1,3,4,0},{3,4,5,0},{2,1,1,0}};
        System.out.println(sumaDiagonal(matriz,0,0));
    }



    public static int sumaDiagonal(int [][] matriz, int i , int j) {
        //verifico que sea cuadrada
        if(matriz.length-1==matriz[0].length-1){
            //verifico que no sea la ultima fila
            if(matriz.length-1==i){
                //verifico que no sea la ultima fila
                if(matriz.length-1==j){
                    //de ser se termina la recursividad
                    return matriz[i][j];
                }
                //sino entra otra vez al metodo y aumenta una columna
                else {
                    return sumaDiagonal(matriz,i,j+1);
                }
            }
            //sino verifica si esta en la diagonal
            else if(i == j) {
                // de serlo le dice al metodo que aca suma la posicion de la matriz
                return sumaDiagonal(matriz, i, j + 1) + matriz[i][j];
            }
            // sino verifica si es la ultima columna
            else if (matriz[0].length - 1 == j) {
                //de serlo llama de nuevo la recursividad y  aumenta una fila
                return sumaDiagonal(matriz, i + 1, 0);

            }
            //sino es la ultima columna
            else {
                // retorna el metodo y aumenta una columna
                return sumaDiagonal(matriz, i, j + 1);
            }

        }

        //de no serlo envia un 0
        else {
            return 0;
        }
    }

    public static int sumarDiagonalInver(int [][] matriz, int i, int j){
        if(i==j){
            if(i==0){
                return matriz[i][j];
            }
            else {
                return sumarDiagonalInver(matriz,i-1,j-1)+matriz[i][j];
            }

        }else {
            return 0;
        }

    }

    public static int subDiagonal(int [][] matriz, int i, int j){
        if(i==matriz.length-1){
            return matriz[i][j];
        }else {
            return subDiagonal(matriz,i+1,j-1)+matriz[i][j];
        }
    }
}