import java.util.Scanner;

public class TUI {
    Scanner sc = new Scanner(System.in);

    public static void mostrarMenu() {
        System.out.println("1. Nova partida");
        System.out.println("2. Carregar partida");
        System.out.println("3. Configuració");
        System.out.println("4. Sortir");
    }
}