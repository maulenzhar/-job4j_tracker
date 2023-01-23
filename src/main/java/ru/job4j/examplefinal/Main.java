package ru.job4j.examplefinal;

public class Main {
    /* изменить внутреннее состояние объекта мы сможем,
    *  однако ссылку на объект с ключевым словом final нам поменять не получится
    *  FIRST_USER = new User("Stas", 22)*/
    public static void main(String[] args) {
        final User FIRST_USER = new User("Petr", 32);
        System.out.println("Вывод в консоль до изменения.");
        System.out.println(FIRST_USER);

        FIRST_USER.setName("Petr Arsentev");
        FIRST_USER.setAge(33);
        System.out.println("Вывод в консоль после изменения.");
        System.out.println(FIRST_USER);
    }
}
