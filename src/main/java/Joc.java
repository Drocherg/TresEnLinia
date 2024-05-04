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
        String[][] matrix = {
                {"|"," ","|"," ","|"," ","|"},
                {"|"," ","|"," ","|"," ","|"},
                {"|"," ","|"," ","|"," ","|"}};
        for (String[] strings : matrix) {
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
        novaPartida().string;
        
        short fila = 0;
        short columna = 0;

        for (;fila < 6; fila++)		// El primer índice recorre las filas
            for (;columna < 2; columna++){ // El segundo índice recorre las columnas
                int anterior2 = novaPartida()[fila - 2][columna];
                int anterior = novaPartida()[fila - 1][columna];
                int actual = novaPartida()[fila][columna];

            }
        return jugadaGuanyadora();
    }


    //| | | |
    //| | | |
    //| | | |
}
