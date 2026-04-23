package com.kusen.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Kusen product;

    @NotNull
    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private String sessionId;

    public CartItem() {
    }

    public CartItem(Kusen product, Integer quantity, String sessionId) {
        this.product = product;
        this.quantity = quantity;
        this.sessionId = sessionId;
    }

    public Double getTotalPrice() {
        return product.getHarga() * quantity;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
