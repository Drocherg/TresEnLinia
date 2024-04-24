import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI();
        tui.menu();

    }
    static void novaPartida(){
        System.out.println("1. Nova partida");
    }
    static void carregarPartida(){
        System.out.println("2. Carregar partida");
    }
    static void configuracio(){
        System.out.println("3. Configuració");
    }
    static void sortir() {
        System.out.println("4. Sortir");
    }
}