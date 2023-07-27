package org.example;

public class Buyer {
    private String surName, firstName, patronymic, phone;
    private int age;

    public Buyer(String surName, String firstName, String patronymic, String phone, int age) {
        this.surName = surName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.age = age;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
