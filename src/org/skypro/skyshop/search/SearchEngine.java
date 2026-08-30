package org.skypro.skyshop.search;

import org.skypro.skyshop.comparator.ByLengthComparator;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.searchable.Searchable;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class SearchEngine {

    private final Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public Set<Searchable> search(String string) {
        Set<Searchable> foundSearchables = new TreeSet<>(new ByLengthComparator());

        if (string == null) {
            System.out.println("Строка пустая!");
            return foundSearchables;
        }

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(string)) {
                foundSearchables.add(searchable);
            }
        }
        return foundSearchables;
    }

    public void add(Searchable searchable) {
        if (searchable == null) {
            System.out.println("Данный объект пуст!");
            return;
        }
        searchables.add(searchable);
        System.out.println("Объект '" + searchable.getName() + "' успешно добавлен в массив!");
    }

    public Searchable findClosestSearchable(String search) throws BestResultNotFound {
        if (search == null) {
            System.out.println("Строка пустая!");
            throw new BestResultNotFound();
        }

        Searchable closestSearchable = null;
        int maxCount = -1;

        for (Searchable searchable: searchables) {
            int count = 0;
            int index = 0;
            int foundIndex = searchable.getSearchTerm().indexOf(search,index);

            while (foundIndex != -1) {
                count++;
                index = foundIndex + search.length();
                foundIndex = searchable.getSearchTerm().indexOf(search,index);
            }
            if (count > maxCount) {
                maxCount = count;
                closestSearchable = searchable;
            }
        }
        if (closestSearchable == null) {
            throw new BestResultNotFound("Совпадений со строкой '" + search + "' не найдено!");
        } else {
            return closestSearchable;
        }
    }
}
