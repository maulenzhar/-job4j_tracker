package ru.job4j.lombok;

import lombok.*;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item {
    @NonNull /*Сгенерирует конструктор с полем id.
    public Item(final @NonNull int id) {
        this.id = id;
    }*/
    @Getter
    @Setter
    private int id;

    @EqualsAndHashCode.Include
    private String name;
}

/*Чтобы явно указать, какие поля использовать в equals и hashCode нунжно включить
параметр onlyExplicitlyIncuded и отметить нужные поля аннотацией @EqualsAndHashCode.Include.*/

/*@NoArgsConstructor - создается конструтор без параметров.

@AllArgsConstructor - создает конструктор со вмести полями.

@RequiredArgsConstructor - создает конструктор по полям отмеченным @NonNull*/

