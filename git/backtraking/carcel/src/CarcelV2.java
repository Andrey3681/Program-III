public class CarcelV2 {


    public static char[][] carcel={
            {' ', 'P', 'X', ' ', 'P', 'P', ' ', 'P'},
            {' ', 'P', 'P', ' ', 'P', 'P', ' ', 'P'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'P', ' ', 'P', 'P', ' ', 'P', 'P', ' '},
            {'P', ' ', 'X', 'P', ' ', 'P', 'P', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'P', 'X', 'P', ' ', 'P', 'P', ' ', 'P'},

    };

    public static int presosEncontrados;

    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args) {
        CarcelV2 m = new CarcelV2();
        final int totalPresos = 23;
        presosEncontrados = 0;// construimos un objeto de la clase Laberinto por defecto
        m.carcel[5][7] = 'C'; 												// introducimos en este caso, la salida (X) en las coordenadas (1,1)
        m.resuelve(0, 0); 											// ahora, introducimos la entrada (S) en las coordenadas (8,1) y llamamos al algoritmo
        imprimirRecorridoActual(); 											// imprimimos el laberinto ya resuelto (si tiene soluci�n)
        System.out.println("La cantidad de presos encontrados en la cárcel es de: "+ presosEncontrados + " presos.");
        int presosFaltantes = totalPresos-presosEncontrados;
        System.out.println("Faltan " + presosFaltantes + " presos en la cárcel");
    }




    /* ----------------- IMPLEMENTACI�N DEL ALGORITMO ----------------- */
    public void resuelve(int x, int y){ 				// permite introducir unas coordenadas (x, y)
        if (paso(x, y)) { 								// intentar� resolver el laberinto en estas coordenadas
            carcel[x][y] = 'S'; 						// introduce en las coordenadas (x, y) la entrada
        }
    }

    private boolean paso(int x, int y)
    {
        if(!esPasoValido(x, y)){
            return false;
        }


        if (carcel[x][y]=='C')
        { // si hemos llegado a X quiere decir que hemos encontrado soluci�n
            imprimirRecorridoActual();
            return true; // luego, el algoritmo termina
        }


        if (carcel[x][y]=='P') { // si llegamos a una pared o al mismo punto,
            presosEncontrados++;
            carcel[x][y]='V';
            return false; // entonces el laberinto no puede resolverse y termina.
        }

        if (carcel[x][y]=='X') { // si llegamos a una pared o al mismo punto,
            return false; // entonces el laberinto no puede resolverse y termina.
        }

        if (carcel[x][y]=='*' || carcel[x][y]=='+' || carcel[x][y]=='V') { // si llegamos a una pared o al mismo punto,
            return false; // entonces el laberinto no puede resolverse y termina.
        }

        // si no se cumple ninguna de estas dos situaciones, quiere decir que nos encontramos en un
        // caso intermedio, por lo tanto, que empezamos a recorrer o todav�a no hemos llegado a nada
        carcel[x][y]='*'; // marcamos la posici�n como visitada (si es la primera, en las coordenadas x e y

        boolean result; // se coloca S de START)

        result=paso(x, y+1); // intentamos ir hacia la DERECHA. Primera llamada recursiva
        result=paso(x+1, y); // intentamos ir hacia ABAJO. Cuarta llamada recursiva
        result=paso(x-1, y); // intentamos ir hacia ARRIBA. Segunda llamada recursiva
        result=paso(x, y-1); // intentamos ir hacia la IZQUIERDA. Tercera llamada recursiva
        carcel[x][y]='+'; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
        return false; // vuelta atr�s si la soluci�n no se encuentra aqu�
    }

    public static void imprimirRecorridoActual() {
        String salida = "";    // un m�todo toString para arrays bidimensionales, lo programamos a mano
        for (int h=0; h<carcel.length; h++) { // recorremos filas
            for (int m=0; m<carcel[h].length; m++) { // recorremos columnas
                salida += carcel[h][m] + " "; // output es nuestra variable que va almacenando los valores a imprimir
            }
            salida += "\n"; // devolvemos esta variable con un salto de l�nea
        }
        System.out.println("Solución");
        System.out.println(salida);
    }

    private boolean esPasoValido(int x, int y) {


        if(x >= 0 && x <= carcel.length-1 && y >= 0 && y<= carcel[x].length-1){
            return true;
        }else{
            return false;
        }
    }

//	private String imprimir() { // imprimiremos nuestra soluci�n. Debido a que la clase Arrays no tiene implementado
//        String salida = "";    // un m�todo toString para arrays bidimensionales, lo programamos a mano
//        for (int x=0; x<laberinto.length; x++) { // recorremos filas
//            for (int y=0; y<laberinto[x].length; y++) { // recorremos columnas
//                salida += laberinto[x][y] + " "; // output es nuestra variable que va almacenando los valores a imprimir
//            }
//            salida += "\n"; // devolvemos esta variable con un salto de l�nea
//        }
//        return salida;
//    }


}