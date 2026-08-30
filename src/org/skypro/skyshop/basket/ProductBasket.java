package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private final Map<String, List<Product>> basket = new HashMap<>();

    public void addProductInBasket(Product product) {
        if (product == null) {
            System.out.println("Данный продукт не существует!");
            return;
        }
        basket.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
        System.out.println("Продукт '" + product.getName() + "' успешно добавлен в корзину!");
    }

    public int getTotalBasketPrice() {
        int total = 0;
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void getBasketInfo() {
        byte countSpecial = 0;
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                System.out.println(product);
                if (product.isSpecial()) {
                    countSpecial++;
                }
            }
        }
        if (getTotalBasketPrice() == 0) {
            System.out.println("В корзине пусто.");
        } else {
            System.out.println("Итого: " + getTotalBasketPrice());
            System.out.println("Специальных товаров: " + countSpecial);
        }
    }

    public boolean productExists(String name) {
        if (name == null) {
            System.out.println("Продукт с таким названием не существует!");
            return false;
            }
        if (basket.containsKey(name)) {
            System.out.println("Продукт '" + name + "' присутствует в корзине.");
            return true;
        }
        System.out.println("Продукт '" + name + "' отсутствует в корзине!");
        return false;
    }

    public void basketClear() {
        basket.clear();
        System.out.println("Корзина успешно очищена.");
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = new LinkedList<>();

        if (basket.containsKey(name)) {
            removedProducts = basket.get(name);
            basket.remove(name);
        } else {
            System.out.println("Продукта(ов) с данным названием в корзине нет!");
        }
        return removedProducts;
    }
}
