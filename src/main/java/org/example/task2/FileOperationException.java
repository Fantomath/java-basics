package org.example.task2;

import java.io.IOException;

public class FileOperationException extends IOException {
    public FileOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
