public class zonaGuerra {


    public static int soldadosTipoE2=0;
    public static int soldadosTipoE1=0;

    public static int soldadosAsesinados=0;
    public static int soldadosAliados=0;


    public String[][] zonaGuerra ={
            {"CA","E1","A","CA","A","CA","CA","CA","E1"},
            {"CA","E1","E2","CA","A","E1","CA","E1","CA"},
            {"CA","CA","CA", "CA","CA","CA","CA","CA","CA"},
            {"E1","CA","E1","A","CA","E1","A","CA","CA"},
            {"A","CA","A","CA","CA","E2","E1","CA","E2"},
            {"CA","CA","CA", "CA","CA","CA","CA","CA","CA"},
            {"CA","A","E1","CA","E1","A","CA","A","CA"},
            {"CA","E2","CA","CA","CA","E1","CA","CA","CA"},
            {"CA","CA","CA","A","CA","CA","CA","E2","CA"}

    };


    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args) {
        zonaGuerra m = new zonaGuerra(); 												// construimos un objeto de la clase Laberinto por defecto
        m.zonaGuerra[5][8]="G";// introducimos en este caso, la salida (X) en las coordenadas (1,1)
        m.resuelve(0, 7,17); 															// ahora, introducimos la entrada (S) en las coordenadas (8,1) y llamamos al algoritmo
        m.imprimirLaberinto(0,0);
        System.out.println(soldadosAliados);
        System.out.println(soldadosTipoE1);
        System.out.println(soldadosTipoE2);
        System.out.println(soldadosAsesinados);
    }


    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public void resuelve(int x, int y,int soldadesEnemigos){ 				// permite introducir unas coordenadas (x, y)
        if (paso(x, y,soldadesEnemigos)) { 								// intentará resolver el laberinto en estas coordenadas
            zonaGuerra[x][y] = "S"; 						// introduce en las coordenadas (x, y) la entrada
        }
    }

    private boolean paso(int x, int y,int soldadosEnemigos)
    {
        if(y> zonaGuerra[0].length-1||y<0||x<0||x> zonaGuerra.length-1){
            return false;
        }


        if (zonaGuerra[x][y]=="G"){
            imprimirLaberinto(0,0);
            System.out.println("---------resultado--------");
            if(soldadosAsesinados>=(soldadosEnemigos)){
                return true;
            }else {

                limpiarCampoBatalla(zonaGuerra,0,0);
                paso(0,7,soldadosEnemigos);

            }
        }

        if(zonaGuerra[x][y].equals("E1")){
            soldadosTipoE1+=1;
            soldadosAsesinados+=1;
            zonaGuerra[x][y]="M";
            return false;
        }
        if(zonaGuerra[x][y].equals("E2")){
            zonaGuerra[x][y]="M";
            soldadosTipoE2+=1;
            soldadosAsesinados+=1;
            return false;
        }
        if(zonaGuerra[x][y].equals("A")){
            zonaGuerra[x][y]="AC";
            soldadosAliados+=1;
        }


        if (zonaGuerra[x][y]=="R"|| zonaGuerra[x][y].equals("??")|| zonaGuerra[x][y].equals("f")|| zonaGuerra[x][y].equals("AC")|| zonaGuerra[x][y].equals("M")) {
            return false; // entonces el laberinto no puede resolverse y termina.
        }

        // si no se cumple ninguna de estas dos situaciones, quiere decir que nos encontramos en un
        // caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos llegado a nada
        zonaGuerra[x][y]="??"; // marcamos la posición como visitada (si es la primera, en las coordenadas x e y

        boolean result;// se coloca S de START)

        result=paso(x, y-1,soldadosEnemigos);//izquierda
        if (result) return true;

        result=paso(x, y+1,soldadosEnemigos);//derecha
        if (result)return true;

        result=paso(x+1, y,soldadosEnemigos);//abajo
        if (result) return true;

        result=paso(x-1, y,soldadosEnemigos);//arriba
        if (result) return true;

        zonaGuerra[x][y]="f"; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
        return false; // vuelta atrás si la solución no se encuentra aquí


    }

    private void limpiarCampoBatalla(String[][] laberinto, int i, int j) {
        if(laberinto.length-1==i){ //verfica si esta en la ultima fila
            if(laberinto[0].length-1==j){ //verifica si esta en la ultima columna
                if(laberinto[i][j].equals("?")){
                    laberinto[i][j]=" ";
                }
            }else {
                if(laberinto[i][j].equals("?")){
                    laberinto[i][j]=" ";
                }
                limpiarCampoBatalla(laberinto,i,j+1); //como no esta en la ultima columna mantiene la fila y aumenta la columna
            }
        }
        else {
            if(laberinto[0].length-1==j){//verifica si esta en la ultima columna
                if(laberinto[i][j].equals("?")){
                    laberinto[i][j]=" ";
                }
                limpiarCampoBatalla(laberinto,i+1,0);// reinicia las columnas y aumenta la fila en uno
            }else {
                if(laberinto[i][j].equals("?")){
                    laberinto[i][j]=" ";
                }
                limpiarCampoBatalla(laberinto,i,j+1);  //como no esta en la ultima columna mantiene la fila y aumenta la columna
            }
        }

    }

    private void imprimirLaberinto(int i,int j) { // imprimiremos nuestra solución. Debido a que la clase Arrays no tiene implementado
        if(zonaGuerra.length-1==i){ //verfica si esta en la ultima fila
            if(zonaGuerra[0].length-1==j){ //verifica si esta en la ultima columna
                System.out.println(zonaGuerra[i][j]);
            }else {
                System.out.print(zonaGuerra[i][j]+"-");
                imprimirLaberinto(i,j+1); //como no esta en la ultima columna mantiene la fila y aumenta la columna
            }
        }
        else {
            if(zonaGuerra[0].length-1==j){//verifica si esta en la ultima columna
                System.out.println(zonaGuerra[i][j]+"-");
                imprimirLaberinto(i+1,0);// reinicia las columnas y aumenta la fila en uno
            }else {
                System.out.print(zonaGuerra[i][j]+"-");
                imprimirLaberinto(i,j+1);  //como no esta en la ultima columna mantiene la fila y aumenta la columna
            }
        }

    }
}