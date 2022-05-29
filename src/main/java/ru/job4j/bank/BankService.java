package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        for (Map.Entry<User, List<Account>> userAcc : users.entrySet()) {
            if (user != null && user.equals(userAcc.getKey()) && !userAcc.getValue().contains(account)) {
                userAcc.getValue().add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        for (Map.Entry<User, List<Account>> userAcc : users.entrySet()) {
            if (user != null && user.equals(userAcc.getKey())) {
                for (Account acc : userAcc.getValue()) {
                    if (requisite.equals(acc.getRequisite())) {
                        return acc;
                    }
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDst = findByRequisite(destPassport, destRequisite);
        if (accountSrc != null && accountDst != null && accountSrc.getBalance() >= amount) {
            accountDst.setBalance(accountDst.getBalance() + amount);
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
