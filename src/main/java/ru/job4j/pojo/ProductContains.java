package ru.job4j.pojo;

public class ProductContains {
    public static void main(String[] args) {
        Product first = new Product("Milk", 100);
        Product second = new Product("Milk", 100);
        boolean eq1 = first == second;
        boolean eq2 = first.equals(second);
        System.out.println(eq1);
        System.out.println(eq2);
    }
}
