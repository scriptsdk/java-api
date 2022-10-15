package de.scriptsdk.api.model.process;


import de.scriptsdk.core.model.generic.BaseList;

import java.nio.file.Path;

public final class ProcessHelper {
    public BaseList<ProcessHandle> getProcessList(String name) {
        return new BaseList<>(ProcessHandle.allProcesses().toList().
                stream().filter(handle ->
                        name.equalsIgnoreCase(Path.of(handle.info().command().orElse("")).
                                getFileName().toString())).toList());
    }
}
