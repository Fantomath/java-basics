package org.example.task1;

import java.util.Objects;

public record Book(String title, int pages, int year) {
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book b)) return false;
        return pages == b.pages && year == b.year && title.equals(b.title);
    }
    @Override public int hashCode() { return Objects.hash(title, pages, year); }
}
