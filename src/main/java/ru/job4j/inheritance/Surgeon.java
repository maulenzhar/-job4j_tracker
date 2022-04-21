package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private boolean IsOperating;

    public Surgeon() {
    }

    public Surgeon(boolean isOperating) {
        IsOperating = isOperating;
    }

    public Surgeon(String name, String surname, String education, String birthday, boolean isCertified, boolean isOperating) {
        super(name, surname, education, birthday, isCertified);
        IsOperating = isOperating;
    }

    public boolean isOperating() {
        return IsOperating;
    }

    public void setOperating(boolean operating) {
        IsOperating = operating;
    }
}
