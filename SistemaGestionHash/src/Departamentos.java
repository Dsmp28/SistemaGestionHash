import java.util.List; // Importar la clase List

public class Departamentos {
    private final List<String> departamentos; // Lista para almacenar los nombres de los departamentos

    // Constructor que inicializa la lista de departamentos con valores predeterminados
    public Departamentos() {
        departamentos = List.of("Recursos Humanos", "Finanzas", "TI", "Ventas", "Marketing");
    }

    // Método para obtener el nombre de un departamento dado su índice
    public String getDepartamento(int indice) {
        return departamentos.get(indice);
    }

    // Método para generar una representación en forma de cadena de los departamentos
    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder("""
                *****************************
                *       Departamentos       *
                *****************************
                """);

        // Iterar sobre la lista de departamentos y agregar cada uno al mensaje
        for (int i = 0; i < departamentos.size(); i++) {
            mensaje.append("* ").append(i + 1).append(". ").append(departamentos.get(i)).append("\n");
        }

        mensaje.append("*****************************"); // Agregar línea final al mensaje

        return mensaje.toString(); // Convertir el StringBuilder a String y devolverlo
    }
}

