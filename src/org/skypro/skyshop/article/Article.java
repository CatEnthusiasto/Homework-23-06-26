package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String textArticle;

    public Article(String title, String textArticle) {
        this.title = title;
        this.textArticle = textArticle;
    }

    public String getTitle() {
        return title;
    }

    public String getTextArticle() {
        return textArticle;
    }

    @Override
    public String toString() {
        return title + "\n" + textArticle;
    }

    @Override
    public String getSearchTerm() {
        return title + "\n" + textArticle;
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return getTitle();
    }
}
