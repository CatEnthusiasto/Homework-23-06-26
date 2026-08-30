package org.skypro.skyshop.comparator;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Comparator;

public class ByLengthComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        if (s2.getName().length() != s1.getName().length()) {
            return Integer.compare(s2.getName().length(),s1.getName().length());
        } else {
            return s1.getName().compareTo(s2.getName());
        }
    }
}
