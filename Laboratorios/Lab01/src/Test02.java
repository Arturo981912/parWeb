/*
    Autor: Arturo Duarte
    Date: 02-2024
 */

 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.net.HttpURLConnection;
 import java.net.URL;
 
 import javax.net.ssl.HttpsURLConnection;
 
 public class Test02 {
     public static void main(String[] args) {
         // URL para probar HTTP
         String httpUrl = "http://grado.pol.una.py";
         // URL para probar HTTPS
         String httpsUrl = "https://grado.pol.una.py";
 
         System.out.println("Haciendo solicitud HTTP:");
         try {
             hacerRequest(httpUrl);
         } catch (IOException e) {
             System.err.println("Error al hacer la solicitud HTTP: " + e.getMessage());
         }
 
         System.out.println("\nHaciendo solicitud HTTPS:");
         try {
             hacerRequest(httpsUrl);
         } catch (IOException e) {
             System.err.println("Error al hacer la solicitud HTTPS: " + e.getMessage());
         }
     }
 
     // Función para hacer una llamada HTTP o HTTPS
     private static void hacerRequest(String urlString) throws IOException {
         URL url = new URL(urlString);
         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
 
         // Verificar si es una conexión HTTPS
         if (connection instanceof HttpsURLConnection) {
             ((HttpsURLConnection) connection).setRequestMethod("GET");
         } else {
             connection.setRequestMethod("GET");
         }
 
         // Lectura de la respuesta
         try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
             String inputLine;
             StringBuilder response = new StringBuilder();
             while ((inputLine = in.readLine()) != null) {
                 response.append(inputLine);
             }
             System.out.println(response.toString());
         }
 
         // Cerrar la conexión
         connection.disconnect();
     }
 }
 