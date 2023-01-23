package ru.job4j.collection.queue.interfaceDeque;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeRunner {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.add("second");
        deque.addFirst("first");
        deque.addLast("third");
        for (String string : deque) {
            System.out.println(string);
        }

        /**
         * Удаление:
         * poll() и remove() мы уже разбирали у очереди
         * pop() – позволяет удалить головной удалить из очереди и вернуть его. Если очередь пуста – будет сгенерировано исключение NoSuchElementException
         * removeFirst() и pollFirst() – методы также позволят удалить первый элемент из очереди с его возвратом. Первый сгенерирует исключение при пустой очереди, второй – вернет null.
         * removeLast() и pollLast() – методы позволят удалить последний элемент из очереди с его возвратом. Первый сгенерирует исключение при пустой очереди, второй – вернет null.
         * предпочтительнее использовать методы poll(), pollFirst() и pollLast(),
         * */
        System.out.println("удаление ====>>>");
        System.out.println(deque);
        System.out.println(deque.pop());
        System.out.println(deque);
        System.out.println(deque.poll());
        System.out.println(deque);
        System.out.println(deque.pollFirst());
        System.out.println(deque);
        System.out.println(deque.pollLast());

        /**
         * Чтение элементов:
         * element() и peek()
         * peekFirst() и peekLast()
         * Предпочитайте использовать методы poll(), pollFirst(), pollLast, peekFirst(), peekLast(), peek().
         * */
        System.out.println("чтение ====>>>");
        deque.add("second");
        deque.addFirst("first");
        deque.addLast("third");
        Iterator<String> iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Iterator<String> descendingiterator = deque.descendingIterator();
        while (descendingiterator.hasNext()) {
            System.out.println(descendingiterator.next());
        }
    }
}
