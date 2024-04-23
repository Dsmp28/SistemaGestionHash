import java.util.Scanner; // Importar la clase Scanner

// Definición de la clase MenuUsuario
public class MenuUsuario {
    // Atributos de la clase MenuUsuario
    private final Planilla planilla;
    private final Scanner scanner;

    // Constructor de la clase MenuUsuario
    public MenuUsuario(){
        planilla = new Planilla(); // Inicialización de la instancia de Planilla
        scanner = new Scanner(System.in); // Inicialización del objeto Scanner para leer entrada del usuario
    }

    // Método para mostrar el menú en la consola
    public void MostrarMenu() {
        // Mostrar el menú con bordes decorativos
        System.out.println("╔════════════════════════════╗");
        System.out.println("║          Menú              ║");
        System.out.println("╠════════════════════════════╣");
        System.out.println("║ 1. Agregar Empleado        ║");
        System.out.println("║ 2. Imprimir Empleados      ║");
        System.out.println("║ 3. Buscar Empleados        ║");
        System.out.println("║ 4. Salir                   ║");
        System.out.println("╚════════════════════════════╝");
        System.out.print("║ Ingrese una opción:"); // Solicitar al usuario que ingrese una opción
    }

    // Método para manejar las opciones del usuario
    public boolean ManejadorOpciones(int opcion){
        return switch (opcion) { // Utilizar una expresión switch para manejar diferentes opciones
            case 1 -> {
                MenuAgregar(); // Llamar al método para agregar un empleado
                yield true;
            }
            case 2 -> {
                planilla.imprimirEmpleados(); // Llamar al método para imprimir empleados
                yield true;
            }
            case 3 -> {
                MenuBuscar(); // Llamar al método para buscar empleados
                yield true;
            }
            case 4 -> {
                System.out.println("Feliz día!"); // Mostrar mensaje de despedida
                yield false; // Salir del programa
            }
            default -> {
                System.out.println("Opción no válida"); // Mostrar mensaje de opción no válida
                yield true;
            }
        };
    }

    // Método para agregar un empleado
    private void MenuAgregar() {
        String nombre = obtenerNombre(); // Obtener el nombre del empleado
        String departamento = obtenerDepartamento(); // Obtener el departamento del empleado
        int numeroEmpleado = obtenerNumeroEmpleado(); // Obtener el número de empleado

        // Crear una instancia de Empleado con los datos proporcionados y agregarlo a la planilla
        Empleado empleado = new Empleado(nombre, departamento, numeroEmpleado);
        planilla.agregarEmpleado(empleado);
    }

    // Método para obtener el nombre del empleado
    private String obtenerNombre() {
        System.out.println("-----------------------------");
        String nombre;
        do {
            System.out.println("Ingrese el nombre del empleado:");
            nombre = scanner.next(); // Leer el nombre ingresado por el usuario
            if (nombre.isEmpty()) { // Verificar si el nombre está en blanco
                System.out.println("Error: El nombre no puede estar en blanco. Por favor, ingrese un nombre válido.");
                System.out.println();
            }
        } while (nombre.isEmpty()); // Repetir el ciclo hasta que se ingrese un nombre válido
        return nombre; // Devolver el nombre ingresado
    }

    // Método para obtener el departamento del empleado
    private String obtenerDepartamento() {
        System.out.println("-----------------------------");
        String departamento = "";
        do {
            Departamentos departamentos = new Departamentos(); // Crear una instancia de Departamentos
            System.out.println("Seleccione el departamento de la siguiente lista:");
            System.out.println(departamentos); // Mostrar la lista de departamentos
            System.out.print("* Ingrese una opción:");
            try {
                int indice = Integer.parseInt(scanner.next()); // Leer la opción ingresada por el usuario
                departamento = departamentos.getDepartamento(indice - 1); // Obtener el departamento seleccionado
            } catch (Exception e) {
                System.out.println("Error: La opción ingresada no es válida. Por favor, ingrese un número de la lista.");
                System.out.println();
            }
        } while (departamento.isEmpty()); // Repetir el ciclo hasta que se seleccione un departamento válido
        return departamento; // Devolver el departamento seleccionado
    }

    // Método para obtener el número de empleado
    private int obtenerNumeroEmpleado() {
        System.out.println("-----------------------------");
        int numeroEmpleado;
        do {
            System.out.println("Ingrese el número de empleado:");
            try {
                numeroEmpleado = Integer.parseInt(scanner.next()); // Leer el número de empleado ingresado por el usuario
                if (planilla.getEmpleado(EncriptadorSHA256.encriptarSHA256(numeroEmpleado)) != null) { // Verificar si el número de empleado ya existe
                    System.out.println("Error: El número de empleado ya existe. Por favor, ingrese un número de empleado diferente.");
                    numeroEmpleado = -1; // Establecer el número de empleado en -1 para repetir la solicitud
                    System.out.println();
                } else if (numeroEmpleado < 0) { // Verificar si el número de empleado es negativo
                    System.out.println("Error: El número de empleado no puede ser menor a cero. Por favor, ingrese un número de empleado válido.");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Error: El formato del número de empleado no es válido. Por favor, ingrese un número de empleado válido.");
                numeroEmpleado = -1; // Establecer el número de empleado en -1 para repetir la solicitud
                System.out.println();
            }
        } while (numeroEmpleado < 0); // Repetir el ciclo hasta que se ingrese un número de empleado válido
        return numeroEmpleado; // Devolver el número de empleado ingresado
    }

    // Método para buscar empleados
    private void MenuBuscar(){
        System.out.println("-----------------------------");
        boolean continuar = true;
        do {
            System.out.println("Ingrese el número de empleado a buscar:");
            try {
                int numeroEmpleado = scanner.nextInt(); // Leer el número de empleado a buscar
                Empleado empleado = planilla.getEmpleado(EncriptadorSHA256.encriptarSHA256(numeroEmpleado)); // Obtener el empleado correspondiente al número de empleado
                if (empleado != null) { // Verificar si se encontró el empleado
                    System.out.println(empleado); // Mostrar los detalles del empleado
                } else {
                    System.out.println("Empleado no encontrado."); // Mostrar mensaje de empleado no encontrado
                }
                System.out.println("¿Desea buscar otro empleado? (s/n)"); // Preguntar al usuario si desea buscar otro empleado
                String respuesta = scanner.next(); // Leer la respuesta del usuario
                continuar = respuesta.equalsIgnoreCase("s"); // Actualizar continuar según la respuesta del usuario
            } catch (Exception e){
                System.out.println("Error: El formato del número de empleado no es válido. Por favor, ingrese un número de empleado válido.");
            }
        }while (continuar); // Repetir el ciclo mientras el usuario desee buscar otro empleado
    }
}
