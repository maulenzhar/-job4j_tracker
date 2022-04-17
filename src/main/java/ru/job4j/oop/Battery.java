package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        this.load = this.load + another.load;
        another.load = this.load;
        this.load = 0;
    }

    public int getLoad() {
        return load;
    }

    public static void main(String[] args) {
        Battery charger = new Battery(95);
        Battery another = new Battery(0);
        charger.exchange(another);
        System.out.println(another.getLoad());
    }
}
