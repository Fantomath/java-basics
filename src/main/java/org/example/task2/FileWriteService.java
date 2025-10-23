package org.example.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileWriteService implements FileService {
    @Override
    public void process(Path path) throws FileOperationException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите текст для записи в файл:");
            String content = scanner.nextLine();
            Files.writeString(path, content);
            System.out.println("Запись успешно выполнена!");
        } catch (IOException e) {
            throw new FileOperationException("Ошибка при записи файла: " + path, e);
        }
    }
}
