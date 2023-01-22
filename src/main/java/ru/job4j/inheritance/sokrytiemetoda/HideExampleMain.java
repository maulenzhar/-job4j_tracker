package ru.job4j.inheritance.sokrytiemetoda;

/*Статический метод, определенный с той же сигнатурой в дочернем классе, называется скрытым. */
public class HideExampleMain {
    public static void main(String[] args) {
        Animal animal = new Animal(); /* создаем объект типа Animal*/
        Animal cat = new Cat(); /* создаем объект Cat типа Animal*/
        animal.instanceInvoke(); /* вызов переопределенного метода класса Animal*/
        cat.instanceInvoke(); /* вызов переопределенного метода класса Cat*/
        Animal.staticInvoke();  /* вызов статического метода класса Animal*/
        Cat.staticInvoke(); /* вызов статического метода класса Cat*/
    }
}
