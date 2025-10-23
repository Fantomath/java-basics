package org.example.task1;

import java.util.List;

public record Student(String name, List<Book> books) {
    public Student {
        if (books.size() < 5) throw new IllegalArgumentException("Student must have >= 5 books");
    }
    @Override public String toString() {
        return "Student{name='%s', books=%d}".formatted(name, books.size());
    }
}
