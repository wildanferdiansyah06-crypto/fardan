package com.kusen.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nama tidak boleh kosong")
    @Column(nullable = false)
    private String nama;

    @Email(message = "Email tidak valid")
    @NotBlank(message = "Email tidak boleh kosong")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Telepon tidak boleh kosong")
    @Column(nullable = false)
    private String telepon;

    @NotBlank(message = "Alamat tidak boleh kosong")
    @Column(nullable = false)
    private String alamat;

    @NotNull(message = "Total tidak boleh kosong")
    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    private String sessionId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status = OrderStatus.PENDING;

    @Column(nullable = false)
    private LocalDateTime tanggalOrder = LocalDateTime.now();

    private String catatan;

    public Order() {
    }

    public Order(String nama, String email, String telepon, String alamat, Double total, String sessionId, String catatan) {
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;
        this.alamat = alamat;
        this.total = total;
        this.sessionId = sessionId;
        this.catatan = catatan;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getTanggalOrder() {
        return tanggalOrder;
    }

    public void setTanggalOrder(LocalDateTime tanggalOrder) {
        this.tanggalOrder = tanggalOrder;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}

enum OrderStatus {
    PENDING,
    CONFIRMED,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELLED
}
