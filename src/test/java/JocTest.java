import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JocTest {

    @org.junit.jupiter.api.Test
    void novaPartida() {
        Joc joc = new Joc();

        //crea un tablero vacio
        char[][] t_vacio = new char[3][3];

        //Coge el tablero
        joc.novaPartida();
        char[][] tablero = joc.getTaulell();

        //Prueba el tablero vacio
        Assertions.assertArrayEquals(t_vacio, tablero);

        //prueba el turno 1 del jugador 1
        Assertions.assertEquals(1, joc.getTorn());

        //prueba el turno 2 del jugador 2
        Assertions.assertEquals(2, joc.getTorn() + 1);
    }
    @ParameterizedTest
    @CsvSource({"0,0","0,1","0,2","1,0","1,1","1,2","2,0","2,1","2,2"})
    void jugada_jugador1(short fila, short columna) {
        Joc joc = new Joc();
        char[][] tablero = new char[3][3];

        //Pone una x en una fila/columna
        tablero[fila][columna] = 'X';
        //Jugada del jugador 1
        joc.novaPartida();
        joc.jugar(fila,columna);
        //comprueba la jugada
        Assertions.assertArrayEquals(tablero, joc.getTaulell());
    }
}