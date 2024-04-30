import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Test {
    public void testNovaPartida() {
        Joc joc = new Joc();

        joc.novaPartida();

        // Verificamos si el tablero está vacío
        assertEquals(' ', joc.getTaulell()[0][0]); // Comprobamos la primera casilla
        assertEquals(' ', joc.getTaulell()[0][1]); // Comprobamos la segunda casilla (y así sucesivamente)
        assertEquals(1, joc.getTorn()); // Verificamos que sea el turno del jugador 1
    }
    /*public void testJugar() {
        Joc joc = new Joc();

        joc.jugar();

        assertEquals('X', joc.getTaulell()[0][0]); // Comprobamos la primera casilla
        // Asegúrate de verificar que no se haya colocado ninguna ficha en las otras casillas
        // Verifica que el turno del jugador haya cambiado después de jugar

    }*/
}

