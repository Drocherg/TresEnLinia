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
        short fila = sc.nextShort();
        short columna = sc.nextShort();
        short tfila = 3;
        short tcolumna = 3; //mas adelante podremos cambiarlo con el archivo de configuracion
        if (fila > 2 || columna > 2){
            System.out.println("La jugada seleccionada se sale del tablero");
            recollirJugada();
        }
        return new short[]{fila, columna};
    }


    public static void finDePartida(char guanyador){

        if (guanyador == 'X'){
            System.out.println("El jugador 2 ha guanyat");
            control = true;
        } else if (guanyador == 'O'){
            System.out.println("El jugador 1 ha guanyat");
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