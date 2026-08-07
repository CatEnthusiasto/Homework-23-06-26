package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

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

        System.out.println("\nTask 1 - Добавление продукта в корзину");
        basket.addProductInBasket(apple);
        basket.addProductInBasket(banana);
        basket.addProductInBasket(milk);
        basket.addProductInBasket(bread);
        basket.addProductInBasket(cheese);

        System.out.println("\nTask 2 - Добавление продукта в заполненную корзину");
        basket.addProductInBasket(meat); // Должно вывести сообщение о переполнении
        basket.addProductInBasket(fish);  // Должно вывести сообщение о переполнении

        System.out.println("\nTask 3 - Печать содержимого корзины с несколькими товарами");
        basket.getBasketInfo();

        System.out.println("\nTask 4 - Получение стоимости корзины с несколькими товарами");
        System.out.println("Общая стоимость: " + basket.getTotalBasketPrice());

        System.out.println("\nTask 5 - Поиск товара, который есть в корзине");
        basket.productExists("Молоко");
        basket.productExists("Яблоко");

        System.out.println("\nTask 6 - Поиск товара, которого нет в корзине");
        basket.productExists("Мясо");
        basket.productExists("Рыба");

        System.out.println("\nTask 7 - Очистка корзины");
        basket.basketClear();

        System.out.println("\nTask 8 - Печать содержимого пустой корзины");
        basket.getBasketInfo();

        System.out.println("\nTask 9 - Получение стоимости пустой корзины");
        System.out.println("Общая стоимость: " + basket.getTotalBasketPrice());

        System.out.println("\nTask 10 - Поиск товара по имени в пустой корзине");
        basket.productExists("Хлеб");
        basket.productExists("Сыр");
    }
}
