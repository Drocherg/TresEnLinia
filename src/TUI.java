public class TUI {
    private static void novaPartida(){
        System.out.println("1. Nova partida");
    }
    private static void carregarPartida(){
        System.out.println("2. Carregar partida");
    }
    private static void configuracio(){
        System.out.println("3. Configuració");
    }
    private static void sortir() {
        System.out.println("4. Sortir");
    }
    public static void menu(){
        System.out.println("Esculli una opció:");
        novaPartida();
        carregarPartida();
        configuracio();
        sortir();

    }
}