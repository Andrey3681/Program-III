public class Main {
    public static void main(String[] args) {
        char[][] tablero = crearTablero(5);

        acomodarReinas(tablero, 0);

        imprimirTablero(tablero);
    }

    public static char[][] crearTablero(int n) {
        char[][] tablero = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tablero[i][j] = '0';
            }
        }
        return tablero;
    }

    public static boolean acomodarReinas(char[][] tablero, int columna) {
        if (columna == tablero.length) {
            return true;
        }

        return acomodarReinasEnColumna(tablero, columna, 0);
    }

    private static boolean acomodarReinasEnColumna(char[][] tablero, int columna, int fila) {
        if (fila == tablero.length) {
            return false;
        }

        if (verficarMovimiento(tablero, fila, columna)) {
            tablero[fila][columna] = '1';
            if (acomodarReinas(tablero, columna + 1)) {
                return true;
            }

            tablero[fila][columna] = '0'; // Deshacer el movimiento si no lleva a una solución
        }

        return acomodarReinasEnColumna(tablero, columna, fila + 1);
    }


    public static boolean verficarMovimiento(char[][] tablero, int fila, int columna) {
        // Verificar fila
        for (int i = 0; i < columna; i++) {
            if (tablero[fila][i] == '1') {
                return false;
            }
        }

        // Verificar diagonal superior izquierda
        for (int i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == '1') {
                return false;
            }
        }

        // Verificar diagonal inferior izquierda
        for (int i = fila, j = columna; i < tablero.length && j >= 0; i++, j--) {
            if (tablero[i][j] == '1') {
                return false;
            }
        }

        return true;
    }

    public static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("[" + tablero[i][j] + "]");
            }
            System.out.println();
        }
    }
}