package ru.job4j.stream.card;

import java.util.stream.Stream;

public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    public static void main(String[] args) {
        Suit[] s = Suit.values();
        Value[] v = Value.values();
        Stream.of(s)
                .flatMap(suit -> Stream.of(v)
                        .map(value -> new Card(suit, value)))
                .forEach(System.out::println);
    }
}