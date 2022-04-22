package ru.job4j.inheritance.professions;

public class Surgeon extends Doctor {

    private boolean isOperating;

    public Surgeon(String name, String surname, String education, String birthday, boolean isCertified, boolean isOperating) {
        super(name, surname, education, birthday, isCertified);
        this.isOperating = isOperating;
    }

    public boolean isOperating() {
        return isOperating;
    }

    public void setOperating(boolean operating) {
        isOperating = operating;
    }
}
