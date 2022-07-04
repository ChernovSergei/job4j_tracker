package ru.job4j.tracker.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        boolean noAccount = true;
        User userLink = null;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                userLink = entry.getKey();
                for (Account iterator : entry.getValue()) {
                    if (iterator == account) {
                        noAccount = false;
                        break;
                    }
                }
            }
        }
        if (noAccount) {
            users.get(userLink).add(account);
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                user = entry.getKey();
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                for (Account iterator : entry.getValue()) {
                    if (iterator.getRequisite().equals(requisite)) {
                        account = iterator;
                    }
                }
            }
        }
        return account;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result1 = false;
        boolean result2 = false;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(sourcePassport)) {
                for (Account iterator : entry.getValue()) {
                    if (iterator.getRequisite().equals(sourceRequisite) && iterator.getBalance() >= amount) {
                        iterator.setBalance(iterator.getBalance() - amount);
                        result1 = true;
                    }
                }
            }
        }
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(destPassport)) {
                for (Account iterator : entry.getValue()) {
                    if (iterator.getRequisite().equals(destRequisite)) {
                        iterator.setBalance(iterator.getBalance() + amount);
                        result2 = true;
                    }
                }
            }
        }
        return result1 && result2;
    }
}
