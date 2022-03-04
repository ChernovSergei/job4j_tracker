package ru.job4j.tracker.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student {
    private String fullName;
    private String group;
    private LocalDate entranceDate;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDate getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(LocalDate entranceDate) {
        this.entranceDate = entranceDate;
    }
}
