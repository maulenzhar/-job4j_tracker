package ru.job4j.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String res = "";
        for (int i = 0; i < count; i++) {
            Customer customer = queue.poll();
            if (i == count - 1) {
                res += customer.name();
            }
        }
        return res;
    }

    public String getLastUpsetCustomer() {
        String res = "";
        for (int i = 0; i <= count + 1; i++) {
            Customer customer = queue.poll();
            if (i == count) {
                res += customer.name();
            }
        }
        return res;
    }
}
