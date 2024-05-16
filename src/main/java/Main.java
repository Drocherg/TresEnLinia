/*import java.io.IOException;*/

import java.io.IOException;

public class Main {
    TUI tui = new TUI();
    Joc joc = new Joc();

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        short opcioEscollida = TUI.mostrarMenu();
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
        tui.selNovaPartida();
        joc.novaPartida();
        tui.mostrarTaulell(joc.getTaulell());

        while (true) { // Bucle infinito
            short[] jugada = tui.recollirJugada(); // Solicitar una nueva jugada
            joc.jugar(jugada[0], jugada[1]); // Realizar la jugada
            tui.mostrarTaulell(joc.getTaulell()); // Mostrar el tablero actualizado
            if (joc.jugadaGuanyadora()) {
                break; // Salir del bucle si hay una jugada ganadora
            }else if (joc.empat()){
                tui.tEmpat();
                break;
            }
        }
        char guanyador;
        guanyador = (joc.getTorn() % 2 == 1) ? 'X' : 'O';
        if (joc.empat() == false){
            tui.finDePartida(guanyador);
        }
        if (joc.jugadaGuanyadora() || joc.empat()){
            TUI.mostrarMenu();
        }

    }

    private void carregarPartida() {

    }
    private void configuracio() throws IOException {
        tui.selConfiguracio();
    }
    private void sortir() {
        tui.selSortir();
    }

}