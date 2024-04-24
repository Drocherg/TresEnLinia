import java.util.Locale;
import java.util.Scanner;

public class TUI {

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        System.out.println("Esculli una opció:");
        Main.novaPartida();
        Main.carregarPartida();
        Main.configuracio();
        Main.sortir();

        int opcioEscollida = sc.nextInt();
        //while (opcioEscollida <= 4) {
            //Sale del bucle cuando se escribe 4, si no vuleve a mostrar el menu
            //Se escribe del 1 al 4 la opcion deseada
            /*if (opcioEscollida == 1) {
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
                return;
            }
            //Sale del menu
        }*/
            switch (opcioEscollida) {
                case 1:
                    System.out.println("Has seleccionat la opció 1: Nova partida.");
                    menu();
                case 2:
                    System.out.println("Has seleccionat la opció 2: Carregar partida.");
                    menu();
                case 3:
                    System.out.println("Has seleccionat la opció 3: Configuració.");
                    menu();
                case 4:
                    System.out.println("Sortint...");
                    break;
            }
        //}
    }
}