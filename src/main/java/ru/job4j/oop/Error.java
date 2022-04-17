package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Ошибка: " + active);
        System.out.println("Код ошибки: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error serverError = new Error(true, 500, "Server error");
        serverError.printInfo();
        Error pageError = new Error(true, 404, "Not fount");
        pageError.printInfo();
        Error allowError = new Error(true, 403, "Forbidden ");
        allowError.printInfo();
    }
}
