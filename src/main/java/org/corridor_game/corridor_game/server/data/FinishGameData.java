package org.corridor_game.corridor_game.server.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement(name = "FinishGameData")
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishGameData implements Serializable {
    @XmlElement
    ArrayList<Integer> score;
    @XmlElement
    boolean winner;

    public FinishGameData() {}

    public FinishGameData(ArrayList<Integer> score_, boolean is_winner) {
        score = score_;
        winner = is_winner;
    }

    public ArrayList<Integer> getScore() {
        return score;
    }

    public boolean isWinner() {
        return winner;
    }
}
