public class Empleado {
    // Atributos de la clase Empleado
    private final String nombre;
    private final String departamento;
    private final int numeroEmpleado;

    // Método getter para obtener el número de empleado encriptado
    public int getNumeroEmpleado() {
        /* Se llama al método estático encriptarSHA256 de la clase EncriptadorSHA256
        para encriptar el número de empleado y luego se devuelve*/
        return EncriptadorSHA256.encriptarSHA256(numeroEmpleado);
    }

    // Constructor de la clase Empleado
    public Empleado(String nombre, String departamento, int numeroEmpleado) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.numeroEmpleado = numeroEmpleado;
    }

    // Método toString para generar una representación en forma de cadena del empleado
    @Override
    public String toString() {
        // Se construye y devuelve un mensaje que contiene la información del empleado
        return "*****************************\n" +
                "*          Empleado         *\n" +
                "*****************************\n" +
                "* Nombre: " + nombre + "\n" +
                "* Departamento: " + departamento + "\n" +
                "* Número de empleado: " + numeroEmpleado + "\n" +
                "*****************************\n\n";
    }
}

