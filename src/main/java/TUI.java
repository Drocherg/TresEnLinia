import java.util.Scanner;

public class TUI {

    private static Scanner sc = new Scanner(System.in);
    public static int mostrarMenu() {
        System.out.println("Escull una opció");
        System.out.println();
        System.out.println("1. Nova partida");
        System.out.println("2. Carregar partida");
        System.out.println("3. Configuració");
        System.out.println("4. Sortir");
        int opcioEscollida = sc.nextInt();
        sc.nextLine();
        return opcioEscollida;

    }
    public char[][] mostrarTaulell(char[][] taulell) {
        for (int fila = 0; fila < taulell.length; fila++) {
            for (int columna = 0; columna < taulell[fila].length; columna++) {
                System.out.print("| " + taulell[fila][columna] + " ");
            }
            System.out.println("|"); // Nueva línea después de cada fila
            // Línea divisoria entre las filas
            System.out.println("-------------");
        }
        return taulell;
    }
    public static short[] recollirJugada() {
        System.out.println("Introdueix la jugada (fila i columna):");
        short fila = sc.nextShort();
        short columna = sc.nextShort();
        return new short[]{fila, columna};
    }

    public static void finDePartida(short guanyador){
    
    }
    public void selNovaPartida(){
        System.out.println("Has seleccionat nova partida");
    }
}