package org.corridor_game.corridor_game.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.corridor_game.corridor_game.client.generated_proxy.ServerManager;
import org.corridor_game.corridor_game.client.generated_proxy.ServerManagerService;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-window-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setTitle("Коридорчики");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ServerManager service = new ServerManagerService().getServerManagerPort();
        ClientManager manager = BClientManager.getManager();
        manager.setService(service);

        if (!manager.connectToGame()) {
            System.out.println("The places in the game are filled!");
            Platform.exit();
            return;
        }
        launch();
    }
}
