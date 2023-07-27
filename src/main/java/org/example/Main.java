package org.example;

import org.example.Exeptions.AmountException;
import org.example.Exeptions.CustomerException;
import org.example.Exeptions.ProductException;
import java.util.Random;


public class Main {
    private static final int buyersSize = 2;
    private static final int productsSize = 5;
    private static final int ordersSize = 5;
    static Buyer[] buyers = new Buyer[buyersSize];
    static Product[] products = new Product[productsSize];
    static Buyer[] testBuyers = new Buyer[buyersSize + 1];
    static Product[] testProducts = new Product[productsSize + 1];
    static Order[] orders = new Order[ordersSize];
    static Random rnd = new Random();

    public static void main(String[] args) {

        buyers[0] = new Buyer("Шариков", "Полиграф", "Полиграфович", "+79647891451", 23);
        buyers[1] = new Buyer("Бегемотов", "Кот", "Котович", "+79984545422", 33);

        products[0] = new Product("Ball", 10);
        products[1] = new Product("Car", 20);
        products[2] = new Product("Airplane", 30);
        products[3] = new Product("Bear", 40);
        products[4] = new Product("Bike", 50);


        System.arraycopy(buyers, 0, testBuyers, 0, buyers.length);
        testBuyers[2] = new Buyer("Бегемот", "Ко", "Котов", "+79984545422", 31);

        System.arraycopy(products, 0, testProducts, 0, products.length);
        testProducts[5] = new Product("Bird", 60);

        int capacity = 0;
        int buyTry = 1;
        while (capacity < orders.length) {
            System.out.println("Попытка покупик № " + buyTry);
            int indexRandomBuyers = rnd.nextInt(0, 3);
            int indexRandomProducts = rnd.nextInt(0, 6);
            int randomAmount = rnd.nextInt(-1,5);
            try {
                orders[capacity] = buy(testBuyers[indexRandomBuyers], testProducts[indexRandomProducts],randomAmount);
                capacity++;
            } catch (ProductException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            } catch (AmountException e) {
                orders[capacity] = new Order(buyers[indexRandomBuyers], products[indexRandomProducts], 1);
                System.err.println(e.getMessage());
                capacity++;
            } catch (CustomerException e) {
                throw new RuntimeException(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }finally {
                System.out.println("Совершено сделок: "  + capacity);
            }
            buyTry++;
        }
        System.out.println("Всего сделок "  + capacity);
    }

    private static boolean checkData(Object[] arr, Object o) {
        for (Object object : arr) {
            if (object.equals(o))
                return true;
        }
        return false;
    }

    public static Order buy(Buyer buyer, Product product, int amount) throws Exception {
        int maxSize = 4;
        if (!(checkData(buyers, buyer)) || buyer == null)
            throw new CustomerException("Несуществующий покупатель");
        if (!(checkData(products, product)) || product == null)
            throw new ProductException("Несуществующий товар");
        if (amount <= 0 || amount > maxSize)
            throw new AmountException("Некорректное количество");
        return new Order(buyer, product, amount);
    }

}