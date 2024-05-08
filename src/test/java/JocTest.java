import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JocTest {

    @org.junit.jupiter.api.Test
    void novaPartida() {
        Joc joc = new Joc();

        //create an empty board
        char[][] empty_board = new char[3][3];

        //get our board
        joc.novaPartida();
        char[][] my_board = joc.getTaulell();

        //test empty board
        Assertions.assertArrayEquals(empty_board, my_board);

        //test player1 turn
        Assertions.assertEquals(1, joc.getTorn());

        //test player2 turn
        Assertions.assertEquals(2, joc.getTorn() + 1);
    }
}