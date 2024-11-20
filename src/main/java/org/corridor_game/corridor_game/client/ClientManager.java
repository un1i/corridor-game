package org.corridor_game.corridor_game.client;

import org.corridor_game.corridor_game.client.generated_proxy.*;
import org.corridor_game.corridor_game.client.VisualController;

import java.util.List;

public class ClientManager {
    VisualController controller;
    ServerManager service;

    int id;

    public void setController(VisualController controller) {
        this.controller = controller;
    }

    public void setService(ServerManager service) {
        this.service = service;
    }

    public boolean connectToGame() {
        id = service.addNewPlayer();
        if (id >= 0) {
            Thread thread = new Thread(this::receiveUpdates);
            thread.setDaemon(true);
            thread.start();
            return true;
        }
        return false;
    }

    public void sendReady() {
        service.setReady(id);
    }

    public void sendLine(int lineId, LineType lineType) {
        PaintingLine line = new PaintingLine();
        line.setIndex(lineId);
        line.setType(lineType);
        service.paintLine(id, line);
    }

    public void receiveUpdates() {
        try {
            while (true) {
                while (!service.isGameStarted()) {
                    Thread.sleep(100);
                }
                StartGameData start_data = service.getStartGameData(id);
                controller.startGame(start_data);
                boolean is_finish = false;
                while (!is_finish) {
                    List<UpdateGameStatusData> changes = service.updateGameData(id);
                    for (UpdateGameStatusData change : changes) {
                        controller.UpdateGameStatus(change);
                        is_finish = change.isFinish();
                    }
                    Thread.sleep(100);
                }
                FinishGameData finish_data = service.getFinishGameData(id);
                controller.finishGame(finish_data);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Interrupt receive thread!");
        }
    }
}
