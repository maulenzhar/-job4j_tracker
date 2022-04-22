package ru.job4j.inheritance.professions;

public class Doctor extends Profession {
    public boolean isCertified;

    public Doctor(String name, String surname, String education, String birthday, boolean isCertified) {
        super(name, surname, education, birthday);
        this.isCertified = isCertified;
    }

    public boolean isCertified() {
        return isCertified;
    }

    public void setCertified(boolean certified) {
        isCertified = certified;
    }
}
