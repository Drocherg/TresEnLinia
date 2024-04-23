import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        int opcioEscollida = sc.nextInt();

    }
    private static void novaPartida(){
        System.out.println("1. Nova partida");
    }
    private static void carregarPartida(){
        System.out.println("2. Carregar partida");
    }
    private static void configuracio(){
        System.out.println("3. Configuració");
    }
    private static void sortir() {
        System.out.println("4. Sortir");
    }
    private short menu(){
        novaPartida();
        carregarPartida();
        configuracio();
        sortir();
        return menu();
    }
}