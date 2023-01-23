package ru.job4j.collection.queue.interfaceQueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueRunner {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("first");
        queue.add("second");
        queue.add("third");

        for (String string : queue) {
            System.out.println(string);
        }

        /**
         * remove() и poll() – оба метода позволяют удалить верхний элемент из очереди.
         * poll() – то вывод в консоль не изменится.
         * метод poll() - просто возвращает null, когда наша очередь пустая.
         * метод remove() - просто возвращает Искл-е, когда наша очередь пустая.
         * */
        System.out.println("remove ====>>>");
        queue.remove();
        System.out.println();
        System.out.println("State of Queue after remove: ");
        for (String string : queue) {
            System.out.println(string);
        }

        Queue<String> queueEmpty = new LinkedList<>();
        String temp = queueEmpty.poll();
        System.out.println(temp);

        /**
         *  offer() – выполняет попытку вставки элемента в конец очереди.
         *  Почему только попытку – связано это с тем, что если в качестве реализации будет использована та,
         *  которая может иметь ограниченный размер, то при переполнении очереди метод offer() добавить элемент не сможет.
         * */
        System.out.println("offer ====>>>");
        queue.offer("first");
        queue.offer("second");
        queue.offer("third");

        for (String string : queue) {
            System.out.println(string);
        }

        /**
         * peek() и element() – методы вернут первый элемент из очереди, без удаления этого элемента из очереди.
         * если метод element() вызывать на пустой очереди, то будет сгенерировано исключение NoSuchElementException.
         * */
        System.out.println("peek ====>>>");

        System.out.println(queue.peek());
    }
}
