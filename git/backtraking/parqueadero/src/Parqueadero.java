public class Parqueadero{


    public String[][] laberinto={
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
    };


    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args) {
        Parqueadero m = new Parqueadero(); 												// construimos un objeto de la clase Laberinto por defecto
        m.laberinto[1][1] = "X"; 													// introducimos en este caso, la salida (X) en las coordenadas (1,1)
        m.resuelve(8, 1,0,2); 															// ahora, introducimos la entrada (S) en las coordenadas (8,1) y llamamos al algoritmo
        System.out.println(m.imprimirLaberinto()); 								    // imprimimos el laberinto ya resuelto (si tiene solución)
    }




    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public void resuelve(int x, int y,int carrosParqueado,int carroHaParquear){ 				// permite introducir unas coordenadas (x, y)
        if (paso(x,y,carrosParqueado,carroHaParquear)) { 								// intentará resolver el laberinto en estas coordenadas
            laberinto[x][y] = "carro"; 						// introduce en las coordenadas (x, y) la entrada
        }
    }

    private boolean paso(int x, int y,int carrosParqueado,int carroHaParquear)
    {
        if(y>laberinto[0].length-1||y<0){
            return false;
        }
        if(x<0||x>laberinto.length-1){
            return false;
        }

        if (laberinto[x][y]=="R1"||laberinto[x][y]=="R2"){// si hemos llegado a X quiere decir que hemos encontrado solución
            laberinto[x][y]="parqueado";
            carrosParqueado=carrosParqueado+1;
            if(carroHaParquear==carrosParqueado){
                return true;
            }else {
                limpiar(laberinto);
                paso(x,y,carrosParqueado,carroHaParquear);

            }
            return true; // luego, el algoritmo termina
        }


        if (laberinto[x][y]=="R"||laberinto[x][y]=="+" ||laberinto[x][y]=="carro"||laberinto[x][y]=="RD"||laberinto[x][y]=="parqueado") { // si llegamos a una pared o al mismo punto,
            return false; // entonces el laberinto no puede resolverse y termina.
        }

        // si no se cumple ninguna de estas dos situaciones, quiere decir que nos encontramos en un
        // caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos llegado a nada


        boolean result;// se coloca S de START)

        if(y== laberinto[0].length-1){}


        result=paso(x, y+1,carrosParqueado,carroHaParquear; // intentamos ir hacia la DERECHA. Primera llamada recursiva
        if (result)return true; // si el resultado es el final, entonces el algoritmo termina

        result=paso(x+1, y,carrosParqueado,carroHaParquear); // intentamos ir hacia ABAJO. Cuarta llamada recursiva
        if (result) return true; // si el resultado es el final, entonces el algoritmo termina

        result=paso(x-1, y,carrosParqueado,carroHaParquear); // intentamos ir hacia ARRIBA. Segunda llamada recursiva
        if (result) return true; // si el resultado es el final, entonces el algoritmo termina

        result=paso(x, y-1,carrosParqueado,carroHaParquear); // intentamos ir hacia la IZQUIERDA. Tercera llamada recursiva
        if (result) return true; // si el resultado es el final, entonces el algoritmo termina



        // si no hemos encontrado la solución en estos cuatros movimientos, volvemos atrás, aunque hay que
        // considerar que en este punto, todas las llamadas recursivas han finalizado. Si en ninguna de ellas
        // se ha conseguido el éxito, entonces el algoritmo termina y devuelve false.
        laberinto[x][y]="f"; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
        return false; // vuelta atrás si la solución no se encuentra aquí


    }

    private void limpiar(String[][] laberinto,int i,int j) {
        if(laberinto.length-1==i){ //verfica si esta en la ultima fila
            if(laberinto[0].length-1==j){ //verifica si esta en la ultima columna
               if(laberinto[i][j]=="+"){
                   laberinto[i][j]=" ";
               }
            }else {
                if(laberinto[i][j]=="+"){
                    laberinto[i][j]=" ";
                }
                limpiar(laberinto,i,j+1); //como no esta en la ultima columna mantiene la fila y aumenta la columna
            }
        }
        else {
            if(laberinto[0].length-1==j){//verifica si esta en la ultima columna
                if(laberinto[i][j]=="+"){
                    laberinto[i][j]=" ";
                }
                limpiar(laberinto,i+1,0);// reinicia las columnas y aumenta la fila en uno
            }else {
                if(laberinto[i][j]=="+"){
                    laberinto[i][j]=" ";
                }
                limpiar(laberinto,i,j+1);  //como no esta en la ultima columna mantiene la fila y aumenta la columna
            }
        }

    }

    private String imprimirLaberinto() { // imprimiremos nuestra solución. Debido a que la clase Arrays no tiene implementado
        String salida = "";    // un método toString para arrays bidimensionales, lo programamos a mano
        for (int x=0; x<laberinto.length; x++) { // recorremos filas
            for (int y=0; y<laberinto[x].length; y++) { // recorremos columnas
                salida += laberinto[x][y] + " "; // output es nuestra variable que va almacenando los valores a imprimir
            }
            salida += "\n"; // devolvemos esta variable con un salto de línea
        }
        return salida;
    }


}
