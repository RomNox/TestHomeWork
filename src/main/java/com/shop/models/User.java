package com.shop.models;

public class User {
    private String email;
    private String password;

    // Конструктор с параметрами
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Пустой конструктор
    public User() {
    }

    // Получение email
    public String getEmail() {
        return email;
    }

    // Установка email
    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    // Получение пароля
    public String getPassword() {
        return password;
    }

    // Установка пароля
    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
