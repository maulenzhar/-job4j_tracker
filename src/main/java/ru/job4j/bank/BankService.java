package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу внутрибанковской системы
 *
 * @author Maulen Zharylgasynov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение клиентов осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход клиента и добавляем в коллекцию users
     *
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает паспорт и аккаунт клиента.
     * По паспорту находим клиента.
     * Если у клиента нет добавляемого аккаунта, то добавляем
     *
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> listAccounts = users.get(user);
            if (!listAccounts.contains(account)) {
                listAccounts.add(account);
            }
        }
    }

    /**
     * Метод ишет клиента по паспорту
     *
     * @param passport
     * @return
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет аккаунт клиента по реквизиту
     *
     * @param passport
     * @param requisite
     * @return
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод переводит денежные средства с одного счета на другой
     * если сумма переда хватает у источника
     *
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param destRequisite
     * @param amount
     * @return
     */
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
