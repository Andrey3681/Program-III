public class Caballo {

    static final int N = 8;
    static final int n = (N + 1);
    private int[][] tablero = new int[n][n];
    private boolean victoria;
    private int[][] salto = {{2, 1}, {1, 2}, {-1, 2}, {-2,1}, {-2,-1}, {-1,-2}, {1,-2}, {2,-1}};
    private int x0, y0;

    public Caballo(int x, int y) throws Exception {
        if ((y < 1) || (y > N) || (x < 1) || (x > N)) {
            throw new Exception(" ¡UPS! se sale del tablero ");
        }
        x0 = x;
        y0 = y;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                tablero[i][j] = 0;
            }
        }
        tablero[x0][y0] = 1;
        victoria = false;
    }

    public boolean resolverProblema() {
        saltoCaballo(x0, y0, 2);
        return victoria;
    }

    private void saltoCaballo(int x, int y, int i) {
        int nx, ny;
        int k;
        k = 0;
        do {
            k++;
            nx = x + salto[k - 1][0];
            ny = y + salto[k - 1][1];

            if ((nx >= 1) && (nx <= N) && (ny >= 1) && (ny <= N) && (tablero[nx][ny] == 0)) {
                tablero[nx][ny] = i; // Marca el movimiento
                if (i < N * N) {
                    saltoCaballo(nx, ny, i + 1);

                    if (!victoria) { // No es la solución
                        tablero[nx][ny] = 0; // Se borra el punto
                    }

                } else {
                    victoria = true; // Tablero lleno
                }
            }
         } while ((k < 8) && !victoria) ;
        }


    void mostrarTablero () {
        System.out.println("Tablero de Ajedrez movimiento Caballo: ");

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N ; j++) {
                System.out.print(tablero[i][j] + " ");
            }

            System.out.println(" ");
        }
    }
}

