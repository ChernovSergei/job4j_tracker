package ru.job4j.tracker.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("class: FindEL, method: indexOf"
                                                + "(String[] value, String key). "
                                                + "The key element wasn't found in the array");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] array = {"1", "2", "3"};
        String key = "2";
        try {
            indexOf(array, "5");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
