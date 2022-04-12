package com.restaurant.repository;

import com.restaurant.entity.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategoriRepository extends JpaRepository<Kategori, Integer> {
}
