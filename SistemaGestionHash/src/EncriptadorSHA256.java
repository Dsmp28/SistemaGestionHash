import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncriptadorSHA256 {

    // Método para encriptar un valor entero usando SHA-256 y devolver el resultado como un entero
    public static int encriptarSHA256(int valor) {
        try {
            // Crear una instancia de MessageDigest para SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Convertir el valor entero a un array de bytes
            byte[] bytes = intToBytes(valor);

            // Calcular el hash SHA-256 del array de bytes
            byte[] hash = digest.digest(bytes);

            // Convertir el hash a un entero
            int hashInt = bytesToInt(hash);

            return hashInt;
        } catch (NoSuchAlgorithmException e) {
            // Manejar una excepción si no se puede encontrar el algoritmo de encriptación
            e.printStackTrace();
            return -1; // Devolver un valor de error
        }
    }

    // Método para convertir un entero a un array de bytes
    private static byte[] intToBytes(int valor) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (valor >> 24);
        bytes[1] = (byte) (valor >> 16);
        bytes[2] = (byte) (valor >> 8);
        bytes[3] = (byte) valor;
        return bytes;
    }

    // Método para convertir un array de bytes a un entero
    private static int bytesToInt(byte[] bytes) {
        return ((bytes[0] & 0xFF) << 24) |
                ((bytes[1] & 0xFF) << 16) |
                ((bytes[2] & 0xFF) << 8) |
                (bytes[3] & 0xFF);
    }

}
