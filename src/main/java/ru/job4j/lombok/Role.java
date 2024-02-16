package ru.job4j.lombok;

import lombok.*;

import java.util.List;

@Builder(builderMethodName = "of") /*Ключ builderMethodName задает имя метода создания объекта контейнера. По умолчанию он называется builder().*/
@ToString
@Getter
public class Role {
    private int id;
    private String name;

    @Singular("accessBy")/*Аннотация @Singular позволяет аккумулировать отдельные элементы коллекции. Если ее убрать, то метод accessBy должен принимать список.*/
    private List<String> accessBy;
}
