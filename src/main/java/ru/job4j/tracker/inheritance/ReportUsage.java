package ru.job4j.tracker.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        HTMLReport reportHTML = new HTMLReport();
        JSONReport reportJSON = new JSONReport();
        String name = "name";
        String body = "body";
        String text = report.generate(name, body);
        System.out.println(text);
        text = reportHTML.generate(name, body);
        System.out.println(text);
        text = reportJSON.generate(name, body);
        System.out.println(text);
    }
}
