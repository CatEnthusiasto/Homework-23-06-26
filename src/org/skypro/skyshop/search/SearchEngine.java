package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.searchable.Searchable;

import java.util.ArrayList;
import java.util.List;


import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {

    private final List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public Map<String, Searchable> search(String string) {
        Map<String, Searchable> foundSearchables = new TreeMap<>();

        if (string == null) {
            System.out.println("Строка пустая!");
            return foundSearchables;
        }

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(string)) {
                foundSearchables.put(searchable.getName(), searchable);
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

        int bestIndex = 0;
        int maxCount = -1;

        for (int i = 0; i < searchables.size(); i++) {
            if (searchables.get(i) == null) {
                continue;
            }

            int count = 0;
            int index = 0;
            int foundIndex = searchables.get(i).getSearchTerm().indexOf(search,index);

            while (foundIndex != -1) {
                count++;
                index = foundIndex + search.length();
                foundIndex = searchables.get(i).getSearchTerm().indexOf(search,index);
            }
            if (count > maxCount) {
                maxCount = count;
                bestIndex = i;
            }
        }
        if (maxCount == -1) {
            throw new BestResultNotFound("Совпадений со строкой '" + search + "' не найдено!");
        } else {
            return searchables.get(bestIndex);
        }
    }
}
