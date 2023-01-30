package com.company;



import java.io.*;
import java.net.Socket;

public class ClientSocket {
    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            try {

                clientSocket = new Socket("localhost", 4006);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                System.out.println("Приветствую в эмуляции стрелочника!");
                String serverWord = in.readLine();
                System.out.println(serverWord);
                boolean isConnected = true;

                while (isConnected) {
                    String clientWord = reader.readLine();
                    out.write(clientWord + "\n");
                    out.flush();
                    if (!clientWord.equals("-")) {
                        String res = in.readLine();
                        System.out.println(res);

                    } else {
                        System.out.println(in.readLine());
                        isConnected = false;
                    }
                }
            } finally {
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

