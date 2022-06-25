package ru.job4j.tracker.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("sun@yandex.ru", "Sun Milky");
        map.put("uran@gmail.com", "Uran Milky");
        for (String key : map.keySet()) {
            String planet = map.get(key);
            System.out.println(key + " = " + planet);
        }
    }
}
