package com.restaurant.entity;


import javax.persistence.*;

@Entity

@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_menu;

    @Column(nullable = false, length = 100)
    private String nama_menu;

    @Column(nullable = false, length =11)
    private Integer harga_menu;

    @Column(nullable = false, length = 11)
    private Integer stock_menu;

    @Column(nullable = false, length = 100)
    private String variasi;

    @ManyToOne
    @JoinColumn(name = "kategori_id")
    private Kategori kategori;

    public Integer getId_menu() {
        return id_menu;
    }

    public void setId_menu(Integer id_menu) {
        this.id_menu = id_menu;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public Integer getHarga_menu() {
        return harga_menu;
    }

    public void setHarga_menu(Integer harga_menu) {
        this.harga_menu = harga_menu;
    }

    public Integer getStock_menu() {
        return stock_menu;
    }

    public void setStock_menu(Integer stock_menu) {
        this.stock_menu = stock_menu;
    }

    public String getVariasi() {
        return variasi;
    }

    public void setVariasi(String variasi) {
        this.variasi = variasi;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }
}
