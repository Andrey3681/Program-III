import java.io.BufferedReader;
import java.io.InputStreamReader;

public class saltoCaballo {
    public static void main(String[] args) {
        int x, y;
        boolean respuesta;
        BufferedReader entrada = new BufferedReader(
                new InputStreamReader(System.in));

        try {
            System.out.println(" Posicion inicial del caballo ");

            System.out.println( " x = ");
            x = Integer.parseInt(entrada.readLine());

            System.out.println( " y = ");
            y = Integer.parseInt(entrada.readLine());

            Caballo miCaballo = new Caballo( x ,y);
            respuesta = miCaballo.resolverProblema();

            if (respuesta) {
                miCaballo.mostrarTablero();
            }

        }catch (Exception m ){
            System.out.println( "No se pudo probar ");
        }

    }
}