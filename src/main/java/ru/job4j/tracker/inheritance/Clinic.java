package ru.job4j.tracker.inheritance;

public class Clinic {
    public static void main(String[] args) {
        Pacient vasiliy = new Pacient("Vasiliy", "Gerasimov", 12012000L);
        Pacient elena = new Pacient("Elena", "Taisovna", 3101993L);
        Surgeon gelyamov = new Surgeon("Andrey", "Gelyamov", "Sergeon", 3081959L, 58291, "Cardiothoracic");
        Dentist ushakov = new Dentist("Pavel", "Ushakov", "Dentist", 13061985L, 4983121, "Invasive");
        ushakov.cureTooth(4, "taken out", vasiliy);
        gelyamov.surge("Jugular has been bypassed", elena);
    }
}
