import java.util.Scanner;

public class TUI {
    static Joc joc = new Joc();
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
    public static void mostrarTaulell(char taulell, short torn){
        joc.getTaulell();
        joc.getTorn();
    }
    public static short recollirJugada(){
        return 0;
    }

    public static void finDePartida(short guanyador){
        joc.jugadaGuanyadora();
    }
}