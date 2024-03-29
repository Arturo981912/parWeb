/*
    Autor: Arturo Duarte
    Date: 02-2024
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test01 {
    public static void main(String[] args) {
        String url = "https://www.datos.gov.py/dataset/proyectos-adjudicados-hackathon";
        try {
            String respuesta = peticionHttpGet(url);
            System.out.println("La respuesta es:\n" + respuesta);
        } catch (Exception e) {
            System.err.println("Error al realizar la solicitud HTTP: " + e.getMessage());
        }
    }

    public static String peticionHttpGet(String urlParaVisitar) throws IOException { // Corregir tipo de excepción
        StringBuilder resultado = new StringBuilder();
        URL url = new URL(urlParaVisitar);

        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        // Verificar el código de respuesta
        int codigoRespuesta = conexion.getResponseCode();
        if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
            try (BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()))) {
                String linea;
                while ((linea = rd.readLine()) != null) {
                    resultado.append(linea);
                }
            }
        } else {
            throw new IOException("La solicitud HTTP no fue exitosa. Código de respuesta: " + codigoRespuesta);
        }

        return resultado.toString();
    }
}
