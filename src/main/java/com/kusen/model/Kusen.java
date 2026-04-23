package com.kusen.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "kusen")
public class Kusen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nama produk wajib diisi")
    @Column(nullable = false)
    private String nama;

    @NotBlank(message = "Deskripsi wajib diisi")
    @Column(columnDefinition = "TEXT")
    private String deskripsi;

    @NotNull(message = "Harga wajib diisi")
    @Positive(message = "Harga harus lebih dari 0")
    @Column(nullable = false)
    private Double harga;

    @NotBlank(message = "Jenis kayu wajib diisi")
    @Column(nullable = false)
    private String jenisKayu;

    @NotNull(message = "Panjang wajib diisi")
    @Positive(message = "Panjang harus lebih dari 0")
    @Column(nullable = false)
    private Double panjang;

    @NotNull(message = "Lebar wajib diisi")
    @Positive(message = "Lebar harus lebih dari 0")
    @Column(nullable = false)
    private Double lebar;

    @NotNull(message = "Tebal wajib diisi")
    @Positive(message = "Tebal harus lebih dari 0")
    @Column(nullable = false)
    private Double tebal;

    @Min(value = 0, message = "Stok tidak boleh negatif")
    @Column(nullable = false)
    private Integer stok;

    private String gambar;

    @Column(nullable = false)
    private Boolean tersedia = true;

    private String kategori;
    private String gambarUrl;
    private String material;
    private String warna;
    private Double rating;
    private Integer terjual;

    public Kusen() {
    }

    public Kusen(String nama, String deskripsi, Double harga, String jenisKayu, 
                 Double panjang, Double lebar, Double tebal, Integer stok) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.jenisKayu = jenisKayu;
        this.panjang = panjang;
        this.lebar = lebar;
        this.tebal = tebal;
        this.stok = stok;
    }

    public Kusen(String nama, String deskripsi, Double harga, String jenisKayu, 
                 Double panjang, Double lebar, Double tebal, Integer stok, String kategori, 
                 String gambarUrl, String material, String warna, Double rating, Integer terjual) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.jenisKayu = jenisKayu;
        this.panjang = panjang;
        this.lebar = lebar;
        this.tebal = tebal;
        this.stok = stok;
        this.kategori = kategori;
        this.gambarUrl = gambarUrl;
        this.material = material;
        this.warna = warna;
        this.rating = rating;
        this.terjual = terjual;
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

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public String getJenisKayu() {
        return jenisKayu;
    }

    public void setJenisKayu(String jenisKayu) {
        this.jenisKayu = jenisKayu;
    }

    public Double getPanjang() {
        return panjang;
    }

    public void setPanjang(Double panjang) {
        this.panjang = panjang;
    }

    public Double getLebar() {
        return lebar;
    }

    public void setLebar(Double lebar) {
        this.lebar = lebar;
    }

    public Double getTebal() {
        return tebal;
    }

    public void setTebal(Double tebal) {
        this.tebal = tebal;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Boolean getTersedia() {
        return tersedia;
    }

    public void setTersedia(Boolean tersedia) {
        this.tersedia = tersedia;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getGambarUrl() {
        return gambarUrl;
    }

    public void setGambarUrl(String gambarUrl) {
        this.gambarUrl = gambarUrl;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getTerjual() {
        return terjual;
    }

    public void setTerjual(Integer terjual) {
        this.terjual = terjual;
    }
}
