package org.corridor_game.corridor_game.server.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement(name = "UpdateGameStatusMsg")
public class UpdateGameStatusData implements Serializable {
    @XmlElement
    int painter_id;
    @XmlElement
    PaintingLine line;
    @XmlElement
    ArrayList<Integer> cells;
    @XmlElement
    boolean cur_move;
    @XmlElement
    boolean finish;

    public UpdateGameStatusData() {}

    public UpdateGameStatusData(int painter_id_, PaintingLine line_, ArrayList<Integer> cells_,
                                boolean is_cur_move_, boolean is_finish_) {
        painter_id = painter_id_;
        line = line_;
        cells = cells_;
        cur_move = is_cur_move_;
        finish = is_finish_;
    }

    public PaintingLine getLine() {
        return line;
    }

    public ArrayList<Integer> getCells() {
        return cells;
    }

    public boolean isCurMove() {
        return cur_move;
    }

    public int getPainterId() {
        return painter_id;
    }
}
