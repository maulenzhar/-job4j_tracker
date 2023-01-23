package ru.job4j.collection.queue.interfaceQueue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer customer  = null;
        for (int i = 0; i < count; i++) {
            customer = queue.poll();
        }
        return customer.name();
    }

    public String getLastUpsetCustomer() {
        Customer customer  = null;
        for (int i = 0; i < count + 1; i++) {
            customer = queue.poll();
        }
        return customer.name();
    }
}
