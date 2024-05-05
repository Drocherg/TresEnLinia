public class Joc {
    private static char[][] taulell; //Como indica el nombre es el tablero del juego que hay que ir actualizando en cada turno ver, metodo jugar
    private static short torn;
    public short getTorn() {
        return torn;
    }

    public char[][] getTaulell() {
        return taulell;
    }

    public static String novaPartida() {
        String[][] array = {
                {"|"," ","|"," ","|"," ","|"},
                {"|"," ","|"," ","|"," ","|"},
                {"|"," ","|"," ","|"," ","|"}};
        for (String[] strings : array) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
        return "Hola";
    }

    public static void jugar(short fila, short columna){
        if (taulell[fila][columna] == ' ') {
            // Determinar el jugador actual en función del turno
            char jugadorActual = (torn % 2 == 1) ? 'X' : 'O';

            // Colocar la ficha del jugador en la casilla seleccionada
            taulell[fila][columna] = jugadorActual;

            // Incrementar el contador de turnos
            torn++;

            if (jugadaGuanyadora()) {
                // Si hay un ganador, mostrar un mensaje y terminar el juego
                System.out.println("¡El jugador " + jugadorActual + " ha guanyat!");
            }
        } else {
            // Si la casilla seleccionada no está vacía, mostrar un mensaje de error
            System.out.println("La casella seleccionada no està buida, no estaràs fent trampes?");
        }
    }
    public static boolean jugadaGuanyadora() {
        novaPartida();
        short fila = 0;
        short columna = 0;
        for (; fila < 3; fila++) {
            if (novaPartida()[fila][1] != ' ' && novaPartida()[fila][1] == novaPartida()[fila][3] && novaPartida()[fila][3] == novaPartida()[fila][5]) {
                return true; // Tres en raya en la fila i
            }
        }
        // Verificar columnas
        for (;columna < 3; columna++) {
            if (novaPartida()[0][columna] != ' ' && novaPartida()[0][columna] == novaPartida()[1][columna] && novaPartida()[1][columna] == novaPartida()[2][columna]) {
                return true; // Tres en raya en la columna tal
            }
        }
        // Verificar diagonal principal
        if (novaPartida()[0][1] != ' ' && novaPartida()[0][1] == novaPartida()[1][3] && novaPartida()[1][3] == novaPartida()[2][5]) {
            return true; // Tres en raya en la diagonal principal
        }

        // Verificar diagonal secundaria
        if (novaPartida()[1][3] != ' ' && novaPartida()[0][5] == novaPartida()[1][3] && novaPartida()[1][3] == novaPartida()[2][1]) {
            return true; // Tres en raya en la diagonal secundaria
        }
        return false; // No se encontró un tres en raya
    }
        }
        return jugadaGuanyadora();


    //| | | |
    //| | | |
    //| | | |

