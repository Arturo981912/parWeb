/*
    Autor: Arturo Duarte
    Date: 02-2024
    Notas:
    -En este ejemplo el servidor UDP escucha en el puerto 9877 y recibe los mensajes de los clientes,
    -luego convierte los mensajes a mayúsculas y los envía de vuelta al cliente.
    -El cliente envía un mensaje al servidor, espera la respuesta del servidor y la imprime en la consola.
    -Para ejecutar este código, primero ejecuta el servidor y luego el cliente.
    -Revisar que el puerto 9877 esté disponible y que no esté bloqueado o este en uso por otro programa.
 */

 import java.io.IOException;
 import java.net.*;
 
 public class UDPServer {
     public static void main(String[] args) {
         final int SERVER_PORT = 9877;
 
         try (DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT)) {
             System.out.println("Servidor UDP escuchando en el puerto " + SERVER_PORT + "...");
 
             byte[] receiveData = new byte[1024];
             byte[] sendData;
 
             while (true) {
                 DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                 serverSocket.receive(receivePacket);
 
                 InetAddress clientAddress = receivePacket.getAddress();
                 int clientPort = receivePacket.getPort();
 
                 String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                 System.out.println("Mensaje recibido del cliente: " + message);
 
                 String response = "Respuesta del servidor: " + message.toUpperCase();
                 sendData = response.getBytes();
 
                 DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                 serverSocket.send(sendPacket);
             }
         } catch (IOException e) {
             System.err.println("Error en el servidor UDP: " + e.getMessage());
         }
     }
 }
 