public class Joc {
    private static char taulell;
    private static short torn;
    public static short getTorn() {
        return torn;
    }

    public static char getTaulell() {
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

    public static void jugar(){
        short fila;
        short columna;

        return ;
    }
    public boolean jugadaGuanyadora() {
        short fila;
        short columna;
        return jugadaGuanyadora();
    }
    //| | | |
    //| | | |
    //| | | |
}
