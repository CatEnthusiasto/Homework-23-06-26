package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private final Product[] basket = new Product[5];

    public void addProductInBasket(Product product) {
        if (product == null) {
            System.out.println("Данный продукт не существует!");
            return;
        }
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                System.out.println("Продукт '" + product.getName() + "' успешно добавлен в корзину!");
                return;
            }
        }
        System.out.println("Корзина переполнена. Невозможно добавить продукт.");
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
        byte count = 0;
        for (Product product : basket) {
            if (product != null) {
                System.out.println(product);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("В корзине пусто.");
        } else {
            System.out.println("Итого: " + getTotalBasketPrice());
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
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                basket[i] = null;
            }
        }
        System.out.println("Корзина успешно очищена.");
    }
}
