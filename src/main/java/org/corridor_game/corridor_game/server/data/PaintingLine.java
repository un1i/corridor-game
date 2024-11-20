package org.corridor_game.corridor_game.server.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "PaintingLine")
public class PaintingLine implements Serializable {
    @XmlElement
    public LineType type;
    @XmlElement
    public int index;
    public PaintingLine() {}

    public PaintingLine(int index, LineType type) {
        this.index = index;
        this.type = type;
    }
}
