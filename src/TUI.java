import java.util.Locale;
import java.util.Scanner;

public class TUI {
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
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        System.out.println("Esculli una opció:");
        novaPartida();
        carregarPartida();
        configuracio();
        sortir();

        int opcioEscollida = sc.nextInt();
        while (opcioEscollida <= 4) {
            //Sale del bucle cuando se escribe 4, si no vuleve a mostrar el menu
            //Se escribe del 1 al 4 la opcion deseada
            if (opcioEscollida == 1) {
                System.out.println("Has seleccionat la opció 1: Nova partida.");
                menu();
                //Nueva partida;

            } else if (opcioEscollida == 2) {
                System.out.println("Has seleccionat la opció 2: Carregar partida.");
                menu();
                //Carregar partida;

            } else if (opcioEscollida == 3) {
                System.out.println("Has seleccionat la opció 3: Configuració.");
                menu();
                //Configuración;

            } else if (opcioEscollida == 4) {
                System.out.println("Sortint...");
                break;
            }
            //Sale del menu
        }
    }
}