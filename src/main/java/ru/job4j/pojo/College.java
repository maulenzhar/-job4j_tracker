package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student  student = new Student ();
        student.setFullName("John Doe");
        student.setGroup("G1");
        student.setReceiptDate(new Date());

        System.out.println(student.getFullName() + " " + student.getGroup() + " : " + student.getReceiptDate());
    }
}
