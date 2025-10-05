package org.example.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        var set = new MyHashSet<String>();
        set.add("A"); set.add("B"); set.remove("A");

        var list = new MyLinkedList<Integer>();
        list.add(1); list.add(2); list.addAll(List.of(3,4,5));
        list.remove(1);

        List<Student> students = new ArrayList<>(List.of(
                new Student("Alice", List.of(
                        new Book("Java 8", 450, 2016),
                        new Book("Algorithms", 900, 2006),
                        new Book("Clean Code", 430, 2008),
                        new Book("Effective Java", 420, 2018),
                        new Book("Patterns", 395, 1994)
                )),
                new Student("Bob", List.of(
                        new Book("Refactoring", 460, 2019),
                        new Book("DDD", 520, 2004),
                        new Book("Kotlin In Action", 360, 2017),
                        new Book("Streams", 300, 2021),
                        new Book("Patterns", 395, 1994)
                )),
                new Student("Carol", List.of(
                        new Book("Concurrency", 650, 2015),
                        new Book("Spring in Action", 520, 2020),
                        new Book("Kafka Guide", 340, 2022),
                        new Book("Data Pipelines", 410, 2023),
                        new Book("Tuning JVM", 370, 2012)
                ))
        ));

        students.stream()
                .peek(System.out::println)
                .map(Student::books)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Book::pages))
                .distinct()
                .filter(b -> b.year() > 2000)
                .limit(3)
                .findFirst()
                .map(Book::year)
                .ifPresentOrElse(
                        y -> System.out.println("Год найденной книги: " + y),
                        () -> System.out.println("Подходящая книга не найдена")
                );
    }
}
