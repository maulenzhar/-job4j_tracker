package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book headFirstSql = new Book("Head First Sql", 500);
        Book headFirstJava = new Book("Head First Java", 620);
        Book headFirstHibernate = new Book("Head First Hibernate", 800);
        Book cleanCode = new Book("Clean code", 951);

        Book[] books = new Book[4];
        books[0] = headFirstSql;
        books[1] = headFirstJava;
        books[2] = headFirstHibernate;
        books[3] = cleanCode;

        for (int index = 0; index < books.length; index++) {
            Book b = books[index];
            System.out.println(b.getName() + " - " + b.getPageCount());
        }
        System.out.println("*********************");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book b = books[index];
            System.out.println(b.getName() + " - " + b.getPageCount());
        }
        System.out.println("*********************");
        for (int index = 0; index < books.length; index++) {
            Book b = books[index];
            if ("Clean code".equals(b.getName())) {
                System.out.println(b.getName() + " - " + b.getPageCount());
            }
        }
    }
}
