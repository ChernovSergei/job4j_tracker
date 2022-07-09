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
        User user = findByPassport(passport);
        for (Account accountIterator : users.get(user)) {
            if (accountIterator.equals(account)) {
               noAccount = false;
            }
        }
        if (noAccount) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User userIterator : users.keySet()) {
            if (userIterator.getPassport().equals(passport)) {
                user = userIterator;
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
                }
            }
        }
        return result;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        User userSource = findByPassport(sourcePassport);
        Account accountSource = findByRequisite(sourcePassport, sourceRequisite);
        users.putIfAbsent(findByPassport(destPassport), new ArrayList<Account>());
        User userDest = findByPassport(destPassport);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if (accountDest.equals(null)) {
            users.get(findByPassport(destPassport)).add(new Account(destRequisite, 0D));
        }

        if (!userSource.equals(null) && !accountSource.equals(null) &&  accountSource.getBalance() >= amount) {
            accountSource.setBalance(accountSource.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            result = true;
        }

        return result;
    }
}
