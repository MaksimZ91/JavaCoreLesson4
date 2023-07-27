# Обработка исключений
## Задание:
Написать классы покупатель (ФИО, возраст, телефон), товар (название, цена) и заказ (объект покупатель, объект товар, целочисленное количество).  
2. Создать массив покупателей (инициализировать 2 элемента), массив товаров (инициализировать 5 элементов) и массив заказов (пустой на 5 элементов).  
3. Создать статический метод «совершить покупку» со строковыми параметрами, соответствующими полям объекта заказа. Метод должен вернуть объект заказа.  
4. Если в метод передан несуществующий покупатель – метод должен выбросить исключение CustomerException, если передан несуществующий товар, метод олжен выбросить исключение ProductException, 
если было передано отрицательное или слишком больше значение количества (например, 100), метод должен выбросить исключение AmountException.  
5. Вызвать метод совершения покупки несколько раз таким образом, чтобы заполнить массив покупок возвращаемыми значениями. Обработать исключения следующим образом (в заданном порядке):  
–если был передан неверный товар – вывести в консоль сообщение об ошибке, не совершать данную покупку;  
– если было передано неверное количество – купить товар в количестве 1;  
–если был передан неверный пользователь – завершить работу приложения с исключением.  
6. Вывести в консоль итоговое количество совершённых покупок после выполнения основного кода приложения.  
### Class Buyer
```java
package org.example;

public class Buyer {
    private String surName, firstName, patronymic, phone;
    private int age;

    public Buyer(String surName, String firstName, String patronymic, String phone, int age) {
        this.surName = surName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.age = age;
    }
}
```
### Class Product
```java
package org.example;

public class Product {
    private String name;
    private int cost;

    public Product(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
```
### Class Order
```java
package org.example;

public class Order {
    private Buyer buyer;
    private Product product;
    private int count;

    public Order(Buyer buyer, Product product, int count) {
        this.buyer = buyer;
        this.product = product;
        this.count = count;
    }
}
```
###  AmountException
```java
package org.example.Exeptions;

public class AmountException extends Exception{
    public AmountException(String message) {
        super(message);
    }
}
```
###  CustomerException
```java
package org.example.Exeptions;

public class CustomerException extends  Exception{
    public CustomerException(String message) {
        super(message);
    }
}
```

###  ProductException
```java
package org.example.Exeptions;

public class ProductException extends Exception{
    public ProductException(String message) {
        super(message);
    }
}
```
### Class Main
```java
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
```
![task](https://github.com/MaksimZ91/JavaCoreLesson4/assets/72209139/4c66dcb9-200b-4479-87a1-d1a9d87ae003)
![task_result](https://github.com/MaksimZ91/JavaCoreLesson4/assets/72209139/e21e5843-cfe0-4178-be74-256abad0b45a)





