public class Joc {
    private char[][] taulell;
    //Como indica el nombre es el tablero del juego que hay que ir actualizando en cada turno, ver metodo jugar
    private short torn;

    public short getTorn() {
        return torn;
    }

    public char[][] getTaulell() {
        return taulell;
    }

    public void novaPartida() {
        this.taulell = new char[3][3];
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                taulell[fila][columna] = ' '; // Asignar espacios en blanco a cada celda del tablero
            }
        }
        this.torn = 1;
    }

    public char[][] jugar(short fila,short columna) {
        if (taulell[fila][columna] == ' ') {
            // Determinar el jugador actual en función del turno
            char jugadorActual = (torn % 2 == 1) ? 'X' : 'O';

            // Colocar la ficha del jugador en la casilla seleccionada
            taulell[fila][columna] = jugadorActual;

            // Incrementar el contador de turnos
            torn++;
        }
        return taulell;// No se ha podido hacer la jugada debido a que la casilla esta ocupada
    }
    public boolean jugadaGuanyadora() {
        // Tres en raya en las filas y columnas
        for (int i = 0; i < 3; i++) {
            if (taulell[i][0] != ' ' && taulell[i][0] == taulell[i][1] && taulell[i][1] == taulell[i][2]) {
                return true; // Tres en raya en la fila i
            }
            if (taulell[0][i] != ' ' && taulell[0][i] == taulell[1][i] && taulell[1][i] == taulell[2][i]) {
                return true; // Tres en raya en la columna i
            }
        }

        // Tres en raya en las diagonales
        if (taulell[0][0] != ' ' && taulell[0][0] == taulell[1][1] && taulell[1][1] == taulell[2][2]) {
            return true; // Tres en raya en la diagonal principal
        }
        if (taulell[0][2] != ' ' && taulell[0][2] == taulell[1][1] && taulell[1][1] == taulell[2][0]) {
            return true; // Tres en raya en la diagonal secundaria
        }

        return false; // No se encontró un tres en raya
    }
    public boolean empat() {
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (taulell[fila][columna] == ' ') {
                    return false; // Si alguna casilla está vacía, no es empate
                }
            }
        }
        return true; // Si todas las casillas están llenas, es empate
    }
    public void tEmpat(){
        System.out.println("No hi han mes caselles lliures, queda en empat!");
    }
}

    //| |X| |
    //|O|X|O|
    //|X| |O|