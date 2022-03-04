package ru.job4j.tracker.inheritance;

public class HTMLReport extends TextReport {

    public String generate(String name, String body) {
        return "<h1>" + name + "<h1>"
                + "<br/1>"
                + "<span>" + body + "</span>";
    }
}
