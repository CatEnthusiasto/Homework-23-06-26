package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.searchable.Searchable;

import java.util.List;

public class App {

    public static void main(String[] args) {

        System.out.println("\n---Tasks 1.1-1.10---");

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

        System.out.println("\n---Tasks 2.1-2.3 + List Rework---");

        System.out.println("\nTask 2.1 - Объект типа SearchEngine, добавление всех товаров");
        SearchEngine engine = new SearchEngine();

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
        List<Searchable> founds = engine.search("ло");

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

        System.out.println("\n---Tasks 3.1-3.2---");

        System.out.println("\nTask 3.1 - Проверка исключений");

        System.out.println("\nAttempt 1");
        try {
            SimpleProduct margarin = new SimpleProduct("Маргарин", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAttempt 2");
        try {
            DiscountedProduct chicken = new DiscountedProduct(null, 50, 50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAttempt 3");
        try {
            DiscountedProduct chicken = new DiscountedProduct("Курица", 50, 101);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTask 3.2 - Проверка собственного исключения");

        System.out.println("\nAttempt 1");
        try {
            Searchable found = engine.findClosestSearchable("о");
            System.out.println("Найдено совпадение: " + found.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nAttempt 2");
        SearchEngine emptyEngine = new SearchEngine();
        try {
            Searchable found = emptyEngine.findClosestSearchable("что-то");
            System.out.println("Найдено совпадение: " + found.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nAttempt 3");
        try {
            Searchable found = engine.findClosestSearchable(null);
            System.out.println("Найдено совпадение: " + found.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n---Tasks 4.1-4.6---\n");

        ProductBasket basketNew = new ProductBasket();

        basketNew.addProductInBasket(banana);
        basketNew.addProductInBasket(milk);
        basketNew.addProductInBasket(apple);
        basketNew.addProductInBasket(milk);

        System.out.println("\nTask 4.1, 4.2 - Удалить существующие продукты из корзины и вывести их на экран");

        basketNew.removeProductByName("Молоко");

        System.out.println("\nTask 4.3 - Вывести содержимое корзины с помощью метода getBasketInfo");

        basketNew.getBasketInfo();

        System.out.println("\nTask 4.4, 4.5 - Удалить несуществующий продукт");

        basketNew.removeProductByName("Черешня");

        System.out.println("\nTask 4.6 - Повторный вывод корзины");

        basketNew.getBasketInfo();






    }
}
