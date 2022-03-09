package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.println("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("== Create a new item ==");
                System.out.println("Enter item name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("The request had been added - " + item);
            } else if (select == 1) {
                System.out.println("== Show all items ==");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Error. The archive doesn't have any requests");
                }
            } else if (select == 2) {
                System.out.println("== Replace Item ==");
                System.out.println("Enter id to replace request: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new request: ");
                String name = scanner.nextLine();
                Item newItem = new Item(name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("The request had been updated successfully");
                } else {
                    System.out.println("Error. There is no such id in the archive");
                }
            } else if (select == 3) {
                System.out.println("== Delete request ==");
                System.out.println("Enter id to delete required request: ");
                int input = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(input)) {
                    System.out.println("Selected request has been deleted successfully.");
                } else {
                    System.out.println("Error. There is no request with such id.");
                }
            } else if (select == 4) {
                System.out.println("== Find request by id ==");
                System.out.println("Enter request id to get its information: ");
                int input = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(input);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Error. There is no request with such id.");
                }
            } else if (select == 5) {
                System.out.println("== Find items by name ==");
                System.out.println("Enter request name: ");
                String input = scanner.nextLine();
                Item[] items = tracker.findByName(input);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Error. There aren't requests with \"" + input + "\" name.");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private static void showMenu() {
        String[] menu = {"Add new item", "Show all items", "Replace item", "Delete item", "Find item by id", "Find items by name", "Exit program"};
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
