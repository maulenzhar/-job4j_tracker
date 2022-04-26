package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers(int qtyPassengers);

    int refuel(int qtyfuel);
}
