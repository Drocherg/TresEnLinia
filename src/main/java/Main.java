
public class Main {
    TUI tui = new TUI();
    Joc joc = new Joc();

    public static void main(String[] args) {
        Main main = new Main();

        int opcioEscollida = TUI.mostrarMenu();
        switch (opcioEscollida) {
            case 1:
                main.novaPartida();
                break;
            case 2:
                main.carregarPartida();
                break;
            case 3:
                main.configuracio();
                break;
            case 4:
                main.sortir();
                break;
        }

    }
    private void novaPartida() {
        System.out.println("Has escollit Nova Partida");
        System.out.println();
        //Joc.novaPartida();
    }
    private void carregarPartida() {
        System.out.println("Has escollit carrega partida");
        System.out.println();
    }
    private void configuracio() {
        System.out.println("Has escollit configuració");
        System.out.println();
    }
    private void sortir() {
        System.out.println("Has escollit sortir");
        System.out.println();
    }
}