package org.example.task2;

import java.nio.file.Path;

public interface FileService {
    void process(Path path) throws FileOperationException;
}
