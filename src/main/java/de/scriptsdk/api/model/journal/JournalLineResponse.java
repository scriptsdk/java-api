package de.scriptsdk.api.model.journal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Crome696
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public final class JournalLineResponse {
    private long id = 0L;
    private LocalDateTime time = LocalDateTime.MIN;
    private int messageType = 0;
    private int color = 0;
    private int font = 0;
    private int count = 0;
    private String name = "";
    private int index = 0;
    private int type = 0;
    private int paramId = 0;
}
