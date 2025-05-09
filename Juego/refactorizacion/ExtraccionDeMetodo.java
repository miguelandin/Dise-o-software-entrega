package refactorizacion;

public class ExtraccionDeMetodo {
	public static void imprimirDistribucionPuntosPersonalizado(int danio, int magia, int armadura, int velocidad) {
        System.out.println("         _______________________________");
        System.out.println("       / \\                              \\");
        System.out.println("      |   |                             |");
        System.out.println("       \\_/|  » DISTRIBUCIÓN DE PUNTOS « |");
        System.out.println("          |                             |");
        printStatPersonalizado("Daño", danio);
        printStatPersonalizado("Magia", magia);
        printStatPersonalizado("Armadura", armadura);
        printStatPersonalizado("Velocidad", velocidad);
        System.out.println("          |                             |");
        System.out.println("          |   __________________________|__");
        System.out.println("          |  /                            /");
        System.out.println("          \\_/____________________________/");
    }

    public static void printStatPersonalizado(String nombreStat, int valor) {
        if (valor > 9) {
            System.out.printf("          |  » %s: %d\n", nombreStat, valor);
        } else {
            System.out.printf("          |  » %s: %d\n", nombreStat, valor);
        }
    }
	public static void imprimirDistribucionPuntosClases(int eleccion,int danio, int magia, int armadura, int velocidad) {
		System.out.println("         _______________________________");
        System.out.println("       / \\                              \\");
        System.out.println("      |   |                             |");
        System.out.println("       \\_/|  » DISTRIBUCIÓN DE PUNTOS « |");
        System.out.println("          |                             |");
        printStatClases("Daño", danio, eleccion == 1);
        printStatClases("Magia", magia, eleccion == 3);
        printStatClases("Armadura", armadura, eleccion == 2);
        System.out.printf("          |  » Velocidad: %-19d\n", velocidad);
        System.out.println("          |                             |");
        System.out.println("          |   __________________________|__");
        System.out.println("          |  /                            /");
        System.out.println("          \\_/____________________________/");
	
	}
	private static void printStatClases(String nombreStat, int valor, boolean isSelected) {
        if (isSelected) {
            System.out.printf("          |  » %s: %-19d\n", nombreStat, valor);
        } else {
            System.out.printf("          |  » %s: %-20d\n", nombreStat, valor);
        }
    }

    public static void printGameOver() {
        System.out.println(
            " _  _  _  _  _  _  _  _  _  _  _  _  _  _  _  _  _  _  _ \n" +
            "|_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_|\n" +
            "|_|                                                   |_|\n" +
            "|_|                                                   |_|\n" +
            "|_|  ________  ________  _____ ______   _______       |_|\n" +
            "|_| |\\   ____\\|\\   __  \\|\\   _ \\  _   \\|\\  ___ \\      |_|\n" +
            "|_| \\ \\  \\___|\\ \\  \\|\\  \\ \\  \\\\\\__\\ \\  \\ \\   __/|     |_|\n" +
            "|_|  \\ \\  \\  __\\ \\   __  \\ \\  \\\\|__| \\  \\ \\  \\_|/__   |_|\n" +
            "|_|   \\ \\  \\|\\  \\ \\  \\ \\  \\ \\  \\    \\ \\  \\ \\  \\_|\\ \\  |_|\n" +
            "|_|    \\ \\_______\\ \\__\\ \\__\\ \\__\\    \\ \\__\\ \\_______\\ |_|\n" +
            "|_|     \\|_______|\\|__|\\|__|\\|__|     \\|__|\\|_______| |_|\n" +
            "|_|                                                   |_|\n" +
            "|_|                                                   |_|\n" +
            "|_|                                                   |_|\n" +
            "|_|  ________  ___      ___ _______   ________        |_|\n" +
            "|_| |\\   __  \\|\\  \\    /  /|\\  ___ \\ |\\   __  \\       |_|\n" +
            "|_| \\ \\  \\|\\  \\ \\  \\  /  / | \\   __/|\\ \\  \\|\\  \\      |_|\n" +
            "|_|  \\ \\  \\\\\\  \\ \\  \\/  / / \\ \\  \\_|/_\\ \\   _  _\\     |_|\n" +
            "|_|   \\ \\  \\\\\\  \\ \\    / /   \\ \\  \\_|\\ \\ \\  \\\\  \\|    |_|\n" +
            "|_|    \\ \\_______\\ \\__/ /     \\ \\_______\\ \\__\\\\ _\\    |_|\n" +
            "|_|     \\|_______|\\|__|/       \\|_______|\\|__|\\|__|   |_|\n" +
            "|_|                                                   |_|\n" +
            "|_| _  _  _  _  _  _  _  _  _  _  _  _  _  _  _  _  _ |_|\n" +
            "|_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_|\n"
        );
    }
}
