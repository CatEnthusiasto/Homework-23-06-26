package org.skypro.skyshop.searchable;

public interface Searchable {
    String getSearchTerm();
    String getTypeContent();
    String getName();

    default String getStringRepresentation() {
        return "Имя: " + getName() + ", тип - " + getTypeContent();
    }
}
