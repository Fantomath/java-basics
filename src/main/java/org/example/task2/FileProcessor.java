package org.example.task2;

import java.nio.file.Path;

public class FileProcessor {
    private FileService fileService;

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public void execute(Path path) throws FileOperationException {
        if (fileService == null) {
            throw new IllegalStateException("Не установлена стратегия обработки файла");
        }
        fileService.process(path);
    }
}
