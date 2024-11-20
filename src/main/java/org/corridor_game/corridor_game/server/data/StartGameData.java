package org.corridor_game.corridor_game.server.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "StartGameMsg")
public class StartGameData implements Serializable {
    @XmlElement
    boolean cur_move;
    @XmlElement
    int num_players;

    public StartGameData() {}

    public StartGameData(boolean is_cur_move_, int num_players_) {
        cur_move = is_cur_move_;
        num_players = num_players_;
    }

    public boolean isCurMove() {
        return cur_move;
    }

    public int getNumPlayers() {
        return num_players;
    }
}
