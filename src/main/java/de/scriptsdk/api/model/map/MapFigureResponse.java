package de.scriptsdk.api.model.map;

import de.scriptsdk.api.enums.BrushStyle;
import de.scriptsdk.api.enums.Facet;
import de.scriptsdk.api.enums.FigureCoordination;
import de.scriptsdk.api.enums.FigureKind;
import de.scriptsdk.core.interfaces.Serializable;
import de.scriptsdk.core.model.io.PacketWriter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Crome696
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public final class MapFigureResponse implements Serializable {
    private FigureKind figureKind = FigureKind.LINE;
    private FigureCoordination figureCoordination = FigureCoordination.WORLD;
    private int x1 = 0;
    private int y1 = 0;
    private int x2 = 0;
    private int y2 = 0;
    private long brushColor = 0L;
    private BrushStyle brushStyle = BrushStyle.SOLID;
    private long color = 0L;
    private Facet facet = Facet.FELUCCA;
    private String text = "";

    @Override
    public void serialize(PacketWriter writer) {
        writer.writeSmallInteger(this.getFigureKind().getId());
        writer.writeSmallInteger(this.getFigureCoordination().getId());
        writer.writeInteger(this.getX1());
        writer.writeInteger(this.getY1());
        writer.writeInteger(this.getX2());
        writer.writeInteger(this.getY2());
        writer.writeCardinal(this.getBrushColor());
        writer.writeSmallInteger(this.getBrushStyle().getId());
        writer.writeCardinal(this.getColor());
        writer.writeSmallInteger(this.getFacet().getId());
        writer.writeString(this.getText());
    }
}