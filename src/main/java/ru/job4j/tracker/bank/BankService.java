package ru.job4j.tracker.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SERGEI CHERNOV
 * @version 1.0
 * The BankService class stores clients' data and provides related services between/with their accounts
 */
public class BankService {

    /**
     * @param users hashmap is used to store all clients data.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Method adds client information into {@param users} hashmap if such account is missing
     * @param user is a client data
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Method adds account to the existing bank client
     * @param passport is the client passport data. Passport is used to find a customer in the bank {@param users} database
     * @param account is the bank account which will be assigned to the selected client
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
           List<Account> accounts = users.get(user);
           if (!accounts.contains(account)) {
              accounts.add(account);
           }
        }
    }

    /**
     * Method finds the bank client in the bank {@param users} database
     * @param passport is the client passport data.
     * @return link to an client data {@param User}
     */
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

    /**
     * Method find a bank client in the bank {@param users} database
     * @param passport  is the client passport data. Passport is used to find a customer in the bank {@param users} database
     * @param requisite is the account data which is used to find specific client's requisite
     * @return link to a bank client requisite {@Account}
     */
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

    /**
     * TransferMoney method subtract money from one account and add the same amount of money to an another account
     * @param sourcePassport is a bank client data from whom the money will be withdrawn
     * @param sourceRequisite is a bank client's account data from which the money will be withdrawn
     * @param destPassport is a bank beneficial client data to whom the money will be transfered
     * @param destRequisite is a bank beneficial client's account data to which the money will be transfered
     * @param amount is amount of money which will be transfered between accounts
     * @return true if a transfer is successful. Otherwise false.
     */
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
