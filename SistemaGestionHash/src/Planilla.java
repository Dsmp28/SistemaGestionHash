import java.util.HashMap; // Importar la clase HashMap

// Definición de la clase Planilla
public class Planilla {
    // Atributo para almacenar los empleados usando su número de empleado como clave
    private final HashMap<Integer, Empleado> empleados;

    // Constructor de la clase Planilla
    public Planilla() {
        empleados = new HashMap<>(); // Inicializar el HashMap de empleados
    }

    // Método para agregar un empleado a la planilla
    public void agregarEmpleado(Empleado empleado) {
        empleados.put(empleado.getNumeroEmpleado(), empleado); // Agregar el empleado al HashMap
    }

    // Método para obtener un empleado dado su número de empleado
    public Empleado getEmpleado(int numeroEmpleado) {
        return empleados.get(numeroEmpleado); // Obtener el empleado del HashMap usando el número de empleado como clave
    }

    // Método para imprimir todos los empleados en la planilla
    public void imprimirEmpleados() {
        // Mostrar un encabezado del reporte
        System.out.println("*****************************");
        System.out.println("*          Reporte          *");
        System.out.println("*****************************");
        System.out.println();

        // Iterar sobre todos los empleados en el HashMap y mostrar sus detalles
        for (Empleado empleado : empleados.values()) {
            System.out.println(empleado);
        }
    }
}