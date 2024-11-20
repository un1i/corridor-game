
package org.corridor_game.corridor_game.client.generated_proxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateGameStatusData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateGameStatusData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="painter_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="line" type="{http://server.corridor_game.corridor_game.org/}paintingLine" minOccurs="0"/&gt;
 *         &lt;element name="cells" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="cur_move" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="finish" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateGameStatusData", propOrder = {
    "painterId",
    "line",
    "cells",
    "curMove",
    "finish"
})
public class UpdateGameStatusData {

    @XmlElement(name = "painter_id")
    protected int painterId;
    protected PaintingLine line;
    @XmlElement(type = Integer.class)
    protected List<Integer> cells;
    @XmlElement(name = "cur_move")
    protected boolean curMove;
    protected boolean finish;

    /**
     * Gets the value of the painterId property.
     * 
     */
    public int getPainterId() {
        return painterId;
    }

    /**
     * Sets the value of the painterId property.
     * 
     */
    public void setPainterId(int value) {
        this.painterId = value;
    }

    /**
     * Gets the value of the line property.
     * 
     * @return
     *     possible object is
     *     {@link PaintingLine }
     *     
     */
    public PaintingLine getLine() {
        return line;
    }

    /**
     * Sets the value of the line property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaintingLine }
     *     
     */
    public void setLine(PaintingLine value) {
        this.line = value;
    }

    /**
     * Gets the value of the cells property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cells property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCells().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getCells() {
        if (cells == null) {
            cells = new ArrayList<Integer>();
        }
        return this.cells;
    }

    /**
     * Gets the value of the curMove property.
     * 
     */
    public boolean isCurMove() {
        return curMove;
    }

    /**
     * Sets the value of the curMove property.
     * 
     */
    public void setCurMove(boolean value) {
        this.curMove = value;
    }

    /**
     * Gets the value of the finish property.
     * 
     */
    public boolean isFinish() {
        return finish;
    }

    /**
     * Sets the value of the finish property.
     * 
     */
    public void setFinish(boolean value) {
        this.finish = value;
    }

}
