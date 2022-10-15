package de.scriptsdk.api.model.buffs;

import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.io.PacketReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public final class BuffIconResponse implements Deserializable {
    private Integer attributeId = 0;
    private LocalDateTime startedAt = LocalDateTime.MIN;
    private Integer remainingSeconds = 0;
    private Long clilocId1 = 0L;
    private Long clilocId2 = 0L;

    @Override
    public void deserialize(PacketReader reader) {
        this.setAttributeId(reader.readInteger());
        this.setStartedAt(reader.readDateTime());
        this.setRemainingSeconds(reader.readInteger());
        this.setClilocId1(reader.readCardinal());
        this.setClilocId2(reader.readCardinal());
    }
}
