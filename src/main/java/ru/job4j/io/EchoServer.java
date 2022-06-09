package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socked = server.accept();
                try (OutputStream out = socked.getOutputStream();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socked.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String str = in.readLine();
                   if (str.contains("?msg=Bye")) {
                       server.close();
                       System.out.println("Работа сервера завершена!");
                       break;
                   }
                        System.out.println(str);
                   for (str = in.readLine();
                        str != null && !str.isEmpty();
                        str = in.readLine()) {
                       System.out.println(str);
                    }
                    out.flush();
                }
            }
        }
    }
}
