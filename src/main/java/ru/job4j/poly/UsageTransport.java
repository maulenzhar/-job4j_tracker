package ru.job4j.poly;

public class UsageTransport {
    public static void main(String[] args) {
        Vehicle autobus = new Autobus();
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();

        Vehicle[] vehicles = new Vehicle[]{autobus, airplane, train};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
