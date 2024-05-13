import java.util.Scanner;

public class TUI {

    static boolean control = false;
    int torn = 0;

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
        System.out.println("-------------");
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
        jugadorActual();
        short fila = sc.nextShort();
        short columna = sc.nextShort();
        return new short[]{fila, columna};
    }

    public static void jugadorActual(int torn){

        while (control == false){
            char tornJugador = (torn % 2 == 1) ? 'X' : 'O';
            if (tornJugador == 'O') {
                System.out.println("Introdueix la jugada Jugador X (fila i columna):");
                break;
            } else if (tornJugador == 'X') {
                System.out.println("Introdueix la jugada Jugador O (fila i columna):");
                break;
            }
            torn++;
        }
    }


    public static void finDePartida(char guanyador){

        if (guanyador == 'X'){
            System.out.println("El jugador 2 ha guanyat;");
            control = true;
        } else if (guanyador == 'O'){
            System.out.println("El jugador 1 ha guanyat;");
            control = true;
        } else
            System.out.println("Empat");
        control = true;
    }

    public void selNovaPartida(){
        System.out.println("Has seleccionat nova partida");
    }
    public void selSortir(){
        System.out.println("Tirando de cable...");
    }

    public void selConfiguracio(){
        System.out.println("Has seleccionat configuració");
        System.out.println();
        System.out.println("1. Mida del taulell");
        System.out.println("2. Sortir");
        short opcioEscollidaC = sc.nextShort();

        if (opcioEscollidaC == 1){
            System.out.println("Escull la nova mida del taulell");
            int novaMidaX = sc.nextInt();
            int novaMidaY = sc.nextInt();

        } else if (opcioEscollidaC == 2) {
            System.out.println("Sortint");
            mostrarMenu();

        } else
            selConfiguracio();
    }

}