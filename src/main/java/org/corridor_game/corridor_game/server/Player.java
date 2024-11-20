package org.corridor_game.corridor_game.server;

import org.corridor_game.corridor_game.server.data.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Player {
    private final int id;
    private boolean is_ready;
    Queue<UpdateGameStatusData> messages;

    Player(int id_) {
        messages = new LinkedList<>();
        id = id_;
        is_ready = false;
    }

    public void setReady(boolean value) {
        is_ready = value;
    }

    public boolean isReady() {
        return is_ready;
    }

    public StartGameData getStartGameData(int cur_move_id, int num_players) {
        return new StartGameData(id == cur_move_id, num_players);
    }

    public void updateGameStatus(int painter_id, PaintingLine line, ArrayList<Integer> cells,
                                 int cur_move_id, boolean is_finish) {
        messages.add(new UpdateGameStatusData(painter_id, line, cells, cur_move_id == id, is_finish));
    }

    public ArrayList<UpdateGameStatusData> sendGameData() {
        ArrayList<UpdateGameStatusData> res = new ArrayList<>();
        while (!messages.isEmpty()) {
            res.add(messages.poll());
        }
        return res;
    }

    public FinishGameData getFinishGameData(ArrayList<Integer> score) {
        boolean is_winner = true;
        for (Integer s : score) {
            if (s > score.get(id)) {
                is_winner = false;
                break;
            }
        }
        return new FinishGameData(score, is_winner);
    }
}
