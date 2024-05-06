public class Joc {
    private static char[][] taulell; //Como indica el nombre es el tablero del juego que hay que ir actualizando en cada turno ver, metodo jugar
    private static short torn;
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

            if (jugadaGuanyadora() == true) {
                // Si hay un ganador, mostrar un mensaje y terminar el juego
                System.out.println("¡El jugador " + jugadorActual + " ha guanyat!");
            }else {
                return;
            }
        } else {
            // Si la casilla seleccionada no está vacía, mostrar un mensaje de error
            System.out.println("La casella seleccionada no està buida, no estaràs fent trampes?");
        }
    }
    public static boolean jugadaGuanyadora() {
        short fila;
        short columna;
        for (fila = 0; fila < 2; fila++) {
            if (taulell[fila][1] != ' ' && taulell[fila][1] == taulell[fila][3] && taulell[fila][3] == taulell[fila][5]) {
                return true; // Tres en raya en las filas
            }
        }
        // Verificar columnas
        for (columna = 0; columna < 6; columna++) {
            if (taulell[0][columna] != ' ' && taulell[0][columna] == taulell[1][columna] && taulell[1][columna] == taulell[2][columna]) {
                return true; // Tres en raya en las columnas
            }
        }
        // Verificar diagonal 1
        if (taulell[2][1] != ' ' && taulell[2][1] == taulell[1][3] && taulell[1][3] == taulell[0][5]) {
            return true; // Tres en raya en la diagonal 1
        }

        // Verificar diagonal 2
        if (taulell[0][1] != ' ' && taulell[0][1] == taulell[1][3] && taulell[1][3] == taulell[2][5]) {
            return true; // Tres en raya en la diagonal 2
        }
        return false; // No se encontró un tres en raya
    }
        }


    //| |X| |
    //|O|X|O|
    //|X| |O|

