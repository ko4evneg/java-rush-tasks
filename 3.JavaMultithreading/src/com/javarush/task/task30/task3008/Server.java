package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry entry : connectionMap.entrySet()) {
            Connection c = (Connection) entry.getValue();
            try {
                c.send(message);
            } catch (IOException ioException) {
                ConsoleHelper.writeMessage("Error while sending message");
            }
        }

    }

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Server has run");
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("IO error in serverSocket");
        }
    }
}
