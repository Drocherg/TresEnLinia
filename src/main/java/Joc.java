public class Joc {
    private char[][] taulell; //Como indica el nombre es el tablero del juego que hay que ir actualizando en cada turno ver, metodo jugar
    private short torn;

    public short getTorn() {
        return torn;
    }

    public char[][] getTaulell() {
        return taulell;
    }

    public Joc() {

        this.taulell = new char[3][3]; // Inicializar el tablero con el tamaño adecuado
        // Inicializar el tablero con espacios en blanco (indicando celdas vacías)
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
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

    }

    public boolean jugadaGuanyadora() {
        boolean liniaX = false;
        boolean liniaO = false;
        short fila = ;
        short columna;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {// Tres en raya en las columnas con X
                if (taulell[i][j] == 'X' && taulell[i][j] == taulell[i][j + 1] && taulell[i][j + 1] == taulell[i][j + 2]) {
                    return liniaX;
                }
            }
        }
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {// Tres en raya en las filas con la X
                if (taulell[i][j] == 'X' && taulell[i][j] == taulell[i + 1][j] && taulell[i + 1][j] == taulell[i + 2][j]) {
                    return liniaX;
                }
            }
        }
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {// Tres en raya en diagonales descendente con X
                if (taulell[i][j] == 'X' && taulell[i][j] == taulell[i + 1][j + 1] && taulell[i + 1][j + 1] == taulell[i + 2][j + 2]) {
                    return liniaX;
                }
            }
        }
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {// Tres en raya en diagonal ascendente con X
                if (taulell[i][j] == 'X' && taulell[i][j] == taulell[i - 1][j + 1] && taulell[i - 1][j + 1] == taulell[i - 2][j + 2]) {
                    return liniaX;
                }
            }
        }
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {// Tres en raya en las columnas con O
                if (taulell[i][j] == 'O' && taulell[i][j] == taulell[i][j + 1] && taulell[i][j + 1] == taulell[i][j + 2]) {
                    return liniaO;
                }
            }
        }
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {// Tres en raya en las filas con O
                if (taulell[i][j] == 'O' && taulell[i][j] == taulell[i + 1][j] && taulell[i + 1][j] == taulell[i + 2][j]) {
                    return liniaO;
                }
            }
        }
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {// Tres en raya en diagonales descendente con O
                if (taulell[i][j] == 'O' && taulell[i][j] == taulell[i + 1][j + 1] && taulell[i + 1][j + 1] == taulell[i + 2][j + 2]) {
                    return liniaO;
                }
            }
        }
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {// Tres en raya en diagonal ascendente con O
                if (taulell[i][j] == 'O' && taulell[i][j] == taulell[i - 1][j + 1] && taulell[i - 1][j + 1] == taulell[i - 2][j + 2]) {
                    return liniaO;
                }
            }
        }
        return false;
    }
}


        /*for (fila = 0; fila < 2; fila++) {
            if (taulell[fila][1] != ' ' && taulell[fila][1] == taulell[fila][3] && taulell[fila][3] == taulell[fila][5]) {
                return true;
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

