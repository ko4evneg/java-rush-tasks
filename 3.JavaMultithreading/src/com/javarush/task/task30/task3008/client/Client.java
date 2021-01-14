package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client implements Runnable {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    @Override
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
