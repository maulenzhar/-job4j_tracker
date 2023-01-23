package ru.job4j.collection.queue.interfaceDeque;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        final StringBuilder res = new StringBuilder();
        final int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                res.append(evenElements.poll());
            } else {
                evenElements.poll();
            }
        }
        return res.toString();
    }

    private String getDescendingElements() {
        final StringBuilder res = new StringBuilder();
        final Iterator<Character> descendingIterator = descendingElements.descendingIterator();
        while (descendingIterator.hasNext()) {
            res.append(descendingIterator.next());
        }
        return res.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
