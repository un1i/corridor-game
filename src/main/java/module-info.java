module org.corridor_game.corridor_game {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.xml.ws;
    requires java.jws;
    requires com.sun.xml.ws;
    requires org.eclipse.persistence.core;
    requires org.eclipse.persistence.moxy;
    requires java.sql;

    opens org.corridor_game.corridor_game.client;
    opens org.corridor_game.corridor_game.server.data;
    opens org.corridor_game.corridor_game.server;
    opens org.corridor_game.corridor_game.client.generated_proxy;
}