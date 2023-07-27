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

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
