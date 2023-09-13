public class Main {
    public static void main(String[] args) {
        String nombre= "Andrey";
        System.out.println(invertirString( nombre, 0));
    }

    //pregunta al profe que pedo

    public static String invertirString(String cadena, int inicio){
        if(inicio==cadena.length()-1){
            return String.valueOf(cadena.charAt(inicio));
        }
        else {
            return (invertirString(cadena,inicio+1)+ cadena.charAt(inicio));
        }
    }
}