package ru.job4j.collection.departaments;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int res = 0;
        String[] str1 = o1.split("/");
        String[] str2 = o2.split("/");

        for (int i = 0; i < Math.min(str1.length, str2.length); i++) {
            res = str2[0].compareTo(str1[0]);
            if (res == 0) {
                if (i + 1 < str1.length) {
                    str1[i] = str1[i + 1];
                }
                if (i + 1 < str2.length) {
                    str2[i] = str2[i + 1];
                }
                res = str1[i].compareTo(str2[i]);
                if (res != 0) {
                    return res;
                }
            }
        }
        return res;
    }
}
