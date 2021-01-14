package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            SocketAddress remoteAddr = socket.getRemoteSocketAddress();
            ConsoleHelper.writeMessage("Connected to " + remoteAddr);
            String remoteName = "";
            try (Connection connection = new Connection(socket)) {
                remoteName = serverHandshake(connection);
                notifyUsers(connection, remoteName);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, remoteName));
                serverMainLoop(connection, remoteName);
                ConsoleHelper.writeMessage("Closed connection");

            } catch (IOException | ClassNotFoundException ioException) {
                ConsoleHelper.writeMessage("Error while establishing connection");
            } finally {
                if (!remoteName.isEmpty()) {
                    connectionMap.remove(remoteName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, remoteName));
                }
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();
                if (answer.getType() == MessageType.USER_NAME && !answer.getData().isEmpty() && !connectionMap.containsKey(answer.getData())) {
                    connectionMap.put(answer.getData(), connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return answer.getData();
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                String uName = entry.getKey();
                if (!uName.equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, uName));
            }

        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message msg = connection.receive();
                if (msg.getType() == MessageType.TEXT) {
                    Message newMsg = new Message(MessageType.TEXT, String.format("%s: %s", userName, msg.getData()));
                    sendBroadcastMessage(newMsg);
                } else
                    ConsoleHelper.writeMessage("Error during message broadcasting");
            }
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
