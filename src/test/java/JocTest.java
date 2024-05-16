import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class JocTest {
    @org.junit.jupiter.api.Test
    void novaPartida() {
        Joc joc = new Joc();

        //crea un tablero vacio
        char[][] t_vacio = new char[3][3];
        for (short fila = 0; fila < 3; fila++) {
            for (short columna = 0; columna < 3; columna++) {
                t_vacio[fila][columna] = ' '; // Asignar espacios en blanco a cada celda del tablero
            }
        }
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
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugada_jugador1(short fila, short columna) {
        Joc joc = new Joc();
        char[][] tablero = new char[3][3];

        // Verifica que la casilla esté vacía antes de realizar la jugada
        if (tablero[fila][columna] == ' ') {
            // Realiza la jugada colocando una 'X' en la fila y columna especificadas
            tablero[fila][columna] = 'X';

            // Prueba el turno 1 del jugador 1
            Assertions.assertEquals(1, joc.getTorn());
            // Realiza la jugada en el juego
            joc.jugar(fila, columna);
            // Comprueba la jugada
            Assertions.assertArrayEquals(tablero, joc.getTaulell());
        }

    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugada_jugador2(short fila, short columna) {
        Joc joc = new Joc();
        char[][] tablero = new char[3][3];

        // Verifica que la casilla esté vacía antes de realizar la jugada
        if (tablero[fila][columna] == ' ') {
            // Realiza la jugada colocando una 'X' en la fila y columna especificadas
            tablero[fila][columna] = 'O';

            // Prueba el turno 1 del jugador 1
            Assertions.assertEquals(1, joc.getTorn());
            // Realiza la jugada en el juego
            joc.jugar(fila, columna);
            // Comprueba la jugada
            Assertions.assertArrayEquals(tablero, joc.getTaulell());
        }

    }

    @org.junit.jupiter.api.Test
    void empat() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Llenar todas las casillas del tablero
        for (short fila = 0; fila < 3; fila++) {
            for (short columna = 0; columna < 3; columna++) {
                joc.jugar(fila, columna);
            }
        }

        Assertions.assertTrue(joc.empat());
    }
    @ParameterizedTest
    @CsvSource({"3", "4", "5", "6", "7", "8", "9", "10"})
    void taulellConfigurat(short novaMida) throws IOException {
        TUI tui = new TUI();
        File nouTaulell = new File("nouTaulell.txt");
        // Elimina el archivo si existe previamente
        if (nouTaulell.exists()) {
            nouTaulell.delete();
        }

        // Llama al método para configurar el archivo
        nouTaulell.createNewFile();
        // Comprueba si el archivo se creó correctamente
        Assertions.assertTrue(nouTaulell.exists());

        // Comprueba si el nombre del archivo es correcto
        Assertions.assertEquals("nouTaulell.txt", nouTaulell.getName());

        // Escribe el contenido en el archivo
        FileWriter fw = new FileWriter(nouTaulell);
        fw.write(String.valueOf(novaMida));
        fw.close();

        // Lee el contenido del archivo y comprueba si coincide con novaMida
        Scanner sc = new Scanner(nouTaulell);
        short contenido = Short.parseShort(sc.nextLine());
        sc.close();
        Assertions.assertEquals(novaMida, contenido);
    }
    @org.junit.jupiter.api.Test
    void gjugador1Condicion1() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 0, (short) 0); // Jugador 1
        joc.jugar((short) 0, (short) 1); // Jugador 2
        joc.jugar((short) 1, (short) 0); // Jugador 1
        joc.jugar((short) 1, (short) 1); // Jugador 2
        joc.jugar((short) 2, (short) 0); // Jugador 1
        /*
   | 0 | 1 | 2 |
-----------------
 0 | X | O |   |
-----------------
 1 | X | O |   |
-----------------
 2 | X |   |   |
-----------------
        */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
    @org.junit.jupiter.api.Test
    void gjugador1Condicion2() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 0, (short) 1); // Jugador 1
        joc.jugar((short) 0, (short) 0); // Jugador 2
        joc.jugar((short) 1, (short) 1); // Jugador 1
        joc.jugar((short) 1, (short) 0); // Jugador 2
        joc.jugar((short) 2, (short) 1); // Jugador 1
        /*
   | 0 | 1 | 2 |
-----------------
 0 | O | X |   |
-----------------
 1 | O | X |   |
-----------------
 2 |   | X |   |
-----------------
        */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
    @org.junit.jupiter.api.Test
    void gjugador1Condicion3() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 0, (short) 2); // Jugador 1
        joc.jugar((short) 0, (short) 0); // Jugador 2
        joc.jugar((short) 1, (short) 2); // Jugador 1
        joc.jugar((short) 1, (short) 0); // Jugador 2
        joc.jugar((short) 2, (short) 2); // Jugador 1
    /*
   | 0 | 1 | 2 |
-----------------
 0 | O |   | X |
-----------------
 1 | O |   | X |
-----------------
 2 |   |   | X |
-----------------
    */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
    @org.junit.jupiter.api.Test
    void gjugador1Condicion4() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 0, (short) 0); // Jugador 1
        joc.jugar((short) 1, (short) 0); // Jugador 2
        joc.jugar((short) 0, (short) 1); // Jugador 1
        joc.jugar((short) 1, (short) 1); // Jugador 2
        joc.jugar((short) 0, (short) 2); // Jugador 1
        /*
   | 0 | 1 | 2 |
-----------------
 0 | X | X | X |
-----------------
 1 | O | O |   |
-----------------
 2 |   |   |   |
-----------------
        */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
    @org.junit.jupiter.api.Test
    void gjugador1Condicion5() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 1, (short) 0); // Jugador 1
        joc.jugar((short) 0, (short) 0); // Jugador 2
        joc.jugar((short) 1, (short) 1); // Jugador 1
        joc.jugar((short) 0, (short) 1); // Jugador 2
        joc.jugar((short) 1, (short) 2); // Jugador 1
        /*
   | 0 | 1 | 2 |
-----------------
 0 | O | O |   |
-----------------
 1 | X | X | X |
-----------------
 2 |   |   |   |
-----------------
        */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
    @org.junit.jupiter.api.Test
    void gjugador1Condicion6() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 2, (short) 0); // Jugador 1
        joc.jugar((short) 0, (short) 0); // Jugador 2
        joc.jugar((short) 2, (short) 1); // Jugador 1
        joc.jugar((short) 0, (short) 1); // Jugador 2
        joc.jugar((short) 2, (short) 2); // Jugador 1
        /*
   | 0 | 1 | 2 |
-----------------
 0 | O | O |   |
-----------------
 1 |   |   |   |
-----------------
 2 | X | X | X |
-----------------
        */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
    @org.junit.jupiter.api.Test
    void gjugador1Condicion7() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 2, (short) 0); // Jugador 1
        joc.jugar((short) 1, (short) 0); // Jugador 2
        joc.jugar((short) 1, (short) 1); // Jugador 1
        joc.jugar((short) 1, (short) 2); // Jugador 2
        joc.jugar((short) 0, (short) 2); // Jugador 1
        /*
   | 0 | 1 | 2 |
-----------------
 0 |   |   | X |
-----------------
 1 | O | X | O |
-----------------
 2 | X |   |   |
-----------------
        */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
    @org.junit.jupiter.api.Test
    void gjugador1Condicion8() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 0, (short) 0); // Jugador 1
        joc.jugar((short) 1, (short) 0); // Jugador 2
        joc.jugar((short) 1, (short) 1); // Jugador 1
        joc.jugar((short) 1, (short) 2); // Jugador 2
        joc.jugar((short) 2, (short) 2); // Jugador 1
        /*
   | 0 | 1 | 2 |
-----------------
 0 | X |   |   |
-----------------
 1 | O | X | O |
-----------------
 2 |   |   | X |
-----------------
        */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
    @org.junit.jupiter.api.Test
    void gjugador2Condicion1() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 0, (short) 0); // Jugador 1
        joc.jugar((short) 0, (short) 1); // Jugador 2
        joc.jugar((short) 1, (short) 0); // Jugador 1
        joc.jugar((short) 1, (short) 1); // Jugador 2
        joc.jugar((short) 2, (short) 0); // Jugador 1
        /*
   | 0 | 1 | 2 |
-----------------
 0 | O | X |   |
-----------------
 1 | O | X |   |
-----------------
 2 | O |   |   |
-----------------
        */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
    @org.junit.jupiter.api.Test
    void gjugador2Condicion2() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 0, (short) 1); // Jugador 1
        joc.jugar((short) 0, (short) 0); // Jugador 2
        joc.jugar((short) 1, (short) 1); // Jugador 1
        joc.jugar((short) 1, (short) 0); // Jugador 2
        joc.jugar((short) 2, (short) 1); // Jugador 1
        /*
   | 0 | 1 | 2 |
-----------------
 0 | X | O |   |
-----------------
 1 | X | O |   |
-----------------
 2 |   | O |   |
-----------------
        */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
    @org.junit.jupiter.api.Test
    void gjugador2Condicion3() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 0, (short) 2); // Jugador 1
        joc.jugar((short) 0, (short) 0); // Jugador 2
        joc.jugar((short) 1, (short) 2); // Jugador 1
        joc.jugar((short) 1, (short) 0); // Jugador 2
        joc.jugar((short) 2, (short) 2); // Jugador 1
    /*
   | 0 | 1 | 2 |
-----------------
 0 | X |   | O |
-----------------
 1 | X |   | O |
-----------------
 2 |   |   | O |
-----------------
    */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
    @org.junit.jupiter.api.Test
    void gjugador2Condicion4() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 0, (short) 0); // Jugador 1
        joc.jugar((short) 1, (short) 0); // Jugador 2
        joc.jugar((short) 0, (short) 1); // Jugador 1
        joc.jugar((short) 1, (short) 1); // Jugador 2
        joc.jugar((short) 0, (short) 2); // Jugador 1
        /*
   | 0 | 1 | 2 |
-----------------
 0 | O | O | O |
-----------------
 1 | X | X |   |
-----------------
 2 |   |   |   |
-----------------
        */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
    @org.junit.jupiter.api.Test
    void gjugador2Condicion5() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 1, (short) 0); // Jugador 1
        joc.jugar((short) 0, (short) 0); // Jugador 2
        joc.jugar((short) 1, (short) 1); // Jugador 1
        joc.jugar((short) 0, (short) 1); // Jugador 2
        joc.jugar((short) 1, (short) 2); // Jugador 1
        /*
   | 0 | 1 | 2 |
-----------------
 0 | X | X |   |
-----------------
 1 | O | O | O |
-----------------
 2 |   |   |   |
-----------------
        */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
    @org.junit.jupiter.api.Test
    void gjugador2Condicion6() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 2, (short) 0); // Jugador 1
        joc.jugar((short) 0, (short) 0); // Jugador 2
        joc.jugar((short) 2, (short) 1); // Jugador 1
        joc.jugar((short) 0, (short) 1); // Jugador 2
        joc.jugar((short) 2, (short) 2); // Jugador 1
        /*
   | 0 | 1 | 2 |
-----------------
 0 | X | X |   |
-----------------
 1 |   |   |   |
-----------------
 2 | O | O | O |
-----------------
        */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
    @org.junit.jupiter.api.Test
    void gjugador2Condicion7() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 2, (short) 0); // Jugador 1
        joc.jugar((short) 1, (short) 0); // Jugador 2
        joc.jugar((short) 1, (short) 1); // Jugador 1
        joc.jugar((short) 1, (short) 2); // Jugador 2
        joc.jugar((short) 0, (short) 2); // Jugador 1
        /*
   | 0 | 1 | 2 |
-----------------
 0 |   |   | O |
-----------------
 1 | X | O | X |
-----------------
 2 | O |   |   |
-----------------
        */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
    @org.junit.jupiter.api.Test
    void gjugador2Condicion8() throws IOException {
        TUI tui = new TUI();
        Joc joc = new Joc();
        tui.selNovaPartida();
        joc.novaPartida();

        // Hacer movimientos para que el jugador 1 gane
        joc.jugar((short) 0, (short) 0); // Jugador 1
        joc.jugar((short) 1, (short) 0); // Jugador 2
        joc.jugar((short) 1, (short) 1); // Jugador 1
        joc.jugar((short) 1, (short) 2); // Jugador 2
        joc.jugar((short) 2, (short) 2); // Jugador 1
        /*
   | 0 | 1 | 2 |
-----------------
 0 | O |   |   |
-----------------
 1 | X | O | X |
-----------------
 2 |   |   | O |
-----------------
        */
        // Verificar que el jugador 1 gana
        Assertions.assertTrue(joc.jugadaGuanyadora());
    }
}
    /*@org.junit.jupiter.api.Test
    void gravarPartida() throws IOException {
        Joc joc = new Joc();
        File archivo = new File("savedgames");

        archivo.delete();
        joc.novaPartida();
        joc.gravarPartida();

        Assertions.assertTrue(archivo.exists());
        Assertions.assertEquals("savedgames", archivo.getName());
    }*/
    /*@org.junit.jupiter.api.Test
    void testCrearDirectorio() {
        TUI tui = new TUI();
        File directorio = new File("savedgames");

        boolean creado = directorio.mkdir();

        Assertions.assertTrue(creado);
        Assertions.assertTrue(directorio.exists());
        Assertions.assertTrue(directorio.isDirectory());
        Assertions.assertEquals("savedgames", directorio.getName());
    }*/
    /*@org.junit.jupiter.api.Test
    void testCrearArchivoConFormatoFecha() {
        TUI tui = new TUI();
        File directorio = new File("savedgames");
        directorio.mkdir();

        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String nombreArchivo = formatoFecha.format(fechaActual);
        File archivo = new File("savedgames/" + nombreArchivo);

        boolean creado = false;

        Assertions.assertTrue(creado);
        Assertions.assertTrue(archivo.exists());
        Assertions.assertFalse(archivo.isDirectory());
        Assertions.assertEquals(nombreArchivo, archivo.getName());
    }*/