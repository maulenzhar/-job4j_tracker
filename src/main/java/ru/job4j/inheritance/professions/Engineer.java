package ru.job4j.inheritance.professions;

public class Engineer extends Profession {

    private boolean isHaveComputer;

    public Engineer() {
    }

    public Engineer(boolean isHaveComputer) {
        this.isHaveComputer = isHaveComputer;
    }

    public Engineer(String name, String surname, String education, String birthday, boolean isHaveComputer) {
        super(name, surname, education, birthday);
        this.isHaveComputer = isHaveComputer;
    }

    public boolean isHaveComputer() {
        return isHaveComputer;
    }

    public void setHaveComputer(boolean haveComputer) {
        isHaveComputer = haveComputer;
    }
}
