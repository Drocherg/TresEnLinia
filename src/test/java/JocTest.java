/*import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JocTest {

    @Test
    void creacion () {
        String[][] tableroEsperado = {
                {"|"," ","|"," ","|"," ","|"},
                {"|"," ","|"," ","|"," ","|"},
                {"|"," ","|"," ","|"," ","|"}
        };
        Joc joc = new Joc();
        Assertions.assertArrayEquals(tableroEsperado, joc.getTaulell());
    }

    @Test
    void primerturno() {
        int x = 1;
        int y = 1;
        char[][] tc = new char[3][7];
        tc[x][y] = 'X';
        Joc joc = new Joc();
        Assertions.assertArrayEquals(tc, joc.getTaulell());
    }
}*/