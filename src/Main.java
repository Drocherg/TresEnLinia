import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        TUI tui = new TUI();
            tui.menu();
        int opcioEscollida = sc.nextInt();
        while (opcioEscollida <= 3) {
            //Sale del bucle cuando se escribe 4, si no vuleve a mostrar el menu
            //Se escribe del 1 al 4 la opcion deseada
            if (opcioEscollida == 1) {
                System.out.println("Has seleccionat la opció 1: Nova partida.");
                //Se vuelve a mostrar el menú
                //Nueva partida;

            } else if (opcioEscollida == 2) {
                System.out.println("Has seleccionat la opció 2: Carregar partida.");
                //Se vuelve a mostrar el menú
                //Carregar partida;

            } else if (opcioEscollida == 3) {
                System.out.println("Has seleccionat la opció 3: Configuració.");
                //Se vuelve a mostrar el menú
                //Configuración;

            }
            //Sale del menu
            tui.menu();
            opcioEscollida = sc.nextInt();
        }
        System.out.println("Sortint...");
    }
}