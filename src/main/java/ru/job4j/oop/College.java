package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Student student = (Student) new Freshman();
        Object obj = (Object) student;
    }
}
