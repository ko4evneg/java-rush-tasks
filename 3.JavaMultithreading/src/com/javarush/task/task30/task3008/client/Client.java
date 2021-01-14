package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Error in supplement module");
            System.exit(1);
        }

        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено.\nДля выхода наберите команду 'exit'.");
            while (clientConnected) {
                String msg = ConsoleHelper.readString();
                if (msg.equals("exit")) {
                    clientConnected = false;
                    break;
                } else if (shouldSendTextFromConsole())
                    sendTextMessage(msg);
            }
        } else
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

    }

    //Отвечает за поток, устанавливающий сокетное соединение и читающий сообщения сервера.
    public class SocketThread extends Thread {
        @Override
        public void run() {
            try {
                connection = new Connection(new Socket(getServerAddress(), getServerPort()));
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException ioException) {
                notifyConnectionStatusChanged(false);
            }
        }

        //должен выводить текст message в консоль
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        //должен выводить в консоль информацию о том, что участник с именем userName присоединился к чату
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName);
        }

        //должен выводить в консоль, что участник с именем userName покинул чат
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName);
        }

        //этот метод должен:
        //а) Устанавливать значение поля clientConnected внешнего объекта Client в соответствии с переданным параметром.
        //б) Оповещать (пробуждать ожидающий) основной поток класса Client.
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message msg = connection.receive();
                if (msg.getType() == null)
                    throw new IOException("Unexpected MessageType");
                switch (msg.getType()) {
                    case NAME_REQUEST:
                        connection.send(new Message(MessageType.USER_NAME, getUserName()));
                        break;
                    case NAME_ACCEPTED:
                        notifyConnectionStatusChanged(true);
                        return;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }


        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message msg;
                try {
                    msg = connection.receive();
                } catch (ClassNotFoundException e) {
                    throw new IOException("Unexpected MessageType");
                }
                if (msg.getType() == null)
                    throw new IOException("Unexpected MessageType");
                switch (msg.getType()) {
                    case TEXT:
                        processIncomingMessage(msg.getData());
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(msg.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(msg.getData());
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }
    }

    //должен запросить ввод адреса сервера у пользователя и вернуть введенное значение
    protected String getServerAddress() {
        return ConsoleHelper.readString();
    }

    //должен запрашивать ввод порта сервера и возвращать его
    protected int getServerPort() {
        return ConsoleHelper.readInt();
    }

    //должен запрашивать и возвращать имя пользователя
    protected String getUserName() {
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    //должен создавать и возвращать новый объект класса SocketThread.
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    //создает новое текстовое сообщение, используя переданный текст и отправляет его серверу через соединение connection
    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException ioException) {
            ConsoleHelper.writeMessage("Error when sending message");
            clientConnected = false;
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
