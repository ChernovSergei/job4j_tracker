package ru.job4j.tracker.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
           List<Account> accounts = users.get(user);
           if (!accounts.contains(account)) {
              accounts.add(account);
           }
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User userIterator : users.keySet()) {
            if (userIterator.getPassport().equals(passport)) {
                user = userIterator;
                break;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account accountSource = findByRequisite(sourcePassport, sourceRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSource != null && accountSource != null &&  accountSource.getBalance() >= amount) {
            accountSource.setBalance(accountSource.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);

            result = true;
        }

        return result;
    }
}
