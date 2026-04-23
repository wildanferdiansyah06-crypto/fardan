package com.kusen.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Kusen product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double harga;

    public OrderItem() {
    }

    public OrderItem(Order order, Kusen product, Integer quantity, Double harga) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.harga = harga;
    }

    public Double getTotalPrice() {
        return harga * quantity;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Kusen getProduct() {
        return product;
    }

    public void setProduct(Kusen product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }
}
