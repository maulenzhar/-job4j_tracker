package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * Если изменится модель, то нам нужно будет дописать условия.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> findByKey(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (var res : persons) {
            if (res.getName().contains(key)
                    || res.getSurname().contains(key)
                    || res.getPhone().contains(key)
                    || res.getAddress().contains(key)) {
                result.add(res);
            }
        }
        return result;
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> searchByName = s -> s.getName().contains(key);
        Predicate<Person> searchBySurname = s -> s.getSurname().contains(key);
        Predicate<Person> searchByPhone = s -> s.getPhone().contains(key);
        Predicate<Person> searchByAddress = s -> s.getAddress().contains(key);
        Predicate<Person> combine = searchByName.or(searchBySurname).or(searchByPhone).or(searchByAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
