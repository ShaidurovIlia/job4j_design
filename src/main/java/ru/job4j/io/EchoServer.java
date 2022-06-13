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
                   if (str.contains("?msg=Exit")) {
                       server.close();
                       out.write("Завершить работу сервера.".getBytes());
                       break;
                   } else if (str.contains("?msg=Hello")) {
                           out.write("Hallo.".getBytes());
                       } else {
                       out.write("What?".getBytes());
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
