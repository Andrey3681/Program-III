public class Parqueadero{


    public String[][] parqueadero={
            {"L", " ", " ", "L", " "," ", "L", " ", " ", " "},
            {"L", " ", " ", "L", " ", " ", "L", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"CA", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"CA", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"CA", " ", " ", "CA", " ", " ", " ", " ", " ", " "},
            {"CA", " ", " ", "CA", " ", " ", " ", " ", " ", " "},
            {"CA", " ", " ", "CA", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "CA", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "R", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "R", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "R", " ", " ", " ", " ", " ", " "},
    };



    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args) {
        Parqueadero m = new Parqueadero(); 												// construimos un objeto de la clase parqueadero por defecto
        m.parqueadero[0][5] ="R1"; 													// introducimos en este caso, el lugar a parquear R1
        m.parqueadero[11][9]="R2";                                                  // introducimos en este caso, el lugar a parquear R2
        m.resuelve(11, 0,0,2); 						// ahora, introducimos la entrada "Entrada" (11,0) y llamamos al algoritmo
        System.out.println(m.imprimirParqueadero()); 								    // imprimimos el parqueadero ya resuelto (si tiene solución)
    }




    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */


    public void resuelve(int x, int y,int carrosParqueado,int carroHaParquear){ 		// permite introducir unas coordenadas (x, y), numero de carros y carros parqueados
        if (paso(x,y,carrosParqueado,carroHaParquear)) { 								// intentará resolver el parqueadero  en estas coordenadas
            parqueadero[x][y] = "Entrada"; 						// introduce en las coordenadas (x, y) la entrada
        }
    }

    private boolean paso(int x, int y,int carrosParqueado,int carroHaParquear)
    {
        if(y>parqueadero[0].length-1||y<0||x<0||x>parqueadero.length-1){ //verfica que no se vaya a desbordar
            return false;
        }

        if (parqueadero[x][y].equals("R1")||parqueadero[x][y].equals("R2")){// si hemos llegado a R1 y R2 quiere decir que hemos encontrado solución
            parqueadero[x][y]="PO";                       //Marca el lugar como que ya lo ocupamos
            carrosParqueado=carrosParqueado+1;             //aumenta el numero de carros parqueados
            if(carroHaParquear==carrosParqueado){          //verifica si ya parqueamos todos los carros
                return true;                               //si es asi termina el algoritmo
            }else {
                limpiar(parqueadero,0,0);            //limpia los lugares por donde pasamos indicados con un +
                paso(11,0 ,carrosParqueado,carroHaParquear);   //nos lleva ala entrada y comienza a parquear el siguiente
            }
            return true; // luego, el algoritmo termina
        }

        //R= reservado
        //+ =que paso por ahi
        //CA =carro
        //RD reservado para discapacitados
        //PO parqueadero ocopado (por nosotros)
        // L parqueadero libre
        //f es que no esta nuestro lugar
        if (parqueadero[x][y].equals("R")||parqueadero[x][y].equals("+") ||parqueadero[x][y].equals("CA")||parqueadero[x][y].equals("RD")||parqueadero[x][y].equals("PO")||parqueadero[x][y].equals("L")||parqueadero[x][y].equals("f")) { // si llegamos a una pared o al mismo punto,
            return false; // entonces el laberinto no puede resolverse y termina.
        }

        // si no se cumple ninguna de estas dos situaciones, quiere decir que nos encontramos en un
        // caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos llegado a nada

        parqueadero[x][y]="+";

        boolean result;// se coloca S de START)

        result=paso(x, y+1,carrosParqueado,carroHaParquear); // intentamos ir hacia la DERECHA. Primera llamada recursiva
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
        parqueadero[x][y]="f"; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
        return false; // vuelta atrás si la solución no se encuentra aquí


    }
    private void limpiar(String[][] laberinto,int i,int j) {
        if(laberinto.length-1==i){ //verfica si esta en la ultima fila
            if(laberinto[0].length-1==j){ //verifica si esta en la ultima columna
               if(laberinto[i][j].equals("+")){
                   laberinto[i][j]=" ";
               }
            }else {
                if(laberinto[i][j].equals("+")){
                    laberinto[i][j]=" ";
                }
                limpiar(laberinto,i,j+1); //como no esta en la ultima columna mantiene la fila y aumenta la columna
            }
        }
        else {
            if(laberinto[0].length-1==j){//verifica si esta en la ultima columna
                if(laberinto[i][j].equals("+")){
                    laberinto[i][j]=" ";
                }
                limpiar(laberinto,i+1,0);// reinicia las columnas y aumenta la fila en uno
            }else {
                if(laberinto[i][j].equals("+")){
                    laberinto[i][j]=" ";
                }
                limpiar(laberinto,i,j+1);  //como no esta en la ultima columna mantiene la fila y aumenta la columna
            }
        }
    }
    public String imprimirParqueadero() { // imprimiremos nuestra solución. Debido a que la clase Arrays no tiene implementado
        StringBuilder salida = new StringBuilder();    // un método toString para arrays bidimensionales, lo programamos a mano
        for (String[] strings : parqueadero) { // recorremos filas
            for (String string : strings) { // recorremos columnas
                salida.append(string).append(" "); // output es nuestra variable que va almacenando los valores a imprimir
            }
            salida.append("\n"); // devolvemos esta variable con un salto de línea
        }
        return salida.toString();
    }
}
