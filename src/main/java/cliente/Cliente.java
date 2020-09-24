package main.java.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main (String [] args){

        /* Host: a quien me voy a conectar, 127.0.0.1 localhost (nuestra maquina) */
        final String HOST = "127.0.0.1";

        /* El puerto debe ser el mismo para el cliente y el servidor */
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            /* Crear el socket con el host y el puerto al cual conectarse */
            Socket sc = new Socket(HOST, PUERTO);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            /* El cliente envia un mensaje al servidor */
            out.writeUTF("Hola mundo, desde el cliente");

            /* Guardamos respuesta del servidor y lo mostramos en pantalla */
            String mensaje = in.readUTF();
            System.out.println(mensaje);

            /* Cerramos la conexion */
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
