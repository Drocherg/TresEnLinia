public class Joc {
    private char taulell;
    private short torn;
    public short getTorn() {
        return torn;
    }

    public char getTaulell() {
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
