package com.restaurant.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity

@Table(name = "kategori")
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_kategori;

    @Column(nullable = false, length = 100)
    private String nama_kategori;

    @OneToMany(mappedBy = "kategori", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Menu> menu;

    public Integer getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(Integer id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }


}
