/*
    Autor: Arturo Duarte
    Date: 02-2024
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PeticionGET {

    public static void main(String[] args) {
        try {
            String varUrl = "https://www.google.com/";
            URL url = new URL(varUrl);

            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            // Verificar el código de respuesta
            int codigoRespuesta = conexion.getResponseCode();
            if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
                // LEER DE LA URL
                BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

                String linea;

                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
                reader.close(); // cerrar flujo
            } else {
                System.out.println("La petición GET no fue exitosa. Código de respuesta: " + codigoRespuesta);
            }

        } catch (IOException e) {
            System.err.println("Error al realizar la petición GET: " + e.getMessage());
        }
    }// main
}
