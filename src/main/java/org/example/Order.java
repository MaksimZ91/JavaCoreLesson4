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
