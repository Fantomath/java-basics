package org.example.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReadService implements FileService {
    @Override
    public void process(Path path) throws FileOperationException {
        try {
            System.out.println("Содержимое файла:");
            Files.lines(path).forEach(System.out::println);
        } catch (IOException e) {
            throw new FileOperationException("Ошибка при чтении файла: " + path, e);
        }
    }
}
