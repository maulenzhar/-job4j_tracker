package ru.job4j.collection.function;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        /*Основное применение этого интерфейса – создание новых объектов.*/
        Supplier<String> sup = () -> "New String For Interface";
        Supplier<Integer> sss = () -> 0;
        System.out.println(sup.get());
        System.out.println(sss.get());
        /*--------------------------------------*/
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup1 = () -> new HashSet<>(list);
        Set<String> strings = sup1.get();
        for (String s : strings) {
            System.out.println(s);
        }
        /*--------------------------------------*/
        /*Consumer (потребитель) используется в том случае, если нам нужно применить какое-то действие или операцию к
         параметру (для BiConsumer два параметра) и при этом у метода нет возвращаемого значения.*/
        Supplier<String> sup2 = () -> "New String For Interface";
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept(sup2.get());

        Comparator<Integer> intCmp = (left, right) -> Integer.compare(left, right);
        Comparator<Integer> intCmpRefToMethod = Integer::compare;

        Supplier<String> sup3 = () -> "New String For Interface";
        BiConsumer<String, String> consumer1 = (s, s1) -> System.out.println(s + s1);
        consumer1.accept(sup3.get(), " and Second String");
        /*--------------------------------------*/
        List<String> list1 = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup4 = () -> new HashSet<>(list1);
        BiConsumer<Integer, String> consumer2 = (s, s1) -> System.out.println(s + s1);
        Set<String> strings1 = sup4.get();
        int i = 1;
        for (String s : strings1) {
            consumer2.accept(i++, " is " + s);
        }
        /*--------------------------------------*/
        /* Predicate (утверждение) наиболее часто применяется в фильтрах и сравнении*/
        Predicate<String> pred = s -> s.isEmpty();
        System.out.println("Строка пустая: " + pred.test(""));
        System.out.println("Строка пустая: " + pred.test("test"));
        /*--------------------------------------*/
        BiPredicate<String, Integer> cond = (s, o) -> s.contains(o.toString());
        System.out.println("Строка содержит подстроку: " + cond.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + cond.test("Name", 123));
        /*--------------------------------------*/
       /* Function используется для преобразования входного параметра или двух параметров
         (для Bi-формы этого функционального интерфейса) в какое-либо значение, тип возвращаемого
         значения может не совпадать с типом входных параметров
         прочитать символ с определенным индексом в строке с помощью функционального интерфейса*/
        Function<String, Character> func = s -> s.charAt(2);
        System.out.println("Третий символ в строке: " + func.apply("first"));
        System.out.println("Третий символ в строке: " + func.apply("second"));
        /*--------------------------------------*/
        /*Надеемся вы обратили внимание, несмотря на то, что в лямбда выражение передается один параметр,
         в обобщенных типах мы должны указать 2 параметра – вторым параметром мы указываем тип возвращаемого
         значения (в нашем случае это Character). Давайте попробуем воспользоваться возможностями Bi-формы
         функционального интерфейса, при этом типы принимаемых значений не будут совпадать:*/
        BiFunction<String, Integer, String> biFunc = (s, j) -> s.concat(" ").concat(j.toString());
        System.out.println("Результат работы бифункции: " + biFunc.apply("Name", 123));
        System.out.println("Результат работы бифункции: " + biFunc.apply("String number", 12345));
        /*--------------------------------------*/
        /*UnaryOperator и BinaryOperator – это разновидность Function, в которых входные и выходные обобщенные параметры должны совпадать.
        * Несложно заметить, что эти два интерфейса расширяют Function и BiFunction соответственно.
        * Иначе говоря, использование этих интерфейсов сводится к применению Function и BiFunction в таких методах:
        * T apply(T t);
        * T apply(T t1, T t2);
        * Используем функциональный интерфейс UnaryOperator для того, чтобы перевернуть строку: */
        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("tset rof gnirtS")));
        /*------------Применение BinaryOperator рассмотрим на примере объединения двух строк:--------------------------*/
        BinaryOperator<StringBuilder> builder2 = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println(
                "Строка после объединения: " + builder2.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}
