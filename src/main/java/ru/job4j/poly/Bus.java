package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("transport rides");
    }

    @Override
    public void passengers(int qtyPassengers) {
        System.out.println("qty of passengers " + qtyPassengers);
    }

    @Override
    public int refuel(int qtyfuel) {
        int price = 88;
        return qtyfuel * price;
    }
}
