package ru.job4j.map;

import java.util.Objects;

public class Subject {
    private String subjectName;
    private int score;

    public Subject(String subjectName, int score) {
        this.subjectName = subjectName;
        this.score = score;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subject subject = (Subject) o;
        return Objects.equals(subjectName, subject.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectName);
    }

    @Override
    public String toString() {
        return "Subject{"
                + "name='" + subjectName + '\''
                + ", score=" + score
                + '}';
    }
}