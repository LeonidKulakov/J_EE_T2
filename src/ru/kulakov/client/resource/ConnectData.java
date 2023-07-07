package ru.kulakov.client.resource;

public final class ConnectData {
    private static int port = 1881;
    private static final String IP = "127.0.0.1";
    private ConnectData() {
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int ports) {
        port = ports;
    }

    public static String getIP() {
        return IP;
    }
}
