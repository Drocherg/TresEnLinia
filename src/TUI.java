import java.util.Scanner;

public class TUI {
    private static Scanner sc = new Scanner(System.in);

    public static Integer mostrarMenu() {
        System.out.println("1. Nova partida");
        System.out.println("2. Carregar partida");
        System.out.println("3. Configuració");
        System.out.println("4. Sortir");

        return sc.nextInt();

    }
    public static void mostrarTaulell(char taulell, short torn){
        char taulell1 = taulell;
        short torn1 = torn;
    }
    public static short recollirJugada(){
        return 0;
    }
    public static void finDePartida(short guanyador){
    }
}