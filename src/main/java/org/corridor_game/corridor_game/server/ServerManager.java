package org.corridor_game.corridor_game.server;

import org.corridor_game.corridor_game.server.data.FinishGameData;
import org.corridor_game.corridor_game.server.data.PaintingLine;
import org.corridor_game.corridor_game.server.data.StartGameData;
import org.corridor_game.corridor_game.server.data.UpdateGameStatusData;

import java.util.ArrayList;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public class ServerManager {
    public static final int port = 5555;
    Game game;
    boolean is_game_started;
    ArrayList<Player> players;

    ServerManager() {
        players = new ArrayList<>();
        game = new Game(this);
        is_game_started = false;
    }

    public int addNewPlayer() {
        if (players.size() < 2) {
            int id = game.addNewPlayer();
            players.add(new Player(id));
            return id;
        }
        return -1;
    }


    public void setReady(int id) {
        players.get(id).setReady(true);
        tryStartGame();
    }

    public boolean isGameStarted() {
        return is_game_started;
    }

    public StartGameData getStartGameData(int id) {
        return players.get(id).getStartGameData(game.getCurMoveId(), players.size());
    }

    public void paintLine(int id, PaintingLine line) {
        int painter_id = game.getCurMoveId();
        PaintLineResult result = game.paintLine(id, line);
        boolean is_finish = result.type == PaintLineResultType.FINISH;
        if (is_finish || result.type == PaintLineResultType.NEW_COLORED_CELLS) {
            updateGameStatusForPlayers(painter_id, line, result.colored_cells, is_finish);
        }
        if (is_finish) {
            finishGame();
        }
    }

    public ArrayList<UpdateGameStatusData> updateGameData(int id) {
        return players.get(id).sendGameData();
    }

    public FinishGameData getFinishGameData(int id) {
        return players.get(id).getFinishGameData(game.getPlayerScore());
    }

    @WebMethod(exclude = true)
    void finishGame() {
        for (Player player : players) {
            player.setReady(false);
        }
        is_game_started = false;
    }

    @WebMethod(exclude = true)
    void tryStartGame() {
        for (Player player : players) {
            if (!player.isReady()) {
                return;
            }
        }
        game.reset();
        is_game_started = true;
    }

    @WebMethod(exclude = true)
    void updateGameStatusForPlayers(int painter_id, PaintingLine line, ArrayList<Integer> cells, boolean is_finish) {
        int cur_move_id = game.getCurMoveId();
        for (Player player : players) {
            player.updateGameStatus(painter_id, line, cells, cur_move_id, is_finish);
        }
    }
}
