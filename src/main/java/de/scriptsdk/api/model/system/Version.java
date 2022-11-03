package de.scriptsdk.api.model.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Crome696
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Version {
    protected int major = 0;
    protected int minor = 0;
    protected int revision = 0;
    protected int build = 0;
}
