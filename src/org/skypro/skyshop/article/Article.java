package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Article article = (Article) object;
        return Objects.equals(this.title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
