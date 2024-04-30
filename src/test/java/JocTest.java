import static org.junit.jupiter.api.Assertions.*;

class JocTest {

    @org.junit.jupiter.api.Test
    void novaPartida() {
        assertEquals(' ', TUI.joc.getTaulell()[0][0]); // Comprobamos la primera casilla
        assertEquals(' ', TUI.joc.getTaulell()[0][1]); // Comprobamos la segunda casilla (y así sucesivamente)
        assertEquals(1, TUI.joc.getTorn()); // Verificamos que sea el turno del jugador 1
    }
}