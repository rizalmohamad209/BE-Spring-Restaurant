package com.restaurant.repository;

import com.restaurant.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    @Query("SELECT m FROM Menu m INNER JOIN m.kategori k WHERE m.nama_menu LIKE %?1%")
    List<Menu> searchMenu(String search);
            
}
