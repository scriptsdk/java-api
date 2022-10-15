package de.scriptsdk.api.model.assets;

import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.io.PacketReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public final class StaticTileResponse implements Deserializable {
    private BigInteger flags = BigInteger.valueOf(0L);
    private Integer weight = 0;
    private Integer animationId = 0;
    private Integer height = 0;
    private Long radarColorRGBA = 0L;
    private String name = "";

    @Override
    public void deserialize(PacketReader reader) {
        this.setFlags(reader.readBigInteger());
        this.setWeight(reader.readInteger());
        this.setAnimationId(reader.readInteger());
        this.setHeight(reader.readInteger());
        this.setRadarColorRGBA(reader.readCardinal());
        this.setName(reader.readString());
    }
}
