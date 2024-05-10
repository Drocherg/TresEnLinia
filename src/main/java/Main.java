
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
        joc.novaPartida();
        tui.mostrarTaulell();
    }
    private void partidaEnCurso(){
        joc.jugar();
        TUI.recollirJugada();
    }
    private void carregarPartida() {

    }
    private void configuracio() {

    }
    private void sortir() {

    }

}