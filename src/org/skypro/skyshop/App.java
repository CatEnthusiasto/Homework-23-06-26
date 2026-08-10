package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.searchable.Searchable;

public class App {

    public static void main(String[] args) {

        SimpleProduct apple = new SimpleProduct("Яблоко", 50);
        FixPriceProduct banana = new FixPriceProduct("Банан");
        DiscountedProduct milk = new DiscountedProduct("Молоко", 120, 50);
        SimpleProduct bread = new SimpleProduct("Хлеб", 60);
        SimpleProduct cheese = new SimpleProduct("Сыр", 250);
        SimpleProduct meat = new SimpleProduct("Мясо", 500);
        SimpleProduct fish = new SimpleProduct("Рыба", 400);

        ProductBasket basket = new ProductBasket();

        System.out.println("\nTask 1.1 - Добавление продукта в корзину");
        basket.addProductInBasket(apple);
        basket.addProductInBasket(banana);
        basket.addProductInBasket(milk);
        basket.addProductInBasket(bread);
        basket.addProductInBasket(cheese);

        System.out.println("\nTask 1.2 - Добавление продукта в заполненную корзину");
        basket.addProductInBasket(meat); // Должно вывести сообщение о переполнении
        basket.addProductInBasket(fish);  // Должно вывести сообщение о переполнении

        System.out.println("\nTask 1.3 - Печать содержимого корзины с несколькими товарами");
        basket.getBasketInfo();

        System.out.println("\nTask 1.4 - Получение стоимости корзины с несколькими товарами");
        System.out.println("Общая стоимость: " + basket.getTotalBasketPrice());

        System.out.println("\nTask 1.5 - Поиск товара, который есть в корзине");
        basket.productExists("Молоко");
        basket.productExists("Яблоко");

        System.out.println("\nTask 1.6 - Поиск товара, которого нет в корзине");
        basket.productExists("Мясо");
        basket.productExists("Рыба");

        System.out.println("\nTask 1.7 - Очистка корзины");
        basket.basketClear();

        System.out.println("\nTask 1.8 - Печать содержимого пустой корзины");
        basket.getBasketInfo();

        System.out.println("\nTask 1.9 - Получение стоимости пустой корзины");
        System.out.println("Общая стоимость: " + basket.getTotalBasketPrice());

        System.out.println("\nTask 1.10 - Поиск товара по имени в пустой корзине");
        basket.productExists("Хлеб");
        basket.productExists("Сыр");

        System.out.println("\nTask 2.1 - Объект типа SearchEngine, добавление всех товаров");
        SearchEngine engine = new SearchEngine(10);

        engine.add(apple);
        engine.add(banana);
        engine.add(milk);
        engine.add(bread);
        engine.add(cheese);
        engine.add(meat);
        engine.add(fish);

        System.out.println("\nTask 2.2 - Объекты типа Article, их добавление в SearchEngine");
        Article articleOne = new Article("Убийца", "В ночь пятницы 13-й произошло очередное убийство. Жертвой оказался 30-летний мужчина, пивший молоко...");
        Article articleTwo = new Article("Колобок", "Жил был колобок, от бабушки и дедушки сбежал, в пасть к лисе вот он попал");

        engine.add(articleOne);
        engine.add(articleTwo);

        System.out.println("\nTask 2.3 - Функциональность поиска");

        System.out.println("\nAttempt 1");
        Searchable[] founds = engine.search("ло");

        for (Searchable term: founds) {
            if (term != null) {
                System.out.println(term.getStringRepresentation());
            }
        }

        System.out.println("\nAttempt 2");
        founds = engine.search("молоко");

        for (Searchable term: founds) {
            if (term != null) {
                System.out.println(term.getStringRepresentation());
            }
        }
    }
}
