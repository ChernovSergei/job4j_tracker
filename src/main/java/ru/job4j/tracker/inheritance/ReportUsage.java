package ru.job4j.tracker.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        HTMLReport reportHTML = new HTMLReport();
        String name = "name";
        String body = "body";
        String text = report.generate(name, body);
        System.out.println(text);
        text = reportHTML.generate(name, body);
        System.out.println(text);
    }
}
