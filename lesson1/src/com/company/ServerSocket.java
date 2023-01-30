package com.company;

import java.io.*;
import java.net.Socket;

    public class ServerSocket {
        private static Socket clientSocket;
        private static java.net.ServerSocket server;
        private static BufferedReader in;
        private static BufferedWriter out;

        public static void main(String[] args) {
            try {
                try {
                    server = new java.net.ServerSocket(4006);
                    System.out.println("Сервер запущен!");
                    clientSocket = server.accept();
                    try {
                        boolean isConnected = true;
                        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                        out.write("Привет, это сервер! давай поругаемся, если тебе надоест, то скажи-\n");
                        out.flush();
                        while (isConnected) {
                            String clientWord = in.readLine();
                            if (clientWord.equals("-")) {
                                out.write("так и знал что ты здашься \n");
                                out.flush();
                                isConnected = false;
                            } else {
                                out.write(Calculator.calc(clientWord) + "\n");
                                out.flush();
                            }
                            out.flush();
                        }
                        } finally{
                            clientSocket.close();
                            in.close();
                            out.close();
                        }

                    } finally {
                        System.out.println("Сервер закрыт!");
                        server.close();
                    }
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }







