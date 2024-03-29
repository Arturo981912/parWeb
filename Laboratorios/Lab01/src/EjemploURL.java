/*
    Autor: Arturo Duarte
    Date: 02-2024
    Referencia: https://docs.oracle.com/javase/10/docs/api/java/net/URL.html
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class EjemploURL {
    public static void main(String[] args) {
        // Definimos dos URLs de ejemplo
        String testUrl = "http://www.pol.una.py";
        String testHost = "grado.pol.una.py";
        int testPort = 80;
        String testFile = "index.html";

        try {
            URL pagina1 = new URL(testUrl);
            URL pagina2 = new URL("http", testHost, testPort, testFile);

            // Primer prueba: información de la primera URL
            System.out.println("***** Primera pagina");
            System.out.println("Protocolo: " + pagina1.getProtocol());
            System.out.println("Puerto: " + pagina1.getPort());
            System.out.println("Host: " + pagina1.getHost());
            System.out.println("Archivo: " + pagina1.getFile());
            System.out.println("External form: " + pagina1.toExternalForm());

            // Segunda prueba: información de la segunda URL
            System.out.println("***** Segunda pagina");
            System.out.println("Protocolo: " + pagina2.getProtocol());
            System.out.println("Puerto: " + pagina2.getPort());
            System.out.println("Host: " + pagina2.getHost());
            System.out.println("Archivo: " + pagina2.getFile());
            System.out.println("External form: " + pagina2.toExternalForm());

        } catch (MalformedURLException e) {
            System.out.println("Error: La URL proporcionada es inválida.");
            e.printStackTrace();
        }
    } //fin main

} //fin EjemploURL
