package main.java.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main (String [] args){

        ServerSocket servidor;
        Socket sc;

        /* Para recibir y enviar stream entre el servidor y el cliente */
        DataInputStream in;
        DataOutputStream out;


        /* No es necesario que el puerto sea una constante */
        final int PUERTO = 5000;

        try {
            /* Creamos el servidor */
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");

            /* El servidor siempre queda a la espera de una conexion */
            while (true) {
                /* sc es el socket del cliente, se conecta */
                sc = servidor.accept();
                System.out.println("Cliente conectado");

                /* El inputStream para recibir mensajes del cliente para el servidor
                y outputStream para enviar mensajes del servidor para el cliente */

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                /* Imprimir el mensaje recibido del cliente */
                String mensaje = in.readUTF();
                System.out.println(mensaje);

                /* Respuesta del servidor*/
                out.writeUTF("Hola mundo, desde el servidor.");

                /* Cerrando el cliente */
                sc.close();
                System.out.println("Cliente desconecta");

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
