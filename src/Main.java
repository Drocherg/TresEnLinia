
public class Main {
    TUI tui = new TUI();
    Joc joc = new Joc();

    public static void main(String[] args) {


        if (TUI.mostrarMenu() == 1){
            novaPartida();
        } else if (TUI.mostrarMenu() == 2) {
            carregarPartida();
        } else if (TUI.mostrarMenu() == 3) {
            configuracio();
        } else if (TUI.mostrarMenu() == 4) {
            sortir();
        }
    }
    private static String novaPartida(){
        System.out.println("Has escollit Nova Partida");
        System.out.println();
        return Joc.novaPartida();
    }
    private static String carregarPartida(){
        System.out.println("Has escollit carrega partida");
        System.out.println();
        return "Hola";
    }
    private static String configuracio(){
        System.out.println("Has escollit configuracio");
        System.out.println();
        return "Hola";
    }
    private static String sortir() {
        System.out.println("Has escollit sortir");
        System.out.println();
        return "Hola";
    }

}