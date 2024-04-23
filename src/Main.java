import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        System.out.println("Escull una de les següents opcions:");
        System.out.println("1. Nova partida");
        System.out.println("2. Carregar partida");
        System.out.println("3. Configuració");
        System.out.println("4. Sortir");

        int opcioEscollida = sc.nextInt();

        while (opcioEscollida != 4) {
            //Sale del bucle cuando se escribe 4, si no vuleve a mostrar el menu

            System.out.println("Escull una de les següents opcions:");
            System.out.println("1. Nova partida");
            System.out.println("2. Carregar partida");
            System.out.println("3. Configuració");
            System.out.println("4. Sortir");
            opcioEscollida = sc.nextInt();

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

            } else if (opcioEscollida == 4){
                break;
            }

            //Sale del menu

        }
        System.out.println("Has seleccionat la opció 4: Sortir.");
        //Salir;
    }
}