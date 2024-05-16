import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TUI {

    static boolean control = false;
    int torn = 0;
    short opcioEscollidaC;
    short novaMida;
    private static Scanner sc = new Scanner(System.in);
    public static short mostrarMenu() {
        System.out.println("Escull una opció");
        System.out.println();
        System.out.println("1. Nova partida");
        System.out.println("2. Carregar partida");
        System.out.println("3. Configuració");
        System.out.println("4. Sortir");
        short opcioEscollida = sc.nextShort();
        sc.nextLine();

        return opcioEscollida;

    }

    public void crearDirectorio () throws IOException {
        File directorio = new File("savedgames");
        if (directorio.exists()){
            System.out.println("Ja esta creat");
        }else
            directorio.mkdir();
    }

    public void gravarPartida() throws IOException {
        crearDirectorio();
        File archivo = new File("savedgames");
        if (archivo.exists()){
            System.out.println("L'arxiu ja exist");
        } else

            System.out.println("Partida gravada");

        }


    public void taulellConfigurat(short novaMida) throws IOException {
        File nouTaulell = new File("nouTaulell.txt");
        FileWriter actualitzatTaulell = new FileWriter("nouTaulell.txt");

        if (nouTaulell.createNewFile()){
            System.out.println("Configuracio creada");
        } else
            actualitzatTaulell.write(String.valueOf(novaMida));
            actualitzatTaulell.close();

        System.out.println("Configuracio actualitzat");
        selConfiguracio();
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
    public short[] recollirJugada() throws IOException {
        System.out.println("Haz tu jugada (fila y columna)");
        short fila = sc.nextShort();
        short columna = sc.nextShort();
        short tfila = 3;
        short tcolumna = 3; //mas adelante podremos cambiarlo con el archivo de configuracion
        if (fila == -1 && columna == -1){
            System.out.println("Vols gravar partida? Si/No");
            short gravar = sc.nextShort();
            if (gravar == 0){
                System.out.println("Gravar cancelat");
                recollirJugada();
            } else if (gravar == 1) {
                gravarPartida();
                System.out.println("Partida gravada");
                mostrarMenu();
            }
        }
        if (fila > 2 || columna > 2){
            System.out.println("La jugada seleccionada se sale del tablero");
            recollirJugada();
        }
        return new short[]{fila, columna};
    }


    public static void finDePartida(char guanyador){

        if (guanyador == 'X'){
            System.out.println("El jugador 2 ha guanyat;");
            control = true;
        } else if (guanyador == 'O'){
            System.out.println("El jugador 1 ha guanyat;");
            control = true;
        } else
            System.out.println("Empat");
        control = true;
    }
    public void tEmpat(){
        System.out.println("No queden caselles buides, queda en empat!");
    }
    public void selNovaPartida(){
        System.out.println("Has seleccionat nova partida");
    }
    public void selSortir(){
        System.out.println("Tirando de cable...");
    }

    public void selConfiguracio() throws IOException {
        System.out.println("Has seleccionat configuració");
        System.out.println();
        System.out.println("1. Mida del taulell");
        System.out.println("2. Sortir");
        opcioEscollidaC = sc.nextShort();

        if (opcioEscollidaC == 1){
            System.out.println("Escull la nova mida del taulell");
            novaMida = sc.nextShort();

            if (novaMida > 10 || novaMida < 3){
                System.out.println("Error en la configuracio");
                selConfiguracio();
            } else
                taulellConfigurat(novaMida);

        } else if (opcioEscollidaC == 2) {
            System.out.println("Sortint");
            mostrarMenu();

        } else
            selConfiguracio();
    }

}