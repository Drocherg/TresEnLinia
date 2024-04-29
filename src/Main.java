
public class Main {
    TUI tui = new TUI();
    Joc joc = new Joc();

    public static void main(String[] args) {
        TUI.mostrarMenu();

        if (TUI.mostrarMenu() == 1){
            novaPartida();
        }
    }
    private static String novaPartida(){
        System.out.println("Has escollit Nova Partida");
        return Joc.novaPartida();
    }
    private static String carregarPartida(){
        return carregarPartida();
    }
    private static String configuracio(){
        return configuracio();
    }
    private static String sortir() {
        return sortir();
    }

}