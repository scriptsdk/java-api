package de.scriptsdk.api.model.system;

import de.scriptsdk.api.exceptions.dto.DtoException;
import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.io.PacketReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public final class StealthInfoResponse implements Deserializable {
    private Version version = new Version();
    private Integer buildVersion = 0;
    private LocalDateTime buildDate = LocalDateTime.MIN;
    private Integer gitRevisionNumber = 0;
    private String gitRevision = "";

    @Override
    public void deserialize(PacketReader reader) {
        int size = reader.readInteger();

        if (Objects.equals(size, 3)) {
            this.setVersion(new Version(reader.readWord(), reader.readWord(), reader.readWord(), reader.readWord()));
        } else {
            throw new DtoException("Error on deserializing Stealth-Version 6 bytes " +
                    "expected actual %d bytes", size * 2);
        }
        this.setBuildDate(reader.readDateTime());
        this.setGitRevisionNumber(reader.readWord());
        this.setGitRevision(reader.readString());
    }
}
