package org.example.task3.builder;

public class User {
    private String name;
    private String email;
    private int age;

    // приватный конструктор, чтобы объект создавался только через билдер
    protected User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', age=" + age + "}";
    }
}
