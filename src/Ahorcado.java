import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        // Scanner que nos permite leer datos desde la terminal
        Scanner sc = new Scanner(System.in);

        // Declaramos las variables
        String palabraSecreta = "gato";
        int intentosMax = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        // Arreglo de caracteres que contendrá las letras de la palabra secreta
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        // Bucle que nos permite intentar introducir la palabra secreta
        for (int i = 0; i < palabraSecreta.length(); i++) {
            letrasAdivinadas[i] = '_';
            // System.out.print(letrasAdivinadas[i]);
        }

        System.out.println("Numero de letras " + palabraSecreta.length());

        while (!palabraAdivinada && intentos < intentosMax) {
            System.out.println("Palabra a adivinar " + String.valueOf(letrasAdivinadas));

            System.out.println("Introduzca una letra");

            char letra = Character.toLowerCase(sc.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {

                if (letrasAdivinadas[i] == letra) {
                    System.out.println("Esta letra ya se ha introducido");
                    continue;
                }

                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                letraCorrecta = false;
                intentos++;
                System.out.println("Intentos restantes: " + (intentosMax - intentos));
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
                System.out.println("¡Has adivinado la palabra secreta!: " + palabraSecreta);
            }

        }

        if (!palabraAdivinada) {
            System.out.println("No has adivinado la palabra secreta: " + palabraSecreta);
        }

        sc.close();
    }
}
