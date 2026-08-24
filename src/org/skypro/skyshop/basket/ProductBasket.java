package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class ProductBasket {

    private final List<Product> basket = new LinkedList<>();

    public void addProductInBasket(Product product) {
        if (product == null) {
            System.out.println("Данный продукт не существует!");
            return;
        }
        basket.add(product);
        System.out.println("Продукт '" + product.getName() + "' успешно добавлен в корзину!");
    }

    public int getTotalBasketPrice() {
        int total = 0;
        for (Product product : basket) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void getBasketInfo() {
        byte countSpecial = 0;
        for (Product product : basket) {
            if (product == null) {
                continue;
            }
            System.out.println(product);
            if (product.isSpecial()) {
                countSpecial++;
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
        for (Product product: basket) {
            if (name == null) {
                System.out.println("Продукт не идентифицирован!");
                return false;
            }
            if (product != null && name.equals(product.getName())) {
                System.out.println("Продукт '" + name + "' присутствует в корзине.");
                return true;
            }
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

        Iterator<Product> iterator = basket.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                iterator.remove();
                removedProducts.add(product);
                System.out.println("Продукт с именем '" + name + "' успешно удален из корзины.");
            }
        }
        if (removedProducts.isEmpty()) {
            System.out.println("Список удаленных товаров пуст.");
        }
        return removedProducts;
    }
}
