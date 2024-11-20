
package org.corridor_game.corridor_game.client.generated_proxy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lineType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="lineType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="VERTICAL"/&gt;
 *     &lt;enumeration value="HORIZONTAL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "lineType")
@XmlEnum
public enum LineType {

    VERTICAL,
    HORIZONTAL;

    public String value() {
        return name();
    }

    public static LineType fromValue(String v) {
        return valueOf(v);
    }

}
