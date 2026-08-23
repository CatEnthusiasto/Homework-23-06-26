package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.searchable.Searchable;

public class SearchEngine {

    private static final byte MAX_SIZE = 5;
    private final Searchable[] searchables;
    private byte count;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
        count = 0;
    }

    public Searchable[] search(String string) {
        Searchable[] foundSearchables = new Searchable[MAX_SIZE];

        if (string == null) {
            System.out.println("Строка пустая!");
            return foundSearchables;
        }

        byte count = 0;

        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] != null && searchables[i].getSearchTerm().contains(string)) {
                foundSearchables[count] = searchables[i];
                count++;
            }
            if (count == MAX_SIZE) {
                break;
            }
        }
        return foundSearchables;
    }

    public void add(Searchable searchable) {
        if (count == searchables.length) {
            System.out.println("Массив переполнен!");
            return;
        }
        if (searchable == null) {
            System.out.println("Данный объект пуст!");
            return;
        }
        searchables[count] = searchable;
        System.out.println("Объект '" + searchable.getName() + "' успешно добавлен в массив!");
        count++;
    }

    public Searchable findClosestSearchable(String search) throws BestResultNotFound {
        if (search == null) {
            System.out.println("Строка пустая!");
            throw new BestResultNotFound();
        }

        int bestIndex = 0;
        int maxCount = -1;

        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                continue;
            }

            int count = 0;
            int index = 0;
            int foundIndex = searchables[i].getSearchTerm().indexOf(search,index);

            while (foundIndex != -1) {
                count++;
                index = foundIndex + search.length();
                foundIndex = searchables[i].getSearchTerm().indexOf(search,index);
            }
            if (count > maxCount) {
                maxCount = count;
                bestIndex = i;
            }
        }
        if (maxCount == -1) {
            throw new BestResultNotFound("Совпадений со строкой '" + search + "' не найдено!");
        } else {
            return searchables[bestIndex];
        }
    }
}
