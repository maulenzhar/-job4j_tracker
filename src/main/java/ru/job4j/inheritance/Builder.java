package ru.job4j.inheritance;

public class Builder extends Engineer {

    private boolean isHaveBlueprints;

    public Builder() {
    }

    public Builder(boolean isHaveBlueprints) {
        this.isHaveBlueprints = isHaveBlueprints;
    }

    public Builder(String name, String surname, String education, String birthday, boolean isHaveComputer, boolean isHaveBlueprints) {
        super(name, surname, education, birthday, isHaveComputer);
        this.isHaveBlueprints = isHaveBlueprints;
    }

    public boolean isHaveBlueprints() {
        return isHaveBlueprints;
    }

    public void setHaveBlueprints(boolean haveBlueprints) {
        isHaveBlueprints = haveBlueprints;
    }
}
