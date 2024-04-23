import java.util.Scanner;// Importar la clase Scanner

public class Main {
    public static void main(String[] args) {
        MenuUsuario menu = new MenuUsuario(); // Crear una instancia de la clase MenuUsuario

        boolean continuar = true; // Variable para controlar si se debe continuar con el bucle
        while (continuar) { // Bucle para mostrar el menú y procesar las opciones del usuario
            Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
            try {
                menu.MostrarMenu(); // Mostrar el menú
                int opcion = scanner.nextInt(); // Leer la opción ingresada por el usuario
                continuar = menu.ManejadorOpciones(opcion); // Procesar la opción ingresada y actualizar continuar
            } catch (Exception e) { // Capturar excepciones si el formato de la opción ingresada no es válido
                System.out.println("El formato de la opción ingresada no es correcto. Por favor, intente de nuevo.");
            }
        }
    }
}
