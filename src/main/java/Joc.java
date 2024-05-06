public class Joc {
    private char[][] taulell = new char[3][3]; //Como indica el nombre es el tablero del juego que hay que ir actualizando en cada turno ver, metodo jugar
    private short torn;

    public short getTorn() {
        return torn;
    }

    public char[][] getTaulell() {
        return taulell;
    }

    public Joc() {
        this.taulell = new char[3][7]; // Inicializar el tablero con el tamaño adecuado
        // Inicializar el tablero con espacios en blanco (indicando celdas vacías)
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 7; columna++) {
                taulell[fila][columna] = ' ';
            }
        }
        this.torn = 0; // Inicializar el contador de turnos a 0
    }

    public void novaPartida() {
        this.taulell = new char[3][3];
        this.torn = 1;
    }

    public void jugar(short fila, short columna) {
        if (taulell[fila][columna] == ' ') {
            // Determinar el jugador actual en función del turno
            char jugadorActual = (torn % 2 == 1) ? 'X' : 'O';

            // Colocar la ficha del jugador en la casilla seleccionada
            taulell[fila][columna] = jugadorActual;

            // Incrementar el contador de turnos
            torn++;

            if (jugadaGuanyadora() == true) {
                // Si hay un ganador, mostrar un mensaje y terminar el juego
                System.out.println("¡El jugador " + jugadorActual + " ha guanyat!");
            } else {
                return;
            }
        } else {
            // Si la casilla seleccionada no está vacía, mostrar un mensaje de error
            System.out.println("La casella seleccionada no està buida, no estaràs fent trampes?");
        }
    }

    public boolean jugadaGuanyadora() {
        short fila = 3;
        short columna = 3;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (taulell[i][j] != ' ' && taulell[i][j] == taulell[i][j + 1] && taulell[i][j + 1] == taulell[i][j + 2]) {
                    return true;
                }
            }
        }
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (taulell[i][j] != ' ' && taulell[i][j] == taulell[i + 1][j] && taulell[i + 1][j] == taulell[i + 2][j]) {
                    return true;
                }
            }
        }
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (taulell[i][j] != ' ' && taulell[i][j] == taulell[i + 1][j + 1] && taulell[i + 1][j + 1] == taulell[i + 2][j + 2]) {
                    return true;
                }
            }
        }
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (taulell[i][j] != ' ' && taulell[i][j] == taulell[i - 1][j + 1] && taulell[i - 1][j + 1] == taulell[i - 2][j + 2]) {
                    return true;
                }
            }
        }
        return false;
    }
}


        /*for (fila = 0; fila < 2; fila++) {
            if (taulell[fila][1] != ' ' && taulell[fila][1] == taulell[fila][3] && taulell[fila][3] == taulell[fila][5]) {
                return true; // Tres en raya en las filas
            }
        }
        // Verificar columnas
        for (columna = 0; columna < 2; columna++) {
            if (taulell[0][columna] != ' ' && taulell[0][columna] == taulell[1][columna] && taulell[1][columna] == taulell[2][columna]) {
                return true; // Tres en raya en las columnas
            }
        }
        // Verificar diagonal 1
        if (taulell[2][1] != ' ' && taulell[2][1] == taulell[1][3] && taulell[1][3] == taulell[0][5]) {
            return true; // Tres en raya en la diagonal 1
        }

        // Verificar diagonal 2
        if (taulell[0][0] != ' ' && taulell[0][0] == taulell[1][1] && taulell[1][1] == taulell[2][2]) {
            return true; // Tres en raya en la diagonal 2
        }
        return false; // No se encontró un tres en raya
    }
        }*/


    //| |X| |
    //|O|X|O|
    //|X| |O|

