package de.scriptsdk.api.model.assets;

import de.scriptsdk.api.enums.Layer;
import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.interfaces.Enumerable;
import de.scriptsdk.core.model.io.PacketReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Crome696
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public final class LayerInfoResponse implements Deserializable {
    private Layer layer = Layer.INVALID;
    private Long id = 0L;

    @Override
    public void deserialize(PacketReader reader) {

        this.setLayer(Enumerable.valueOf(reader.readSmallInteger(), Layer.class));
        this.setId(reader.readCardinal());
    }
}

