package ru.job4j.inheritance.professions;

public class Dentist extends Doctor {

    private boolean isPullOutTooth;

    public Dentist() {
    }

    public Dentist(boolean isPullOutTooth) {
        this.isPullOutTooth = isPullOutTooth;
    }

    public Dentist(String name, String surname, String education, String birthday, boolean isCertified, boolean isPullOutTooth) {
        super(name, surname, education, birthday, isCertified);
        this.isPullOutTooth = isPullOutTooth;
    }

    public boolean isPullOutTooth() {
        return isPullOutTooth;
    }

    public void setPullOutTooth(boolean pullOutTooth) {
        isPullOutTooth = pullOutTooth;
    }
}
