package org.corridor_game.corridor_game.server;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        ServerManager manager = new ServerManager();
        String url = String.format("http://localhost:%d/GameServer", ServerManager.port);
        Endpoint.publish(url, manager);
    }
}
