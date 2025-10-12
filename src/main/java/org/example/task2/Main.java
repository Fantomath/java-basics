package org.example.task2;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileProcessor processor = new FileProcessor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите действие: [1] Записать в файл  [2] Прочитать из файла");
        String choice = scanner.nextLine();

        try {
            if (choice.equals("1")) {
                processor.setFileService(new FileWriteService());
            } else if (choice.equals("2")) {
                processor.setFileService(new FileReadService());
            } else {
                System.out.println("❌ Некорректный выбор");
                return;
            }

            System.out.println("Введите путь к файлу:");
            Path path = Path.of(scanner.nextLine());

            processor.execute(path);
        } catch (FileOperationException e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}